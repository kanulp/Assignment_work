def tukeys_ninthers(items):
  le = len(items)
  while(le!=1):
    total = le//3
    for i in range(0,total,3):
      fu = []
      fu.append(items[i])
      fu.append((items[i+1]))
      fu.append(items[i+2])
      a = max(fu)
      b = min(fu)
      f = items.index(a)
      items.pop(f)
      l = items.index(b)
      items.pop(l)
    le = len(items)
  print(*items)

items = []
n = int(input('no.of inputs to be entered'))
for j in range(n):
    items.append(int(input()))
tukeys_ninthers(items)