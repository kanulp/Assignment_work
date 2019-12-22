def scrabble_value(word, multipliers = None):
  dic = {'a':1, 'b':3, 'c':3, 'd':2, 'e':1, 'f':4, 'g':2, 'h':4, 'i':1, 'j':8, 'k':5, 'l':1, 'm':3, 'n':1, 'o':1, 'p':3, 'q':10, 'r':1, 's':1, 't':1, 'u':1, 'v':4, 'w':4, 'x':8, 'y':4, 'z':10 }
  value = 0
  for i in range(len(word)):
       value += dic[word[i]]*multipliers[i]
  print(value)

word = input("enter the word ")
m = []
print('''want to add any multipliers
         if yes enter 1
         else enter 0  ''')
inp = int(input("enter your choice"))
if inp==1:
  for i in range(len(word)):
    m.append(int(input()))
  scrabble_value(word, m)
elif inp==0:
  m=[1]*len(word)
  scrabble_value(word, m)

