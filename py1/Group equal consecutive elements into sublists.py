def group_equal(items):
  li = []
  check = []
  while(len(items)!=0):
    subli = []
    i = 1
    subli.append(items[0])
    if len(items)==1:
        items.pop()
    for j in range(i,len(items)):
       if items[0]==items[j]:
        subli.append(items[j])
       else:
        items=items[j:]
        break
    li.append(subli)

  print(li)

items = []
n = int(input("enter the size of items"))
for i in range(n):
    items.append(int(input()))
group_equal(items)