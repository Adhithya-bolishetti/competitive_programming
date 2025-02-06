n=int(input())
d={}
for _ in range(n):
    *item_name,net_price=input().split(" ")
    item_name=" ".join(item_name)
    net_price=int(net_price)
    if item_name not in d:
        d[item_name]=net_price
    else:
        d[item_name]+=net_price
for key,value in d.items():
    print(f"{key} {value}")