def check_email(email):

    lflag = False
    nflag = False
    pflag = False
    
    splitStr = email.split('@'); #separating string with @

    if len(splitStr) is not 2: #checking if length is not enough for email
        return False

    if (len(splitStr[0]) == 0 or len(splitStr[1]) == 0): #checking if length is 0 for both the 2 split string
        return False;

    for l in splitStr[0]: #checking alpha,digit and - and setting flags accoring to it
        if(l.isalpha()):
            lflag = True
        if(l.isdigit()):
            nflaf = True
        if(l == '-' or l == '_'):
            pflag = True
    
    if(not lflag or not pflag): #checking with flags for correct email part
        return False
        
    if("." not in splitStr[1]): #checking is . is not there 
        return False;

    strSplit = splitStr[1].split('.') #separating 2 substrings with . 
    
    if(not strSplit[0].isalpha()): #checking if valid alpha presents before .
        return False;
        
    validstr = {'com', 'org', 'ca'}
    if(not strSplit[1] in validstr): #checking if valid handler present between .com,.org,.ca
        return False

    if (".." in email or ".@" in email or "@." in email or "._." in email):
        return False;

    return True;

def check_pass(passStr) : 
    returnValue=True
    if not len(passStr) >= 8: #checking length of the string 
        returnValue=False
    if not any(char.islower() for char in passStr): #checking if any lower present 
        returnValue=False
    if not any(char.isupper() for char in passStr): #checking if any upper present 
        returnValue=False
    if not any(char.isdigit() for char in passStr): #checking if digit present
        returnValue=False
    if passStr.isspace() : #checking if space is not there 
        returnValue=False
    return returnValue

print(check_pass("FishBar12"))
print(check_email("some_guy@web.com"))
