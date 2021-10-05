import socket, ENV, json #, dht11
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
from base64 import b64encode
from datetime import datetime
from _thread import start_new_thread
from time import sleep
#from RPi import GPIO as gpio

BACKLOG = 5

sensor = False
data = {
    "time": datetime.now().strftime('%d-%m-%Y %H:%M:%S'),
}

def record_date():
    sleep(1)
    data.time = datetime.now().strftime('%d-%m-%Y %H:%M:%S')

"""
def pi_setup():
    global sensor
    gpio.setwarnings(False)
    gpio.setmode(gpio.BCM)
    gpio.cleanup()
    #sensor = dht11.DHT11(pin=17)
"""

def record_sensor():
    global data, sensor
    while True:
        sleep(1)
        """
        sensor_data = sensor.read()
        if(sensor_data.is_valid()):
            data["time"] = datetime.now().strftime('%d-%m-%Y %H:%M:%S')
            data["temp"] = sensor_data.temperature
            data["humi"] = sensor_data.humidity
        """
        data["time"] = datetime.now().strftime('%d-%m-%Y %H:%M:%S')

def encrypt(msg):
    cipher = AES.new(ENV.KEY, AES.MODE_CBC)
    ct_bytes = cipher.encrypt(pad(msg, AES.block_size))
    iv, ct = (b64encode(i).decode('utf-8') for i in [cipher.iv, ct_bytes])
    return json.dumps({'iv': iv, 'ct': ct})

def handle_socket(client):
    while True:
        try:
            json_msg = json.dumps(data)
            client.send(encrypt(json_msg.encode("utf-8")).encode("utf-8"))
        except:
            client.close()
        sleep(1)

def server():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server.bind((ENV.SERVER_IP, ENV.PORT))
        server.listen(BACKLOG)
        print(f"server running on {ENV.SERVER_IP}:{ENV.PORT}")

        while True:
            client, addr = server.accept()
            print(f"{addr} connected")
            start_new_thread(handle_socket, ((client, )))

        server.close()


if __name__ == "__main__":
    # pi_setup()
    start_new_thread(record_sensor, ())
    server()
