#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"
n = int(input())

s = []
for _ in range(n):
    s.append(input())

s.sort(reverse=True)
#print(s)

ans = ''.join(s)

print(int(ans))  # 转 int