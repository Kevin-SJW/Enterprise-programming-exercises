#coding:utf-8
import os

os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"

from string import digits,ascii_lowercase,ascii_uppercase

Alphabet =digits+ascii_uppercase+ascii_lowercase
print(Alphabet)

def any2ten(s,base=62):
    n=0
    for i,c in enumerate(reversed(s)):
        index=Alphabet.index(c)
        n += index*pow(base,i)
    print("result:",n)


any2ten('1234')