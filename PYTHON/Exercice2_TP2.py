def pairImpair(L):
    L1=list()
    L2=list()
    
    while(len(L)!=0):
        i=L.pop()
        if(i%2==0):
            L1.append(i)
        else:
            L2.append(i)
            
    return L1,L2

L=[1,2,3,4,5,6,7,8,9,10]
L1,L2 = pairImpair(L)
print("Les nombres pairs de la liste sont ", L1)
print("Les nombre impairs de la liste sont ", L2)
            