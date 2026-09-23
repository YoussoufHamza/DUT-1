EXERCICE 7

//SIGNATURE DE L'INSERTION DANS L'arbre
void InsererArbre(abr ** arbre, arbre *Parent, int val){
    if(*arbre == NULL){
        abr * temp = malloc(sizeof(abr));
        temp->valeur = val;
        temp->Parent = Parent;
        temp->gauche = temp->droite = NULL;
        *arbre = temp;
    }
    else if(val<= (*arbre)->valeur){
        InsererArbre(&((*arbre)->gauche), *arbre, val);
    }else{
        InsererArbre(&((*arbre)->droite), *arbre, val);
    }
}

void InsererTableauTrieDansBST(int G, int D, int tab[], abr **arbre){
    if(G<D){
        int milieu = G + (D-G)/2;
        InsererArbre(arbre, NULL, tab[milieu]);
        InsererTableauTrieDansBST(G, milieu-1, tab, arbre);
        InsererTableauTrieDansBST(milieu+1, D, tab, arbre);
    }
}


EXERCICE 6

int K_PLUS_PETIT(int k, abr *arbre){
    if(arbre==NULL)
        return -1;

    int position = 0;
    int plus_petit = Trouver_plus_petit(k, arbre, &position);
    return plus_petit;
}

int Trouver_plus_petit(int k, abr *arbre, int *position){
    if(arbre == NULL)
        return -1;

    int valeur = Trouver_plus_petit(k, arbre->gauche, position);
    if(valeur != -1) return valeur;

    (*position)++;
    if((*position) == k)
        return arbre->valeur;

    return Trouver_plus_petit(k, arbre->droite, position);
}

EXERCICE 5

void InsererArbre(abr ** arbre, arbre *Parent, int val){
    if(*arbre == NULL){
        abr * temp = malloc(sizeof(abr));
        temp->valeur = val;
        temp->Parent = Parent;
        temp->gauche = temp->droite = NULL;
        *arbre = temp;
    }
    else if(val<= (*arbre)->valeur){
        InsererArbre(&((*arbre)->gauche), *arbre, val);
    }else{
        InsererArbre(&((*arbre)->droite), *arbre, val);
    }
}

abr* rechercherArbre(abr * arbre, int x){
    if(arbre == NULL){
        return NULL;
    }

    if(arbre->valeur == x){
        return arbre; 
    }else if(x < arbre->valeur){
        return rechercherArbre(arbre->gauche, x);
    }else{
        return rechercherArbre(arbre->droite, x);
    }
}

int PREMIER_DOUBLON(int tab[], int n){
    abr * arbre = NULL;
    for(int i=0; i<n; i++){
        if(rechercherArbre(arbre, tab[i])==NULL){
            InsererArbre(&arbre, NULL, tab[i]);
        }else{
            return tab[i];
        }
    }
    return -1;
}

EXERCICE 4

void InsererArbre(abr ** arbre, arbre *Parent, int val){
    if(*arbre == NULL){
        abr * temp = malloc(sizeof(abr));
        temp->valeur = val;
        temp->Parent = Parent;
        temp->gauche = temp->droite = NULL;
        *arbre = temp;
    }
    else if(val<= (*arbre)->valeur){
        InsererArbre(&((*arbre)->gauche), *arbre, val);
    }else{
        InsererArbre(&((*arbre)->droite), *arbre, val);
    }
}

abr* rechercherArbre(abr * arbre, int x){
    if(arbre == NULL){
        return NULL;
    }

    if(arbre->valeur == x){
        return arbre; 
    }else if(x < arbre->valeur){
        return rechercherArbre(arbre->gauche, x);
    }else{
        return rechercherArbre(arbre->droite, x);
    }
}

int tableau_K_UNIQUE(int n, int tab[], int k){
    int i,j;
    abr *arbre;
    for(i=0; i<=n-k; i++){
        arbre = NULL;
        for(j=i; j<i+k; j++){
            if(rechercherArbre(arbre, tab[j])==NULL){
                InsererArbre(&arbre, NULL, tab[j]);
            }else{
                return -1; //si doubon
            }
        }
    }
    return 0; //si aucun doublon
}

compleXITE DE L'alogorithme pricipale (O(nlog(n)))
pourquoi ? 1 ere boucle o(n)
        2 eme boucle constante O(k) car elle fera toujours k parcours
        La recherche dans un arbre s'effectue generalement en O(log(n))
        L'insertion dans un arbre s'effectue generalement en O(log(n))
donc on a O(n) X O(K) X (O(log(n)) + O(log(n))) = O(n) X K X O(log(n)) = O(nlog(n))


Git est un outil incontournable pour le develeppoment d'application car il permet un suivi du projet et de nombreuses fonctionnalités interessantes(tel que git commit pour envoyer un fichier/dossier sur la branche principale, git statuts pour avoir l'etat actuel d'un fichier/dossier...).

Comme exemple concret d'utilisation nous avons le développement d'une application par une equipe distante 
chaque membre peut ainsi travailler sur une branche du projet et faire un git commit une fois le travail terminé et git se charge de la fusion avec git merge

Avantages ici nous avons le travail collaboratif, git est basé sur l'architecture décentralisée, et un suivi des fichier(staged, modified, commited) 



