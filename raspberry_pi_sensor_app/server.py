import socket, select, dht11, json
from datetime import datetime
from _thread import start_new_thread
from time import sleep
from RPi import GPIO as gpio

IP = "127.0.0.1"
PORT = 5000
BACKLOG = 4096

sensor = False
data = {
    "time": datetime.now().strftime('%d-%m-%Y %H:%M:%S'),
    "temp": False,
    "humi": False
}

def record_date():
    sleep(1)
    data.time = datetime.now().strftime('%d-%m-%Y %H:%M:%S')

def pi_setup():
    global sensor
    gpio.setwarnings(False)
    gpio.setmode(gpio.BCM)
    gpio.cleanup()
    sensor = dht11.DHT11(pin=17)

def record_sensor():
    global data, sensor
    while True:
        sleep(1)
        sensor_data = sensor.read()
        if(sensor_data.is_valid()):
            data = {
                "time": datetime.now().strftime('%d-%m-%Y %H:%M:%S'),
                "temperature": sensor_data.temperature,
                "humidity": sensor_data.humidity
            }
            print(data.temperature)
    
def server():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server.bind((IP, PORT))
        server.listen(BACKLOG)
        
        #conn.close()

if __name__ == "__main__":
    #pi_setup()
    #start_new_thread(record_sensor, ())
    start_new_thread(record_date, ())
    server()