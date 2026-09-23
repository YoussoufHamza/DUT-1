moy = float(input("Entrer une moyenne comprise entre 0 et 20 "))

if((moy<0) | (moy>20)):
    print("Moyenne non valide")
else:
    match moy:
        case 20 | 19 | 18 | 17 | 16:
            print("Mention : Très bien")
        case 15 | 14:
            print("Mention : Bien")
        case 13 | 12:
            print("Mention : Assez bien")
        case 11 | 10:
            print("Mention : Passable")
        
        
    
        
    
       
        

