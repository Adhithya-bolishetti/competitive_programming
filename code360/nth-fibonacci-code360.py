from math import *
from collections import *
from sys import *
from os import *

## Read input as specified in the question.
## Print output as specified in the question.
n=int(input())
if(n==1):
    print(1)
elif(n==2):
    print(2)
else:
    f1=1
    f2=1
    sum=0
    for _ in range(1,n-1):
        sum=f1+f2
        f1=f2
        f2=sum
    print(sum)
