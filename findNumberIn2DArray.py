#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"

class Solution():
    def find(self,target,array):
        n=len(array)
        flag='false'
        for i in range(n):
            if target in array[i]:
                flag = 'true'
                break
            return flag

while True:

    try:
        s = Solution()
        L=list(eval(input("请输入一个二维数组和整数")))
        target= L[0]
        array= L[1]
        print(s.find(target,array))
    except:
        break



