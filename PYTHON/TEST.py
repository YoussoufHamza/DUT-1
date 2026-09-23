def deuxieme_plus_grand(L):
    L_temp = list(set(L))
    L_temp.sort()
    L_temp.reverse()
    return L_temp[1]

L = [1,2,3,4,1,2,1,4,2,1,4,5]
print("Liste d'elements ",L)

print("Deuxieme plus grand élement de la liste ", deuxieme_plus_grand(L))

Donc en somme on a :
    Liste :
        append() ajoute en fin de liste
        pop() supprime en fin de liste
        del(L[0]) supprime l'element de rang 0
        insert(pos,valeur) insert la valeur à la position pos
        remove(valeur) supprime la valeur dans la liste
        pop(pos) supprime la valur à la position pos de la liste
        len(L) retourne la taille de la liste
    
    Dict :
        get(cle) retourne la valeur de la cele dans le dictionnaire
        keys() retourne les clés du dictionnaire
        values() retournes les valeurs du dictionnaires
        items() retourne les elements du dictionnaire cle,valeur
        del(dic["cle"]) supprime l'element cle du dictionnaire
        len(dic) retourne la taille du dictionnaire
        
    fichier :
        whith open("nonfichier.txt", "r") as f: ouvre le fichier en leture avec fermeture automatique
        whith open("nonfichier.txt", "a") as f: ouvre le fichier en ajout avec fermeture automatique
        whith open("nonfichier.txt", "w") as f: ouvre le fichier en ecriture avec fermeture automatique
        f.close() ferme le fichier manuellement
        f.read() lit tout le fichier et retourne une chaine
        f.readline() lit la premier ligne du fichier et retourne une liste
        f.readlines() lit le tout le fichier et retourne une liste de ligne
        f.write("ok") ecrit ok dans le fichier/soit en fin de fichier en fonction du mode a ou w
        
        