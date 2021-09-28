import socket
from Crypto.Cipher import AES

IP = "10.200.130.32"

def decrypt(ciphertext):
    obj = AES.new("0123456789012345", AES.MODE_CBC, "0123456789012345")
    return obj.decrypt(ciphertext)

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((IP, 5000))
    while True:
        data = s.recv(1024)
        data = data.decode("utf-8") #.split(";")
        print(decrypt(data))
        for i in data:
            print(data[i])
        s.close()