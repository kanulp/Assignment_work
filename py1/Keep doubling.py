def double_until_all_digits(n, giveup):
  ink = 1
  for i in range(giveup):
    ink += 1
    if len(str(n))>=10:
      b = str(n)
      nu = []
      for j in range(10):
        if str(j) in b and str(j) not in nu:
            nu.append(str(j))
      if len(nu)==10:
        print(i)
        break;
      else:
        n*=2
    else:
      n *= 2
  if ink-1==giveup:
    print('-1')
n = int(input("enter the number"))
giveup = int(input("enter the limit"))
double_until_all_digits(n,giveup)