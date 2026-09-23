def sommeRecursive(n):
    if(n==0):
        return n
    if(n<0):
        return (-n)+sommeRecursive(((-n)-1))
    else:
        return n+sommeRecursive(n-1)
    

n = int(input("Entrer un nombre svp "))
print("La somme des entiers de 0 à ",n," est ", sommeRecursive(n))