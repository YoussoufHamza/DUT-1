# DUT-1

Depot de travaux pratiques et mini-projets realises durant ma formation en génie informatique DUT 1 (web, Java, Python, C, reseau).

## Vue d'ensemble

Ce depot n'est pas une application unique: c'est une collection d'exercices et de projets academiques organises par matiere.

Les themes principaux:

- Web statique et PHP (formulaires, validation, traitement serveur)
- Java (POO, interfaces GUI Swing, exercices JDBC/MySQL)
- Python (algorithmique, structures liste/dictionnaire, recursion)
- C (structures de donnees, tris, manipulations de fichiers, arbres binaires)
- Reseau (Packet Tracer)

## Structure du depot

| Dossier | Description |
| --- | --- |
| `Exo1` | Exercice PHP autour des nombres parfaits (`index.php`, `exo1.php`). |
| `EXO7` | Formulaires web et traitement PHP (inscription, affichage des donnees). |
| `tp_S8` | Serie de TP PHP: inversion de nombre, classe IP v4, stats de notes, nombres premiers. |
| `HTML_ESTS` | Pages HTML de formulaires/tests avec assets images. |
| `TP_HTML_ESTS` | Mini site HTML/CSS sur l'astronomie (terre, univers, galaxie, systeme solaire). |
| `projet_dev_web` | Formulaire HTML/CSS (coordonnees, competences, message). |
| `Site Portfolio` | Version portfolio personnelle complete (navigation, pages dediees, JS). |
| `site_portfolio` | Variante du portfolio (structure simplifiee). |
| `java` | Ensemble d'exercices Java: POO, Swing, gestion de fichiers, JDBC, projets Eclipse. |
| `java/Fichier_BD` | Projet Eclipse Java avec package `src`, classes compilees `bin`, et cas d'usage JDBC/MySQL. |
| `java/GESTION_FICHIER_JAVA` | Exercices de manipulation de fichiers + connecteur MySQL embarque. |
| `PYTHON` | Exercices Python (conditions, boucles, fonctions, recursion, listes/dicos). |
| `Struc_donnees` | Exercices C (tri rapide/fusion, gestion de fichiers, arbres, executables generes). |
| `Cisco packet tracer` | Fichier reseau `.pkt` (topologie avec serveurs). |
| `TP6_PPTX_Files` | Fichiers supports bureautiques/media (wmv, docx, xlsx). |

## Technologies utilisees

- HTML, CSS, JavaScript
- PHP
- Java (Swing, JDBC)
- Python
- C
- MySQL (dans certains exercices Java)
- Cisco Packet Tracer

## Comment executer

Il n'y a pas de pipeline unique (`npm`, `maven`, etc.) pour tout le depot.
Chaque dossier se lance de facon independante.

### 1) Projets HTML/CSS (statique)

Ouvrir directement les fichiers `index.html` dans un navigateur, ou demarrer un serveur local:

```powershell
cd "C:\Users\HOUAKEU\Desktop\githubrepos\DUT-1"
python -m http.server 5500
```

Puis ouvrir [http://localhost:5500](http://localhost:5500).

### 2) Projets PHP

Exemple avec `Exo1`:

```powershell
cd "C:\Users\HOUAKEU\Desktop\githubrepos\DUT-1"
php -S localhost:8000 -t Exo1
```

Ensuite ouvrir [http://localhost:8000](http://localhost:8000).

Vous pouvez faire la meme chose avec `EXO7` ou `tp_S8` en changeant la racine `-t`.

### 3) Exercices Python

```powershell
cd "C:\Users\HOUAKEU\Desktop\githubrepos\DUT-1"
python PYTHON\Exercice1_TP1.py
```

### 4) Exercices C

```powershell
cd "C:\Users\HOUAKEU\Desktop\githubrepos\DUT-1"
gcc Struc_donnees\tri_rapide.c -o tri_rapide.exe
.\tri_rapide.exe
```

### 5) Exercices Java

Exemple simple:

```powershell
cd "C:\Users\HOUAKEU\Desktop\githubrepos\DUT-1"
javac java\Exercice1_GUI.java
java -cp java Exercice1_GUI
```

Pour `java/Fichier_BD`, certains exercices attendent:

- un serveur MySQL local
- une base `java_bd`
- les tables correspondantes (ex: `employes`)

## Etat actuel et notes

- Le depot contient des artefacts de build (`.class`, `.exe`) et des metadonnees Eclipse (`.metadata`, `.project`, `.classpath`).
- Certains fichiers contiennent des problemes d'encodage (accents), typiques d'un melange UTF-8 / ANSI.
- Plusieurs dossiers sont des versions successives d'un meme type de projet (notamment portfolio et formulaires web).

## Auteur

Brondon Jores Houakeu
