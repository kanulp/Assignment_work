def count_growlers(animals):
  le = len(animals)
  left = ['cat','dog']
  #right = ['tac','god' ]
  ans = 0
  for i in range(le):
    if animals[i] in left:
      dog = 0
      cat = 0
      for j in range(0,i):
        if animals[j]=='dog' or animals[j]=='god':
          dog+=1
        elif animals[j]=='cat' or animals[j]=='tac':
          cat+=1
      if dog>cat:
        ans+=1
    else:
      dog = 0
      cat = 0
      for j in range(i+1, le):
        if animals[j] == 'dog' or animals[j]=='god':
          dog += 1
        elif animals[j] == 'cat' or animals[j]=='tac':
          cat += 1
      if dog > cat :
        ans += 1
  print(ans)

animals = []
n = int(input("enter the no of inputs "))
for k in range(n):
  animals.append(input())
count_growlers(animals)

