repertoire = {"Patrick":"0612345678", "Marie":"0687654321", "Hanae":"0765432198", "Piotr":"0777666555"}

print("\nAcceder au telephone de Piotr : ", repertoire["Piotr"])

print("\nVerification de la presence de Fanny dans le repertoire")
if(repertoire.get("Fanny")):
    print("\nFanny existe N° de telephone ", repertoire["Fanny"])
else:
   print("\nFanny n'existe pas dans le repertoire ")

print("\nModification du N° de telephone de Patrick : ", repertoire["Patrick"])
repertoire["Patrick"] = "0612345679"
print("\n N° de telephone de Patrick : ", repertoire["Patrick"])

print("\nAjout de Raoul dans le repertoire ")
repertoire["Raoul"] = "0789898989"

print("\nRepertoire avant suppression de Marie")
for k,v in repertoire.items() :
    print(k,":", v)

repertoire.pop("Marie")

print("\nRepertoire après suppression de Marie")
for k,v in repertoire.items() :
    print(k,":", v)
