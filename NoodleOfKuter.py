#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"
'''
他将面条放在了数轴上，每个面条对应数轴上的a和b，
他想知道在任意两根面条不重叠的情况下最多可以选出多少根面条。
思路

贪心
最大不重叠区间
贪心（AC）
'''
N=int(input())
line = []

for _ in range(N):
    a,b=sorted(list(map(int,input().split())))
    line.append([a,b])

line.sort(key=lambda a:a[1])
# print(line)
ret=[line[0]]
for item in line[1:]:
    if item[0]<ret[-1][1]:
        pass
    else:
        ret.append(item)

print(len(ret))

# N = int(input())
#
# line = []
# for _ in range(N):
#     a, b = sorted(list(map(int, input().split())))
#     line.append([a, b])
#
# # line.sort()
# line.sort(key=lambda a: a[1])
# # print(line)
# ret = [line[0]]
# for item in line[1:]:
#     if item[0] < ret[-1][1]:
#         pass
#     else:
#         ret.append(item)
#
# print(len(ret))


