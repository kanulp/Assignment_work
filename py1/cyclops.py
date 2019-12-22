def is_cyclops(n):
  le = len(str(n))
  if le>=1:
    b = str(n)
    count=0
    for j in range(le):
      h = b[j]
      if h=='0':
        count+=1
    if count==1:
      mid = le//2
      if b[mid]=='0':
        print("True")
      else:
        print("False")
    else:
      print("False")
  elif le==1:
    b = str(n)
    if b[0]=='0':
      print("True")
    else:
      print("False")
#driver program
n = int(input("enter the input number"))
is_cyclops(n)
