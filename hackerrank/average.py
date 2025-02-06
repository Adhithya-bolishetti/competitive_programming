def average(array):
    s=set(array)
    sums=0
    size=len(s)
    for i in s:
        sums+=i
    ans=sums/size
    return ans

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    result = average(arr)
    print(result)