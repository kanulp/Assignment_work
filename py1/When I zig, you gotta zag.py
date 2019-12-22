def create_zigzag(rows, cols, start = 1):
  li = []
  for i in range(row):
    subli = []
    if i%2==0:
      for j in range(col):
         subli.append(start)
         start+=1
      li.append(subli)
    else:
      sum = start
      for j in range(col):
        subli.append(sum-1+col-j)
        start+=1
      li.append(subli)
  print(li)

row = int(input("enter the no of rows"))
col = int(input("enter the no of cols"))
start = int(input("enter the start value"))
create_zigzag(row,col,start)