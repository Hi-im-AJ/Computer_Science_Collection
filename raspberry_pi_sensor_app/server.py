import socket, select, dht11, json
from Crypto.Cipher import AES;
from datetime import datetime
from _thread import start_new_thread
from time import sleep
from RPi import GPIO as gpio

IP = "10.200.130.32"
PORT = 5000
BACKLOG = 5

sensor = False
data = {
    "time": datetime.now().strftime('%d-%m-%Y %H:%M:%S'),
    "temperature": False,
    "humidity": False
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

def encrypt(msg):
    obj = AES.new(b"0123456789012345", AES.MODE_CBC, b"0123456789012345")
    return obj.encrypt(msg)

def server():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server.bind((IP, PORT))
        server.listen(BACKLOG)
        print(f"server running on {IP}:{PORT}")

        while True:
            client, addr = server.accept()
            print(f"{addr} connected")
            time = data["time"]
            temp = data["temperature"]
            humi =data["humidity"]
            msg = f"{time};{temp};{humi}"
            msg = encrypt(msg)
            client.send(msg.encode("utf-8"))
            sleep(1)

        
        server.close()

if __name__ == "__main__":
    pi_setup()
    start_new_thread(record_sensor, ())
    server()