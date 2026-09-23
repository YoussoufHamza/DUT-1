def inverserChaine(x):
        return x[::-1]

chaine = input("Entrer une chaine")
print("Votre chaine ", chaine)

print("Chaine à l'envers", inverserChaine(chaine))

chaineInverser = inverserChaine(chaine)

if(chaine == chaineInverser):
    print(chaine," est un palindrome ")
else:
    print(chaine, "n'est pas un palindrome")