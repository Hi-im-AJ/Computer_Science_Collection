import socket, ENV, json
from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
from base64 import b64decode
from time import sleep

def decrypt(jsonObj):
    iv, ct = (b64decode(jsonObj[i]) for i in ["iv", "ct"])
    cipher = AES.new(ENV.KEY, AES.MODE_CBC, iv)
    pt = unpad(cipher.decrypt(ct), AES.block_size)
    return pt

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as conn:
    conn.connect((ENV.CLIENT_IP, ENV.PORT))
    while True:
        msg = conn.recv(1024)
        msg = msg.decode("utf-8")
        msg = json.loads(decrypt(json.loads(msg)))
        print(msg["time"])
        sleep(1)
    s.close()
