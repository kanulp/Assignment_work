def maximum_difference_sublist(items, k):
  le = len(items)
  total = le-(k-1)
  high = []
  for i in range(0,total):
    sub = []
    for j in range(0,k):
      sub.append(items[i+j])
    a = max(sub)
    b = min(sub)
    high.append(a-b)
  o = max(high)
  f = high.index(o)
  for p in range(f,f+k):
    print(items[p],end=' ')

items = []
n = int(input("enter the no of inputs"))
for h in range(n):
    items.append(int(input()))
k = int(input("enter the value of k"))
maximum_difference_sublist(items,k)