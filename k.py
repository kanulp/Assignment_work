def seperate_sort(list,num=0) :
    int_list = [];
    str_list = [];
    for i in range(len(list) if num==0 else num): #checking condition for loop length
        if isinstance(list[i], int) : #if instance is an integer add into list
            int_list.append(list[i])
        else if isinstance(list[i], int): #if instance is string add into string list
            str_list.append(list[i])
    return int_list,str_list
        

fruits = ["android", "ios", "web",3,4,2]

print(f'data : {fruits}')
int_list, str_list = seperate_sort(fruits,2)
print(int_list)
print(str_list)