def count_divisibles_in_range(start, end, n):
    count=0
    if(start > end):
        print("Invalid Input")
        return
    else:
    
        for i in range (start,end+1):
            if(i % n ==0):
                count +=1
    print("The Number of numbers divisible by n are : ",count)

#driver program
start=int(input())
end=int(input())
n=int(input())
count_divisibles_in_range(start,end,n)
