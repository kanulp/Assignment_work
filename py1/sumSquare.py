def sumSquare( n) : 
    i = 1 
    while i * i <= n : 
        j = 1
        while(j * j <= n) : 
            if (i * i + j * j == n) : 
                print(i, "^2 + ", j , "^2" ) 
                return True
            j = j + 1
        i = i + 1
          
    return False
   
# driver Program
print("Enter N Value")
n = int(input())
if (sumSquare(n)) : 
    print("Yes,It can be written as Sum of Squares") 
else : 
    print( "No,It cannot be written as sum of Squares") 
