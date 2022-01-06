
# Auteurs : Nedelec Romain // Stoliaroff Clément // Tassy Quentin

# Projet Balise
Le projet balises-satellites simule le fonctionnement de balises sous-marines collectant des données.

![alt text](./screnshots/satellites-balises.png "img1")

### Modifications apportés :
# Correction du bug : 

**Erreur : **

- Une balise vidait ses "datasizes" avant même d'avoir effectué une synchronisation complète avec un satellite.

**Résolution : **

- Mise en place d'un flag "collecte" désignant l'action de collecter des données. Si la collecte est en cours, alors le "datasize" s'incrémente.

- Au moment ou la balise est pleine et en collecte, alors la balise se place en synchronisation et arrête sa collecte. 

- Une fois la synchronisation avec le satellite effectué, la balise se vide.

![alt text](./screnshots/satellites-balises.gif "img2")

# Ajout de jauges de données (Satellites / Balises) :
```java

```

# Transmission des données aux satellites :


# Conclusion du projet
Ce projet m'a appris pas mal de choses sur la programmation objet et comment l'optimiser au mieux. Je pense que pour améliorer mon projet je devrais rajouter des validations et vérifications lors de l'utilisation de certaines commandes.
