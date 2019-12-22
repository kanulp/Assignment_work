def recaman(n): 
  
    if(n <= 0): 
        return
  
    print(0, ",", end='') 
    s = set([]) 
    s.add(0) 
    prev = 0
    for i in range(1, n): 
        curr = prev - i 
        if(curr < 0 or curr in s): 
            curr = prev + i 
        s.add(curr) 
        print(curr, ",", end='') 
        prev = curr 
  
# Driver code 
n = int(input())
recaman(n)
