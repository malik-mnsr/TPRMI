# Contenu
Ce projet contient :

    3 Module : 
    
    un module TP_RMI_RMI pour le client.
    
    Un module TP_RMI_CLIENT pour le client. 
    
    Un module TP_RMI contenant les classes communes au deux projets.
    
    Un fichier policy pour la sécurisation de l'accès. 

    Ce README.
    
    Un rapport sur le développement du projet.

# Pré-requis
- Le projet est fait pour fonctioner sur tous les systemes d'exploitation.
- Vous avez besoin d'avoir JAVA d'installé sur votre machine.
- Lancer `java --version` pour verifier que l'installtion est effecuté
- Pour executer le program vous devez lancer les commandes suivantes dans leur ordre.
    1. Acceder au nom du projet
    2. Lancer `javac IAnimal ICabinet IClient IDossierSuivi IEspece`
    3. Lancer `javac Chien.java Client.java MainClient.java`
    4. Lancer `javac AnimalImpl.java CabinetImpl.java DossierSuiviImpl.java EspeceImpl.java Server.java` 

# Utilisation
    
    Lors que tous les etapes sont faites:
    -   On lance le serveur java Server.
    -   La console doit retourner 200 (càd le serveur est lancé).
    -   Puis on lance le client java MainClient.
    -   La console doit retrouner 'Connecté'.
    -   On a 5 opération chaque operation est attribué a un nombre.
    -   L'operation est specifié apres le nombre entré par l'utilisateur.

# Remarques


### Comme RMI est une ancienne technique. il se peut lors de l'ajout recevoir des erreurs de type "Connection Refused". 
### Ceci n'est pas un probleme dans le code car il suffit simplement de redémarrer l'un du server ou client pour corriger le probleme qui se trouve aléatoirement et generalement
