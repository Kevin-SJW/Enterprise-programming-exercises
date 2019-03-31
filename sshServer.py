#coding:utf-8

import socket, os, hashlib

server = socket.socket()
server.bind(("localhost", 50000))
server.listen()

while True:
    print("wait for client to connect：")
    conn, addr = server.accept()
    print("new connect:", addr)
    while True:
        try:
            cmd, file_name = conn.recv(1024).decode().split()
        except:
            break

        if os.path.isfile(file_name):
            f = open(file_name, 'rb')
            m = hashlib.md5()
            filesize = os.stat(file_name).st_size
            print('filesize:', filesize)
            conn.send(str(filesize).encode(encoding='utf-8'))
            ack = conn.recv(1024)
            for line in f:
                m.update(line)  # .encode(encoding='utf-8')
                conn.send(line)  # .encode(encoding='utf-8')
            print('server send file md5:', m.hexdigest())
            f.close()
            conn.send(m.hexdigest().encode(encoding='utf-8'))  #
            print("send done")

server.close()

