#coding:utf-8

import socket, sys, hashlib

client = socket.socket()

client.connect(("localhost", 50000))

while True:
    send_cmd = input(">>:")
    if send_cmd == 0:
        continue
    if send_cmd.startswith('get'):
        client.send(send_cmd.encode(encoding='utf-8'))
        server_response = client.recv(1024)
        client.send(b'ready')
        file_total_size = int(server_response.decode())
        print("file_total_size:", file_total_size)
        recv_size = 0
        recv_data = b''
        count = 0
        filename = send_cmd.split()[1]
        f = open(filename + 'new', 'wb')
        m = hashlib.md5()

        while recv_size != file_total_size:
            if file_total_size - recv_size > 1024:
                size = 1024
            else:
                size = file_total_size - recv_size
                print('last recv_size:', recv_size)
            data = client.recv(size)
            recv_size += len(data)
            m.update(data)
            f.write(data)
            f.flush()
            print('recv_size:', recv_size, 'file_total_size:', file_total_size)
        else:
            new_file_md5 = m.hexdigest()
            server_datamd5 = client.recv(1024).decode()
            print("file recv done", recv_size, file_total_size)
            print("new_file_md5:", new_file_md5)
            print('server_datamd5:', server_datamd5)

client.close()

