def supprimer_element(L,x):
    for i in L:
        if i==x:
            L.remove(i)
    

L = [1,2,3,4,1,2,1,4,2,1,4,5]
print("Liste avant la suppression de l'element ",L)

x = int(input("Entrer l'element à supprimer "))

supprimer_element(L,x)
print("Liste après la suppression de ", x, "  ", L)

#

def moyenne_nombre_pair(L):
    sum_nombre_pair = 0
    totale_nombre_pair=0
    for i in L:
        if i%2==0:
            sum_nombre_pair+=i
            totale_nombre_pair+=1
            
    return sum_nombre_pair//totale_nombre_pair

L = [1,2,3,4,1,2,1,4,2,1,4,5]
print("Liste d'elements ",L)

print("La moyenne des nombres pairs de la liste est : ", moyenne_nombre_pair(L))

#

def liste_carres_uniques(L):
    Ltemp = list()
    for i in L:
        if i**2 not in Ltemp:
            Ltemp.append(i**2)
    return Ltemp

L = [1,2,3,4,1,2,1,4,2,1,4,5]
print("Liste d'elements ",L)

print("Liste des carrés uniques ", liste_carres_uniques(L))

#

def deuxieme_plus_grand(L):
    L.sort()
    L.reverse()
    return L[1]

L = [1,2,3,4,1,2,1,4,2,1,4,5]
print("Liste d'elements ",L)

print("Deuxieme plus grand élement de la liste ", deuxieme_plus_grand(L))

#

def note_superieur_a_la_moyenne(L):
    nom_valide = list()
    for couple in L:
        if(couple[1]>=12):#Moyenne à l'EST DE SALE
            nom_valide.append(couple[0])
        
        
    return nom_valide
 
L = [("Brondon",20), ("Maxim", 18), ("Emi",9), ("Sara",15), ("Nathan", 12), ("Prince",11), ("Mathieu",8)]
print("Liste des etudiants et leur note respective")

for couple in L:
    print("Nom : ", couple[0], " Note : ", couple[1])

print("Liste des etudiants ayant eu une note superieur à la moyenne ")
print(note_superieur_a_la_moyenne(L))