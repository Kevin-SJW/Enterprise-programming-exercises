#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"

from string import digits, ascii_uppercase, ascii_lowercase

Alphabet = digits + ascii_lowercase + ascii_uppercase

print ("Alphabet:",Alphabet)

#iteration
def ten2any(n,b=62):
    ret =""
    while n>0:
        n,index = divmod(n,b)
        ret = Alphabet[index]+ret
    # return ret
    print(ret)

##recursion
def ten2any_2(n,b=62):
    pass
    ret=""
    n,index=divmod(n,b)
    if n>0:
        # return ten2any_2(n,b)+Alphabet[index]
        print(ten2any_2(n,b)+Alphabet[index])
    else:
        # return Alphabet[index]
        print(Alphabet[index])


ten2any(10)
ten2any_2(11)

