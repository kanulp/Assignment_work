def ztalloc(shape):
    z = shape[::-1]
    num = 2
    for i in range(1,len(z)):
        if z[i]=='d':
            num = num*2
        elif z[i]=='u':
            w = (num-1)
            if w%3==0:
                num = w//3
            else:
                return print("None")
                break
    print(num)

shape = input("enter the string")
ztalloc(shape)