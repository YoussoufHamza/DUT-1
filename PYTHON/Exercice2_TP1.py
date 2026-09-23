import random

nombre_mystere = random.randint(1,100)
joueur1 = int(input("Entrer un nombre joueur 1 entre 1 et 100 "))
joueur2 = int(input("Entrer un nombre joueur 2 entre 1 et 100 "))

if((nombre_mystere - joueur1 < nombre_mystere-joueur2) ):
    print("Meilleur Joueur 1 plus proche ",nombre_mystere)
else :
    print("Meilleur Joueur 2 plus proche ",nombre_mystere)