les differences entre un SVN et un système distribué sont les suivantes:
1- Tout d'abord dans un SVN les données sont stockées et centralisées sur le serveur c'est dire que si le serveur est inaccessible tout le projet le deviens aisni;
2- Or un système distribué à l'instar de git permet aux equipes de posséder une copie du projet en local et d'apporter les modfications souhaitées une fois terminés elles peuvent faire un git commit pour partager leur travail avec le reste des equipes.
3- De même avec un SVN lorsqu'une modification est apportée à un fichier on ecrase le fichier précédent et les fichier non modifier on place un pointeur vers leur adresse.
4- Or avec un système distribué lorsqu'un fichier est modifié on garde une copie de son etat precedent au cas où on desire faire un git restore et on effectue un copie des fichiers non modifiés

Avantages d'un SVN 
- Utilise moins de capacité de stockage car il ne copie pas les fichiers non modifiés.
- Risque de colisions moindre

Inconvenient d'un SVN
- Ecrase l'etat precedent d'un fichier modifié
- L'indisponnibilité du projet entraine l'indisponnibilité du projet

Avantages de Git
- Permet un meilleur suivi de chaque fichier car on connait la modification qui a été apportée à chaque fichier
- Le système est distribué donc plus libre

Inconvenient de Git
-Necessite plus d'espace car il stocke une copie des fichiers non modifiés
-Risque de collisions plus elevé surtotu lors des fusions



EXERCICE 1
$ mkdir projet-git
$ cd projet-git
$ touch README.md
$ git init
$ git add README.md
$ git commit -m "Initial Commit"

EXERCICE 2
$ vi README.md //SUPPOSE QUE J'AI MODIFIE LE fichier
$ git status
$ git log 
$ git commit -a -m "Mise a jour du fichier README"

EXERCICE 3
$ git branch dev
$ git switch -c dev
$ touch notes.md
$ git add notes.md
$ git commit -m "Ajout du fichier notes.md"
$ git switch -c main
$ git status

EXERCICE 4
$ vi README.md //SUPPOSE QUE J'AI MODIFIE LE fichier
$ git commit -a -m "Mise a jour du fichier README"
$ git switch -c dev
$ vi README.md //SUPPOSE QUE J'AI MODIFIE LE fichier
$ git commit -a -m "Mise a jour du fichier README"
$ git switch -c main
$ git merge dev
$ vi README.md //SUPPOSE QUE J'AI MODIFIE LE fichier
git add README.md
$ git commit -a -m "Fusion de dev dans main avec resolution du conflict"


$ mkdir calculatrice-git
$ cd calculatrice-git
$ touch main.py 
$ touch README.MD 
$ vi README.MD //DEBUT DU PROJET
$ vi main.py // def addition(a, b): return a + b
$ git init
$ git tag "V1.0.0"
$ git branch -m main //Renommez la branche en main pour evitez les conflicts lors du push
$ git add README.MD
$ git add main.py
$ vi README.MD //DEBUT DU PROJET 1- Ajout de la fonctionnalité addition
$ git commit -m "Initial commit"
$ git remote add origin LIEN_VERS_MON_DEPOT
$ git push origin -u main 

$ git branch feature/soustraction
$ git switch feature/soustraction
$ vi main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b
$ vi README.MD //DEBUT DU PROJET 1- Ajout de la fonctionnalité addition 2- Ajout de la fonctionnalité soustraction
$ git commit -a -m "Ajout de la fonctionnalité soustraction"
$ git switch main
$ git branch feature/multiplication
$ git switch feature/multiplication
$ vi main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b
$ vi README.MD //DEBUT DU PROJET 1- Ajout de la fonctionnalité addition 2- Ajout de la fonctionnalité soustraction 3- Ajout de la fonctionnalité multiplication
$ git commit -a -m "Ajout de la fonctionnalité multiplication"

$ git switch feature/soustraction
$ vi main.py // def additio(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b
$ git switch feature/multiplication
$ vi main.py // def additon(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b
$ git switch main
$ git merge feature/soustraction
$ git merge feature/multiplication
$ git switch feature/soustraction
$ vi main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b
$ git switch feature/multiplication
$ vi  main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b
$ git switch main
$ git commit -a -m "Fusion des fonctionnalités soustraction et multiplication"

$ git branch feature/division
$ git switch feature/division
$ vi main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b def division(a, b) : return a/b
$ git commit -a -m "Ajout de la fonctionnalité division"
$ git switch main
$ git rebase feature/division main
$ git switch feature/division
$ vi main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b def division(a, b) : return ((b!=0)? a/b : 0) def modulo(a,b) : return a%b
$ git commit -a -m "Ajout de la fonctionnalité modulo"
$ git switch main
$ git cherry-pick modulo(a,b)

$ git switch main
$ vi main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b def division(a, b) : return ((b!=0)? a/b : 0) def modulo(a,b) : return a%b def racine_carree(a) : 
$ git stash 
$ vi main.py // def addition(a, b): return a + b def soustraction(a, b) : return a - b def multiplication(a, b) : return a * b def division(a, b) : return ((b!=0)? a/b : 0) def modulo(a,b) : return a%b def racine_carree(a) : return Math.sqrt(a)
$ git destash
$ git commit -a -m "Ajout de la fonctionnalité racine carrée"

$ git push origin -u feature/soustraction
$ git push origin -u feature/division
$ git push origin -u feature/multiplication
$ git log --oneline --graph --all

$ touch README.MD




