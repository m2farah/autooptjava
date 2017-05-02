Projet PJI
==
### Sujet : Auto-optimisation de la consommation énergétique des applications Java
________________________

## 1 - Architecture du dépôt
```
autooptjava
  | --> spoonProcessors
          | --> */spoonProcessors/*
  | --> testspoon
  | --> commons-math
  | --> data
```

* Le dossier [spoonProcessors](**spoonProcessors**) intégré dans **autooptjava** contient lui aussi un autre dossier portant son nom. Et c'est dans ce dernier que les processors s'y trouvent. Le dossier **collection** va regrouper les processors qui vise à agir sur les types collections. Tandis que le dossier **test** n'est que la version des processors qui ne sont pas encore finalisés et donc en cours de devéloppement.

* Le répertoire [testspoon](**testspoon**) contient quelques classes pour tester rapidement le processor avant de le faire sur tout autre projet.A termes, il sera intégré dans le dossier **spoonProcessors** comme test unitaire.

* [commons-math](**commons-math**) est le projet qui fera office de test de grande nature. Ce dossier est importé d'[ici][commons-math].

* [data](**data**) stocke quelques captures d'écran fait sur la consommation energétique des ***commons-math***


## 2 - Voir plus
Voir le fichier [Memo.md](**Memo.md**) présent dans ce même dépôt.


<!-- Raccourcis vers des liens-->
[commons-math]:https://github.com/apache/commons-math
