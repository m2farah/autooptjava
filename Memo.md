Mémo
=========

* Démarrage, uniquement, des tests de ***commons-math*** (il faut en préalable déjà fait un `mvn clean test`):   
```shell
mvn surefire:test
```

* Recupération du **pid** du ***surefire:test*** pour lancer avec ***powerapi*** :  
  * Pour code original :  
  ```shell
   pid=$(ps aux | grep "commons-math.*" | grep -v "/bin/sh" | grep "commons-math.*\.jar" | grep -o "[0-9]\+" | head -1)
  ```

  * Pour code **spooné** :
  ```shell
  pid=$(ps aux | grep "autooptjava" | grep -v "/bin/sh" | grep "/usr/lib/jvm.*commons-math.*surefire" | grep -o "[0-9]\+" | head -1)
  ```

* Lancement de ***powerapi*** depuis son repértoire:  
```shell
./bin/powerapi modules procfs-cpu-simple monitor --frequency 500 --pids $pid --chart
```


### Sur PowerAPI CLI

Utilisation du module ***procfs cpu simple*** de **PowerAPI** pour mésurer l'énergie. Pour sa configuration, il faut ajouter cette ligne dans `powerapi.cpu.tdp = 35` (pour ma machine, cf [ici][my_tdp]) dans le fichier de configuration de `conf/powerapi.conf`.

### Exemples d'utilisation
Voici quelques exemples dans le repository de PowerAPI : [cliquer ici][exemples_d_utilisation].  

### Memo
* Pour afficher le résultat en graphe. Il faut utiliser l'option `--chart` au lieu de `--console` lors de l'exécution de la commande `bin/powerapi`.

<!-- Raccourcis vers des liens-->
[my_tdp]:https://ark.intel.com/fr/products/53452/Intel-Core-i5-2450M-Processor-3M-Cache-up-to-3_10-GHz
[exemples_d_utilisation]:https://github.com/Spirals-Team/powerapi/wiki/Example-of-usage-CLI

