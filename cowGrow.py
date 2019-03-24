#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"
# 有一对奶牛，从出生后的第四年开始生小牛，每次生一对小牛，问现在有m对小牛，在第n年后有多少奶牛？
#
# 此题和其他的生兔子什么的都一样，只不过其开始的第一年是第一对奶牛开始生奶牛的那一年，因此在解此题是，需要在以往的递归中加上三年。
while True:
    try:
        def cal(n):
            if n == None:
                return
            if n <= 3:
                return 1
            return cal(n-1) + cal(n-3)#上一年的牛 + 今年出生的牛
        m = int(input())
        n = int(input())
        num = m * cal(n+3)
        print(num)
    except:
        break

