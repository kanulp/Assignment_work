def remove_after_kth(items, k = 1):
  le = len(items)
  ans = []
  ans.append(items[0])
  for i in range(1,le):
    count = 0
    for j in range(0,i):
      if items[j]==items[i]:
        count+=1
    if count<k:
     ans.append(items[i])
  print(*ans)

items = []
n = int(input("enter the no of inputs"))
for i in range(n):
  items.append(int(input()))
k = int(input("enter the value of k"))
remove_after_kth(items,k)