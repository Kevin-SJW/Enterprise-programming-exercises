#coding:utf-8
import os
#计算指定区间包含的子串
#73% AC
os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"
A = input()
B = input()
Q = int(input())

for _ in range(Q):
    l, r = list(map(int, input().split()))
    print(A[l-1: r].count(B))

