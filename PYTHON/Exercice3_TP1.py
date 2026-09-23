moy = float(input("Entrer une moyenne comprise entre 0 et 20 "))

if((moy<0) | (moy>20)):
    print("Moyenne non valide")
else:
    if((moy>=16)):
        print("Mention : Très bien")
    elif((moy < 16) & (moy >= 14)):
        print("Mention : Bien")
    elif((moy <14) & (moy >= 12)):
        print("Mention : Assez Bien")
    elif((moy <12) & (moy >= 10)):
        print("Mention : Passable")
