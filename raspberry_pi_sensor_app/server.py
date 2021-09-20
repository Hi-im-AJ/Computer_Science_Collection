import socket
from datetime import datetime
from _thread import start_new_thread
from time import sleep
import select

IP = "127.0.0.1"
PORT = 5000
BACKLOG = 4096

time = datetime.now().strftime('%d-%m-%Y %H:%M:%S')

def counter():
    global time
    while True:
        time = datetime.now().strftime('%d-%m-%Y %H:%M:%S')
        sleep(1)
    
def server_setup():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR)
        server.bind((IP, PORT))
        server.listen(BACKLOG)
        
        #conn.close()

if __name__ == "__main__":
    start_new_thread(counter, ())
    server_setup()