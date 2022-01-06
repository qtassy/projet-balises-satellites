
# Auteurs : Nedelec Romain // Stoliaroff Clément // Tassy Quentin

# Exercice 1 : Prise en main de la couche graphique
Exercice consistant à prendre en main le package GraphicLayer (déplacement d'un objet rectangle dans une fenêtre).

![alt text](https://github.com/Romain29000/ReadMe/blob/master/exo1.png "Exo1")

### Problèmes rencontrés :
Pas de difficultés lors de cet exercice.


# Exercice 2 : Première version d'un interpreteur de Script
Exercice consistant à utiliser un script de type (space color black) pour lancer la commande de changement couleur, puis par la suite les diverses commandes lier au projet (translate, sleep..).

![alt text](https://github.com/Romain29000/ReadMe/blob/master/exo2.png "Exo2")

### Test pour le programme : Variables Script au début du code
```java
Exo 2_1 = String script = "(script (space setColor black) (robi setColor yellow) )";

Exo 2_2 = String script = "(script (space color white) (robi color red) (robi translate 10 0) (space sleep 250) (robi translate 0 10) (space sleep 250) (robi translate -10 0) (space sleep 250) (robi translate 0 -10) ) ";
```

### Problèmes rencontrés :
Pas de difficultés lors de cet exercice.


# Exercice 3 : Introduction des commandes
Exercice consistant à améliorer la qualité du codage en utilisant une Class Command, implémentant  les commandes nommer précédement (sleep, tanslate, changeColor).

![alt text](https://github.com/Romain29000/ReadMe/blob/master/exo3.png "Exo3")

### Test pour le programme : Variables Script au début du code
```java
String script = "(script (space setColor black) (robi setColor yellow) )";
```

### Problèmes rencontrés :
Pas de difficultés lors de cet exercice.


# Exercice 4 : Sélection et exécution des commandes
Exercice consistant à améliorer la qualité du codage en rajoutant dans une liste les commandes que l'objet à le droit d'utiliser.

![alt text](https://github.com/Romain29000/ReadMe/blob/master/exo4_1.png "Exo4_1")

### Test pour le programme : Script à entrer dans la console
```java
(space setColor black)  
(robi setColor yellow)
(space sleep 2000) 
(space setColor white)  
(space sleep 1000) 	
(robi setColor red)	
(space sleep 1000)
(robi translate 100 0)
(space sleep 1000)
(robi translate 0 50)
(space sleep 1000)
(robi translate -100 0)
(space sleep 1000)
(robi translate 0 -40) 
```

### Problèmes rencontrés :
Problème de compréhension avec le principe de référence au début, rapidement résolu et maîtriser. 


# Exercice 4_2 : Ajout et suppression dynamique d'éléments graphiques
Exercice consistant dans l'amélioration du code pour permettre un ajout et suppression dynamique d’éléments graphiques.

![alt text](https://github.com/Romain29000/ReadMe/blob/master/Exo4_2.png "Exo4_2")

### Test pour le programme : Script à entrer dans la console
```java
(space add robi (rect.class new))
(robi translate 130 50)
(robi setColor yellow)
(space add momo (oval.class new))
(momo setColor red)
(momo translate 80 80)
(space add pif (image.class new test.png))
(pif translate 100 0)
(space add hello (label.class new "Hello world"))
(hello translate 10 10)
(hello setColor black)
```

### Problèmes rencontrés :
Soucis avec l'insertion de l'image et de la chaîne String, Class NewImage et Class NewString précisément.
Résolu et compris par la suite.


# Exercice 4_3 : Ajouter des éléments à des conteneurs
Exercice consistant à peaufiner l'ajout dynamique en permettant que les GRect qui sont des GContainer puissent eux aussi ajouter des éléments.

![alt text](https://github.com/Romain29000/ReadMe/blob/master/Exo4_3.png "Exo4_3")

### Test pour le programme : Script à entrer dans la console
```java
(space add robi (rect new))
(space.robi translate 130 50)
(space.robi setDim 150 150)
(space.robi add rect (rect new))
(space.robi.rect setColor yellow)
(space.robi.rect translate 140 140)
```

### Problèmes rencontrés :
Problème de gestion de suppression en cascade des références, résolu par une lambda expression supprimant les « key » dans le keySet du HashMap de références. 


# Exercice 4_4 : Création et éxecution de scripts
Exercice consistant à l'implémentation de Script de format suivant

![alt text](https://github.com/Romain29000/ReadMe/blob/master/exo4_4.png "exo4_4")

### Test pour le programme : Script à entrer dans la console
```java
(space addScript addRect ((self name w w2 c)(self add name ( Rect new ) ) ( self.name setColor c)( self.name setDim w w2) ))
(space addRect robi 350 120 red)
(space addScript addRect ((self name w w2 c)(self add name ( Rect new ) ) ( self.name setColor c)( self.name setDim w w2) ))
(space delScript addRect)

(space addScript addOval ((self name w w2 c)(self add name (Oval new ) ) ( self.name setColor c)( self.name setDim w w2) ))
(space addOval oval 150 90 yellow)

(space addScript translateEtDim ((self name w w2 c)(self.name translate w w2)( self.name setDim w w2) ))
(space translateEtDim robi 150 30 yellow)
```

### Problèmes rencontrés : 
- Gestion des paramètres dans le Script, c'est à dire que le nombre de paramètres est statique et ne peut être changer. Donc même sans avoir besoin de la valeur Color par exemple il faut l'entrer dans l'appel du Script . (Solution possible : stocker les paramètres dans un tableau et les répartir dans le script quand ils sont appelés) 
- Fiabilité du Script, les commandes dans le Script ne sont pas gérer autrement que par la façon original. Si la commande n'est pas dans le bon sens par exemple.
- Plusieurs vérifications de fonctionnement supplémentaires peuvent être ajouter.


# Conclusion du projet
Ce projet m'a appris pas mal de choses sur la programmation objet et comment l'optimiser au mieux. Je pense que pour améliorer mon projet je devrais rajouter des validations et vérifications lors de l'utilisation de certaines commandes.
