def domino_cycle(tiles):
  le = len(tiles)
  if le==0:
    print("False")
  elif le>=1:
   if tiles[0][0]==tiles[le-1][1]:
    count = 1
    for j in range(le-1):
      if tiles[j][1]==tiles[j+1][0]:
        count+=1
      else:
        print("False")
        break;
    if count == le:
      print("True")
   else:
    print("False")


tiles= []
n = int(input("enter the size of list"))
for i in range(n):
   tiles.append(tuple(map(int, input().split(" "))))
domino_cycle(tiles)