
def listeToDict(L):
    k=""
    v=""
    for i in range (0, len(L)):
        if(L[i]==" "):
            break
        k+=L[i]
        
    for j in range (i, len(L)):
        if(L[j]==" "):
            continue
        v+=L[j]
        
    return k,int(v)
    

with open("notes.txt", "w") as f:
    f.write("Alice 14\n")
    f.write("Bob 9\n")

with open("notes.txt", "r") as f:
    L = f.readlines()
    Liste = list()
    Dict = dict()
    
    for i in range(0, len(L)):
        temp = L[i]
        k,v = listeToDict(temp)
        Dict[k]=v
    
    for k,v in Dict.items():
        if(v>=10):
            print(k)