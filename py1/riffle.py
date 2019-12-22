def riffle(items, out):
  ans = []
  l = len(items)//2
  if out=='True':
    for i in range(0,l):
      ans.append(items[i])
      ans.append(items[i+l])
    print(*ans)
  elif out=='False':
    for i in range(0,l):
      ans.append(items[i+l])
      ans.append(items[i])
    print(*ans)

items = []
n = int(input("enter the size of items"))
if n>=2:
  for j in range(n):
    items.append(int(input()))
  out = input("enter True/False ")
else:
  out = input("enter True/False")
riffle(items,out)









