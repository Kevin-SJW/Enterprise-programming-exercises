#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"

# 给定一维数组，要求找出数组中一个数，使得该数等于左边之和同时也等于右边之和，
# 如果有多个仅输出第一个，如果没有则返回false
# 输入：每行数字为一个数组，数组元素用逗号分隔
# 输出：要求输出为一个数字或者false
# 样例输入：3，1，4，4
# 样例输出：4
A = list(map(int, input().split(',')))


def foo(A):
    for i in range(1, len(A) - 1):

        if sum(A[:i]) == A[i] and A[i] == sum(A[i + 1:]):
            return i

    return False


ret = foo(A)
if ret:
    print(A[ret])
else:
    print("False")
