import socket

IP = socket.gethostname()

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((IP, 5000))
    while True:
        data = s.recv(1024)
        print(data.decode("utf-8"))