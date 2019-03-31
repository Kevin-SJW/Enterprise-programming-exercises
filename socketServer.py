#coding:utf-8
import socket

server = socket.socket()  # 获得socket实例

server.bind(("localhost", 9998))  # 绑定ip port
server.listen()  # 开始监听
print("等待客户端的连接...")
conn, addr = server.accept()  # 接受并建立与客户端的连接,程序在此处开始阻塞,只到有客户端连接进来...
print("新连接:", addr)

data = conn.recv(1024)
print("收到消息:", data)

server.close()

