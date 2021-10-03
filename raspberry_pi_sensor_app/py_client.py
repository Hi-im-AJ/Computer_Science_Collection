import socket, ENV, json
from Crypto.Cipher import AES
from base64 import b64decode
from time import sleep

IP = "localhost"
KEY = ENV.KEY

def decrypt(msg):
    nonce, ciphertext, tag = (b64decode(msg[i]) for i in ["nonce", "ciphertext", "tag"])
    cipher = AES.new(KEY, AES.MODE_EAX, nonce)
    msg = cipher.decrypt_and_verify(ciphertext, tag)
    return msg.decode("utf-8")

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as conn:
    conn.connect((IP, 5000))
    while True:
        msg = conn.recv(1024)
        msg = msg.decode("utf-8")
        msg = json.loads(decrypt(json.loads(msg)))
        print(msg["time"])
        sleep(1)
    s.close()
