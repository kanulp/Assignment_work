#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 14 23:22:36 2019

@author: Manu
"""
def ryerson_letter_grade(i):
     if   i>= 90:
        return "A+"
     elif i>=85 and i<=89:
        return "A"
     elif i>=80 and i<= 84:
        return "A-"
     elif i>= 77 and i<=79:
        return "B+"
     elif i>= 73 and i<=76:
        return "B"
     elif i>= 70 and i<=72:
        return "B-"
     elif i>= 67 and i<=69:
        return "C+"
     elif i>= 63 and i<=66:
        return "C"
     elif i>= 60 and i<=62: 
        return "C-"
     elif i>= 57 and i<=59:
        return "D+"
     elif i>=53 and i<=56:
        return "D"
     elif i>= 50 and i<=52:
        return "D-"
     else :
        return "F"
##    
###print (f"{ryerson_letter_grade(56)}")
#        
def is_ascending(items):
    l=-10000
    ascend=True
    for item in items:
        if item > l:
            l=item
        else:
            ascend = False
    return ascend


def first_missing_positive(items):
	m = max(items) 
	if m < 1: 
		return 1
	if len(items) == 1: 
		return 2 if items[0] == 1 else 1	
	z = [0] * m 
	for i in range(len(items)): 
		if items[i] > 0: 
			if z[items[i] - 1] != 1: 
				z[items[i] - 1] = 1
	for i in range(len(z)):  
		if z[i] == 0: 
			return i + 1
	return i + 2	

  
def only_odd_digits(n):
    digits=[int(i)for i in str(n)]
    dpp=[r for r in digits if r%2]
    if len(dpp)==len(digits):
        return True 
    else:
        return False 
   

def pyramid_blocks(n,m,h):
    blocks=0 
    for block in range (h):
        blocks+=(n+block)*(m+block)
    return blocks
 
def three_summers(items, goal):
        for a in range (len(items)):
            for b in range(a+1,len(items)):
                for c in range (b+1,len(items)):
                    if items[a]+items[b]+items[c]==goal:
                        return True
        return False
    
def is_permutation(items,n):
    c=sorted(set(items))
    p=[i for i in range (1, n+1)]
    if c == p:
        return True
    else:
        return False
   
def tribonacci(n,start=(1,1,1)):
    d= list(start)
    if n==0 :
        return d[0]
    elif n==1:
        return d[1]
    elif n==2:
        return d[2]
    else:
        sum=0
        a=d[0]
        b=d[1]
        c=d[2]
        for i in range(n-2):
            sum=a+b+c
            a=b
            b=c
            c=sum
        return sum 

               
def hand_is_badugi(hand):
     list=[]
     for x in range(4):
         for j in range (2):
             if hand[x][j] not in list:
                 list.append(hand[x][j])
     if len(list)==8:
        return True
     return False


def expand_intervals(intervals):
    lis=[]
    stringa=intervals.split(",")
    for scr in stringa:
        x=scr.split("-")
        i = int(x[0])
        if len(x)==1:
            lis.append(i)
        else:
            while i<=int(x[1]):
                lis.append(i)
                i+=1
    return lis
        
def detab(text, n=8, sub=''):
    ans=""
    size= len(text)
    l_ans=0
    flag=0
    for i in range(0,size):
        if flag:
            flag=0
            continue 
        if ((i+1)!=size and text[i:i+2]=='\\t'):
            if ((l_ans%n)==0):
                ans+=(n*sub)
                l_ans+=n
            else:
                ans+=((n-l_ans%n)*sub)
                l_ans+=(n-l_ans%n)
            flag=1
        else:
            ans+=text[i]
            flag=0
            l_ans+=1
    return ans 

             
from itertools import groupby 
def group_equal(items):
  r=list() 
  for x,y in groupby(items): 
    r.append(list(y)) 
  return r                
        
##################################################WORKINg
#def is_cyclops(n):
#    n_str = str(n)
#    if len(n_str) % 2 == 0:
#        return False
#    if n_str[len(n_str) // 2] == '0' and n_str.count('0') == 1:
#        return True
#    else:
#        return False


##WORKS 
#def create_zigzag(rows, cols, start = 1):
#  li = []
#  for i in range(rows):
#    subli = []
#    if i%2==0:
#      for j in range(cols):
#         subli.append(start)
#         start+=1
#      li.append(subli)
#    else:
#      sum = start
#      for j in range(cols):
#        subli.append(sum-1+cols-j)
#        start+=1
#      li.append(subli)
#  print(li)
#
##row = int(input("enter the no of rows"))
##col = int(input("enter the no of cols"))
##start = int(input("enter the start value"))
##create_zigzag(row,col,start)
