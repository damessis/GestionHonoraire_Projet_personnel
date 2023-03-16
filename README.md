# GestionHonoraire_Projet_personnel

GestionHonnoraire est un logiciel développé en Java 8 pour la gestion des honoraires dans un institut de formation supérieure togolais. Ce système est unique, mais peut être utilisé par trois catégories d'utilisateurs différentes, chacune ayant ses propres autorisations et fonctionnalités.

  # Fonctionnalités

Les fonctionnalités du logiciel sont les suivantes :

*Authentification basée sur l'identifiant et la catégorie d'utilisateur
*Trois catégories d'utilisateurs : comptable, secrétaire et enseignant
*Les enseignants peuvent entrer ou consulter leurs heures travaillées
*Le comptable est considéré comme un administrateur et peut créer tous les autres utilisateurs
*Les secrétaires peuvent créer, modifier et supprimer des enseignants, des unités d'enseignement et fixer des taux horaires
*Interface graphique développée avec JavaFX et SceneBuilder avec l'importation de certaines librairies externes telles que JFoenix et FontAwesome
*Base de données implémentée et préalablement testée sur PhpMyAdmin (sur WampServer)
*Le code est bien structuré et documenté avec des commentaires pour faciliter la compréhension et la prise en main

  # Pré-requis
*Java 8
*PhpMyAdmin sur WampServer

  # Installation et utilisation
Télécharger le projet depuis le dépôt GitHub.
Ouvrir le projet dans un environnement de développement Java compatible (par exemple, Eclipse ou IntelliJ IDEA).
Configurer la base de données en modifiant les paramètres de connexion dans le fichier src/main/java/com/gestionhonnoraire/dao/ConnectDB.java.
Exécuter le programme en lançant la classe src/main/java/com/gestionhonnoraire/App.java.
S'authentifier en utilisant les identifiant de test présent dans db_honnoraire.sql (usernane= admin1  password= 1111) ou alors créé une nouvelle bd et faites une insertion d'admin

