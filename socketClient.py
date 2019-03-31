#coding:utf-8

import socket

client = socket.socket()

client.connect(("localhost", 9998))

client.send(b"hey")

client.close()