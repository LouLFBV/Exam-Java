# Partie 1 - Design Pattern :

### A. Singleton :

-> Voir src/main/java/partie1/GameServer.java


1. Pourquoi le mot-clé volatile est-il indispensable sur l'instance dans le DoubleChecked Locking ?

-> Le mot-clé volatile garantit que des threads différents gèrent correctement l'accès concurrent à l'instance unique du singleton.


2. Donne une alternative plus simple et tout aussi thread-safe en Java. Pourquoi est-elle préférable ?

-> L'alternative la plus simple est l'utilisation du Singleton par initialisation statique car elle ne nécessite pas de synchronisation explicite, est parfaitement thread-safe..


### B. Builder

-> Voir src/main/java/partie1/Personnage.java 


### C. Factory Method

-> Voir src/main/java/partie1/Forgeron.java
-> Voir src/main/java/partie1/ForgeronArc.java
-> Voir src/main/java/partie1/ForgeronEpee.java


### D. Decorator

-> Voir src/main/java/partie1/PotionDeBase.java
-> Voir src/main/java/partie1/PotionDecorator.java
-> Voir src/main/java/partie1/AvecMana.java
-> Voir src/main/java/partie1/AvecAntidote.java


### E. Bridge 

-> Voir src/main/java/partie1/NotificationNormale.java
-> Voir src/main/java/partie1/NotificationUrgente.java
-> Voir src/main/java/partie1/CanalEmail.java
-> Voir src/main/java/partie1/CanalSMS.java


### F. State

-> Voir src/main/java/partie1/EtatVivant.java
-> Voir src/main/java/partie1/EtatMort.java
-> Voir src/main/java/partie1/EtatEmpoisonne.java

3. Quelle est la différence entre le pattern State et un simple if/else sur un attribut
enum ? Donne un avantage concret du State dans ce contexte.

-> Le pattern State sépare les comportements dans des classes dédiées à chaque état, alors que le if/else garde toute la logique de décision centralisée dans une seule méthode.
Cela rend un personnage plus extensible car on peut ajouter des états sans modifier le reste du code et cela empêche une certaine porosité ce qui simplifier le debug.


# Partie 2 - Génériques, Lambdas & Streams

### A. Classe et méthodes génériques

1. Implémente la classe Paire<A,B> qui stocke deux valeurs de types différents.

-> Voir src/main/java/partie2/Paire.java


2. Implémente les méthodes génériques suivantes dans OutilsGeneriques :

-> Voir src/main/java/partie2/OutilsGeneriques.java


### B. Interfaces fonctionnelles & lambdas 

1. Définis l'interface fonctionnelle Transformation<T> avec une méthode appliquer(T
valeur) retournant T.

-> Voir src/main/java/partie2/Transformation.java

2. Dans LambdaFactory, implémente les méthodes suivantes en utilisant des lambdas :

-> Voir src/main/java/partie2/LambdaFactory.java


### C. Stream API

Implémente toutes les méthodes ci-dessous en une chaîne Stream. Pas de boucle for.

-> Voir src/main/java/partie2/BoutiqueService.java


# Partie 3 - Réflexion & Annotations

### A. Créer ses propres annotations 

Définis les annotations suivantes qui serviront de base aux exercices B et C.

-> Voir src/main/java/partie3/Entite.java ; src/main/java/partie3/Colonne.java ; src/main/java/partie3/Loggable.java


### B. Introspection par réflexion

-> Voir src/main/java/partie3/Inspecteur.java


### C. Générateur de requête SQL par réflexion

-> Voir src/main/java/partie3/GenerateurSQL.java


4. Pourquoi faut-il appeler field.setAccessible(true) avant field.get(objet)
pour les champs privés ?

-> L'appel à setAccessible(true) désactive temporairement cette vérification de contrôle d'accès pour permettre à la réflexion de lire ou modifier la valeur, même si le champ est privé.


5. Cite un risque de sécurité lié à l'utilisation de setAccessible() en production.

-> Le principal risque est la violation de l'encapsulation, qui peut rendre le code vulnérable. En production, un code malveillant ou une mauvaise manipulation pourrait modifier des états internes critiques ou des variables immuables, contournant ainsi les invariants de sécurité que définit dans nos classes.


# Partie 4 I/O, Regex & REST (PAS FAIT)


### A. Gestion de fichiers CSV 

Implémente un gestionnaire de sauvegarde de scores au format CSV (une ligne par joueur :
pseudo,score).

-> Voir src/main/java/partie4/ScoreManager.java


### B. Validation & extraction par regex

-> Voir src/main/java/partie4/ValidateurJeu.java


### C. Étendre le mini-framework REST 

-> Voir src/main/java/partie4/ScoreController.java


6. Le RestEngine lit les annotations @Rest, @Get, @Post via réflexion pour construire
la table de routage. Explique en 3 lignes comment fonctionne ce mécanisme.

-> 