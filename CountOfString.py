#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"
s = input()
'''
首字符移到末尾，并记录所得的字符串，不断重复操作，
那么，一共记录了多少不同的字符串。
'''
def foo(s):
    for i in range(1, len(s)+1):
        if len(s) % i == 0:
            if s[:i] * (len(s) // i) == s:
                return i

print(foo(s))