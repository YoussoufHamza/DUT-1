
def valeurPlusFrequente(L):
    Maxocc = 0
    Max = 0
    
    for i in range (0, len(L)):
        nbocc = 1
        
        for j in range (i+1, len(L)):
            if(L[i] == L[j]):
                nbocc+=1
                
        print(L[i], " Nombre occ ",nbocc)
        
        if(nbocc > Maxocc):
            Maxocc = nbocc
            Max = L[i]
            
    return Max

L = [1,2,3,4,2,2,1,4,2,1,4,2]

plusfrequent = valeurPlusFrequente(L)
print("Valeur la plus frequente ", plusfrequent)


            
    