Projet Citadelle - Phase 1
Contributeurs: Rémi Laot (mstha)

+ Résumé du projet:
Ce projet est mené dans le cadre du cours A.C.D.C. (Actualisation des Compétences en Développement et Concepetion) de la
filière ingénierie logicielle de l'Ecole des Mines de Nantes (FIL-A1 2016). L'objectif est de développer le jeu 'citadelle'
en Java. Dans un premier temps, les étudiants développeront les fonctionnalités de base du jeu (jeu à deux joueurs sur
un même ordinateur, en textuel). Par la suite, chaque étudiant qui participe au projet recevra le code produit par un
autre, et devra continuer le développement du jeu (IHM, IA).

+ Déroulement d'un tour
1. Choix des personnages
2. Tour des personnages

+ Tour d'un personnage
Les personnages et batiments pouvant ajouter des actions durant au tour d'un joueur, il est nécessaire d'avoir un système
d'action modulaire. Des actions doivent pouvoir être ajoutées, modifiées, ou remplacées de façon dynamique. On utilise le
design pattern strategy pour permettre cette modularité.

Chaque personnage est porteur d'un arbre d'actions. Cet arbre d'action défini les différents choix possibles pour un joueur.
Un joueur peut exécuter les actions qui sont directement successives de la racine de l'arbre d'action. Executer une action
la fait disparaitre de l'arbre, et fait apparaitre à la racine de l'abre les différentes actions qui en étaient dépendantes.

Certains effets peuvent être déclenchés par des évènements spécifiques. Pour modéliser cela, on utilise une classe Evenement,
sous classe d'Observateur, qui pourra observer un Observe pour déclencher un effet.

+ Interface joueur
Certaines actions nécessitent un choix du joueur. Suivant les versions du jeu, un joueur pourra être humain, ou IA. Les
choix devront donc être demandés via différentes interfaces (IA, textuelle, graphique). Nous proposons deux méthodes à redéfinir
pour la création de tout nouveau Joueur pour permettre de demander au joueur de prendre une décision: choisirElement et choisirElements.
Via ces méthodes, un joueur peut choisir une action à réaliser parmis plusieurs possibles, etc etc...

+ Mise en place
L'objectif était de créer un fichier de config, et d'extraire les listes de joueur, personnages et batiments de celui ci.
Je n'ai pas eu le temps de finir ce système. La classe LecteurConfiguration est chargée de l'initialisation des différentes
listes et des différents paramètres qui pourraient varier d'une partie à l'autre.

+ Etat du développement
L'ensemble des personnages et des merveilles de la première édition sont implémentés. Sauf erreur de ma part, tout est fonctionnel.
J'ai défini deux types de joueurs pour l'exemple: un joueur humain en console, et un joueur IA qui prend toute les décisions aléatoirement.

+ Manque de test
J'ai pu tester le code de facon robuste pour les erreurs d'execution (exceptions), mais pas pour les erreurs de logique (règles de jeu). Les
règles de base devraient être valide, mais il est possible que des erreurs de logique entre les différent pouvoir et effets apparraissent.

+ Développement d'une IHM
La classe DonneePartie devrait donner accès à l'ensemble des informations nécessaire au maintient d'une IHM, cependant il
est possible qu'il faille redéfinir les accesseurs, ou ammender des méthodes pour permettre un pattern MVC (ajout de notifications).

+ Développement d'une IA
En théorie, le développement d'une nouvelle IA devrait se faire aisément via la création d'une nouvelle classe héritant de Joueur.
