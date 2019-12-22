def first_preceded_by_smaller(items, k = 1):
  le = len(items)
  ik = 0
  for i in range(1,le):
    count = 0
    for j in range(0,i):
      if items[j]<items[i]:
        count+=1
    if count>=k:
        return print(items[i])
        ik = items[i]
        break;
  return print("None")

items = []
n = int(input("enter the no of inputs"))
for i in range(n):
  items.append(int(input()))
k = int(input("enter the value of k"))
first_preceded_by_smaller(items,k)