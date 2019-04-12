#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"
'''
在一个小岛上，一开始有一条小狗，从出生起第三个月可以繁衍下一只狗，
同样，小狗生长三个月后，每月生产一只，狗不死，第n个月有几只？
菲波那切数列
'''

n=int(input())

dp=[1,1]
for i in range(2,n):
    dp.append(dp[i-1]+dp[i-2])

print(dp[n-1])