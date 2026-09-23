
code = int(input("Entrer Votre code svp"))
essais=1;

while((essais<3)):
    if(code == 6543):
        print("Code correct")
        break
    else:
        print("Code incorrect")
        essais=essais+1
        code = int(input("Entrer Votre code svp"))

if(essais == 3):
    print("Toutes les tentatives de déverouillage utilisées")