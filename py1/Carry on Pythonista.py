
def carry_number(a, b):
    po=0
    if (a==0 and b==0):
        return 0
    z=0
    for i in reversed(range(10)):
        z=a%10+b%10+z
        if z>9:
            z=1
        else:
            z=0
        po+=z
        a//=10
        b//=10
    if po==0:
        print('0')
    elif po == 1:
        print(po)
    else:
        print(po)

a = int(input("enter the num1"))
b = int(input("enter the num2"))
carry_number(a, b)
