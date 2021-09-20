import socket
from _thread import start_new_thread
from time import sleep

IP = "127.0.0.1"
PORT = 5000
BACKLOG = 4096

def server_setup():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR)
        server.bind((IP, PORT))
        server.listen(BACKLOG)
        
        #conn.close()

if __name__ == "__main__":
    server_setup()