def stringToDict(chaine):
    L=list(chaine)
    D = dict();
    for i in range(0, len(L)):
        nbocc=1
        for j in range(i+1, len(L)):
            if(L[i] == L[j]):
                nbocc+=1
        if(L[i] not in D):
            D[L[i]]=nbocc
    return D

chaine = input("Entrer une chaine svp ");
Dict = stringToDict(chaine)
print("Dictionnaire resultant ", Dict)