
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


typedef struct tree{
	int item;
	struct tree * parent;
	struct tree * right;
	struct tree * left;
}tree;

tree *parent;    /* last node visited */

tree *init_tree(void) {
    return(NULL);
}

bool empty_tree(tree *t) {
    if (t == NULL) {
        return (true);
    }
    return (false);
}

/* [[[ search_tree_cut */
tree *search_tree(tree *l, int x) {
    if (l == NULL) {
        return(NULL);
    }

    if (l->item == x) {
        return(l);
    }

    if (x < l->item) {
        return(search_tree(l->left, x));
    } else {
        return(search_tree(l->right, x));
    }
}
/* ]]] */

/* [[[ insert_tree_cut */
void insert_tree(tree **l, int x, tree *parent) {
    tree *p;    /* temporary pointer */

    if (*l == NULL) {
        p = malloc(sizeof(tree));
        p->item = x;
        p->left = p->right = NULL;
        p->parent = parent;
        *l = p;
        return;
    }

    if (x < (*l)->item) {
        insert_tree(&((*l)->left), x, *l);
    } else {
        insert_tree(&((*l)->right), x, *l);
    }
}
/* ]]] */

/* [[[ K-unique_tree */
bool insert_tree_Unique(tree **l, int x, tree *parent, int tab[], int low, int hop, int k) {
    tree *p;    /* temporary pointer */
    bool test = true;
	int i;
	for(i=low; i<=hop; i++){
		if( (hop - low) < k ){
			if (*l == NULL) {
		        p = malloc(sizeof(tree));
		        p->item = tab[i];
		        p->left = p->right = NULL;
		        p->parent = parent;
		        *l = p;

		    }
		
		    if (tab[i] < (*l)->item) {
		        insert_tree_Unique(&((*l)->left), tab[i], *l,tab, low++, hop,k);
		    }else if(tab[i] == (*l)->item){
		    	test = false;
		    	return test;
			}else {
		        insert_tree_Unique(&((*l)->right), tab[i], *l, tab,low++, hop,k);
		    }
		}
	}
    return test;
}

/* ]]] */

void print_tree(tree *l) {
    if (l != NULL) {
        print_tree(l->left);
        printf("%d ", l->item);
        print_tree(l->right);
    }
}

tree *successor_descendant(tree *t) {
    tree *succ;    /* successor pointer */

    if (t->right == NULL) {
        return(NULL);
    }

    succ = t->right;
    while (succ->left != NULL) {
        succ = succ->left;
    }
    return(succ);
}

/* [[[ find_minimum_cut */
tree *find_minimum(tree *t) {
    tree *min;    /* pointer to minimum */

    if (t == NULL) {
        return(NULL);
    }

    min = t;
    while (min->left != NULL) {
        min = min->left;
    }
    return(min);
}
/* ]]] */

tree *predecessor_descendant(tree *t) {
    tree *pred;    /* predecessor pointer */

    if (t->left == NULL) {
        return(NULL);
    }

    pred = t->left;
    while (pred->right != NULL) {
        pred = pred->right;
    }
    return(pred);
}

tree *delete_tree(tree *t, int x) {
    tree *d;             /* node with key to delete */
    tree *p;             /* node to be physically deleted */
    int new_key;   /* key to overwrite deleted key */
    tree *child;         /* d's only child, if any */
    tree *search_tree();

    d = search_tree(t, x);

    if (d == NULL) {
        printf("Warning: key to be deleted %d is not in tree.\n", x);
        return(t);
    }

    if (d->parent == NULL) {    /* if d is the root */
        if ((d->left == NULL) && (d->right == NULL)) {
            free(d);
            return NULL;    /* root-only tree */
        }

        if (d->left != NULL) {    /* find node to physically delete */
            p = predecessor_descendant(d);
        } else { 
            p = successor_descendant(d);
        }
    } else {
        if ((d->left == NULL) || (d->right == NULL)) {
            /* d has <=1 child, so try to find non-null child */
            if (d->left != NULL) {
                child = d->left;
            } else {
                child = d->right;
            }

            if ((d->parent)->left == d) {    /* fill null pointer */
              d->parent->left = child;
            } else {
              d->parent->right = child;
            }
            if (child != NULL) {
                child->parent = d->parent;
            }
            free(d);
            return(t);
        } else {
            p = successor_descendant(d);    /* p has 2 children */
        }
    }

    new_key = p->item;    /* deal with simpler case of deletion */
    delete_tree(t, p->item);
    d->item = new_key;
    return (t);
}


void Menu(){
	printf("\ti - Ajout d'un elt \n");
	printf("\tp - Affichage de l'abre \n");
	printf("\td - Supprimer un elt de l'abre \n");
	printf("\ts - rechercher dans l'arbre \n\n");
	printf("\tk - Verifier si un tableau est k-unique \n\n");
	printf("\n\n\tFaite un choix \n\n");
}

int main(void) {
	bool teste = true;
	char c;
    int d;          /* input item */
    tree *l;              /* tree under construction */
    tree *tmp;            /* returned tree from search */
    tree *search_tree();
    void insert_tree();
    int tab[10] = {2, 3, 1, 0, 11, 20, 3, 2, 0, 10};

    l = init_tree();
	
	
	tache : Menu();
	while (scanf("%c", &c) != EOF) {
	    if (tolower(c) == 'p') {
		    print_tree(l);
		    printf("\n");
		    goto tache;
	    }
	    if (tolower(c) == 'i') {
	    	printf("Entrer un elet \n\n");
		    scanf("%d", &d);
		    printf("new item: %d\n", d);
		    insert_tree(&l, d, NULL);
		    goto tache;
	    }
	    if (tolower(c) == 's') {
	    	printf("Entrer un elet \n\n");
		    scanf("%d", &d);
		    tmp = search_tree(l, d);
		    if (tmp == NULL) {
		        printf("item %d not found\n",d);
		    } else {
		        printf("item %d found\n",d);
		    }
		    goto tache;
	    }
	    if (tolower(c) == 'd') {
	    	printf("Entrer un elet \n\n");
	        scanf("%d", &d);
	        printf(" deleting item %d\n", d);
	        l = delete_tree(l, d);
	        print_tree(l);
	        printf("\n");
	        goto tache;
	    }
	    if (tolower(c) == 'k') {
	    	printf("Entrer un k demander \n\n");
	        scanf("%d", &d);
	        teste = insert_tree_Unique(&l, 0,NULL, tab, 0, 10, d);
	        if(teste == false){
	        	printf("Tableau n'est pas k unique \n");
			}else{
				printf("Tableau est  k unique \n");
			}
	        printf("\n");
	        goto tache;
	    }
    }
    
    return 0;
}


