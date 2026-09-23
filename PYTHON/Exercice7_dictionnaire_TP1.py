villeDict = {"nom":"Montreal", "pays":"Canada","province":"Quebec", "pop":1825208,"superficie":315}

print("Ville avant modification ")
for k,v in villeDict.items() :
    print(k,":", v)

print("\nModification de la superficie erronée de ",villeDict.get("superficie")," km^2 à 365 km^2")
villeDict["superficie"] = 365;

print("\nVille après modification de la superficie de la ville")
for k,v in villeDict.items() :
    print(k,":", v)

print("\nAjout de la densité qui est de 4992 habitants au kilomètre carré")
villeDict["densité"] = 4992;

print("\nVille après ajout de la densité")
for k,v in villeDict.items() :
    print(k,":", v)

print("\nSuppression de la clé 'pop' pour quelle devienne 'population'")
population = villeDict["pop"]
villeDict.pop("pop")
villeDict["population"] = population

print("\nVille après modification de la clé 'pop'")
for k,v in villeDict.items() :
    print(k,":", v)

