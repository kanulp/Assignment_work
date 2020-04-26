import string
import random
import re

def chooseOption():
    print('Welcome to the vendor app.\nChoose option : \n1.Register\n2.Login\n3.Exit')
    myInput = int(input("Enter your choice : "))
    print(myInput)
    if myInput == 1 :
        register()
    elif myInput == 2 : 
        login()
    elif myInput == 3 :
        exit()
    else:
        print('Invalid Choice')

def login():
    Username = input("Enter Your Username : ")
    password = input("Enter Your Password : ")
    if Username == 'admin' :
        if password == 'admin':
            print('Login Sucessful')
    else:
        print('Invalid')
        
def register():
    print('Enter your details')
    Username = input("Enter Your Username : ")
    #password = input("Enter Your Password : ")
    CheckPassword()
    #print(CheckPassword())
    age = input("Enter Your Age : ")
    address = input("Enter Your Address : ")
    print(f'Your Details : Username : {Username}  Age : {age} Address: {address}')

def CheckPassword ():
    #password = passWord
    flag = 1
    password_dict = {}
    while 1 :   
        password = input('Enter pass : ')
        if (len(password)<8): 
            flag = -1
            password_dict[1] = "Should be more than 8 characters"
            #break
            print(printError(password_dict.values()))

        elif not re.search("[a-z]", password): 
            flag = -1
            password_dict[2] = "Should contain at least one character small letter"
            print(printError(password_dict.values()))
            #break
        elif not re.search("[A-Z]", password): 
            flag = -1
            password_dict[3] = "Should contain at least one character capital letter"
            print(printError(password_dict.values()))
            #break
        elif not re.search("[0-9]", password): 
            flag = -1
            password_dict[4] = "Should contain at least one number"
            print(printError(password_dict.values()))

            #break
        elif not re.search("[_@$]", password): 
            flag = -1
            password_dict[5] ="Should contain at least one special character (_@$)"
            print(printError(password_dict.values()))
            #break
        else: 
            flag = 0
            break
            #return "Valid Password"
            
    if flag ==-1:
        print('Enter password with length of 8 and one capital, small, special character e.g. ABxy@123''')
        print(printError(password_dict.values()))
        #CheckPassword(password)
    
        
def printError(errStr):
    values = list(errStr)
    return values

#print(CheckPassword.__doc__)
    
