# Rapport de la vidéo Spring MVC Thylemeaf Spring Data JPA (All In One Spring MVC Thymeleaf Spring Security - Master II-BDCC) , réalisée par Mr.Mohamed Youssfi
Cette vidéo offre une démonstration pratique de la mise en œuvre d'une application Spring Boot avec Spring MVC, JPA et Thymeleaf. Ce projet représente une application web simple permettant de gérer une liste de produits.

Lien : https://www.youtube.com/watch?v=FHy7raIldgg

## Introduction
Ce projet est une application web développée avec Spring Boot , intégrant la sécurité via Spring Security , et utilisant Thymeleaf comme moteur de template. L'objectif semble être la gestion d’un catalogue de produits avec des fonctionnalités CRUD (Créer, Lire, Mettre à jour, Supprimer), en distinguant les rôles utilisateurs (USER) et administrateurs (ADMIN).

## Technologies utilisées :
  - Java 17+
  - Spring Boot : Pour la configuration rapide et l’auto-démarrage
  - Spring MVC : Pour le développement web basé sur les contrôleurs
  - Spring Security : Gestion de l’authentification et des autorisations
  - JPA / Hibernate : Persistance des données avec une base en mémoire
  - Thymeleaf : Moteur de templates HTML
  - Bootstrap 5 : Pour la mise en page et l’aspect visuel
  - H2 Database (en mémoire) : Base de données utilisée pour les tests
![image](https://github.com/user-attachments/assets/7e589450-f209-43aa-869b-880388afcd79)


## Packages Principaux
  - net.zerhouani.bdccfsmspringmvc.sec : Configuration de la sécurité
  - net.zerhouani.bdccfsmspringmvc.entities : Entité JPA Product
  - net.zerhouani.bdccfsmspringmvc.repository : Interface de persistance ProductRepository
  - net.zerhouani.bdccfsmspringmvc.web : Contrôleur ProductController
  - net.zerhouani.bdccfsmspringmvc : Classe principale BdccFsmSpringMvcApplication

## Sécurité (Spring Security)
  - Configuration : SecurityConfig.java
  - Utilisation de l’authentification en mémoire avec InMemoryUserDetailsManager
  - Trois utilisateurs prédéfinis :
      * user1, user2 → rôle USER
      * admin → rôles USER et ADMIN
  - Encodage des mots de passe via BCryptPasswordEncoder
  - Protection des URLs selon les rôles :
      * /index/** → accessible aux USER
      * /admin/** → réservé aux ADMIN
      * /public/** et /webjars/** → accessibles à tous
  - Page de login personnalisée : /login
  - Gestion personnalisée de l’accès refusé : /notAuthorized
  - Désactivation CSRF (pour simplifier les tests locaux)

## Entité & Repository
### Product.java
  - Entité JPA persistante avec annotation @Entity
  - Champs :
      * id : Clé primaire auto-incrémentée
      * name : Nom du produit (obligatoire, entre 3 et 50 caractères)
      * price : Prix ≥ 0
      * quantity : Quantité ≥ 1
  - Annotations de validation utilisées :
      * @NotEmpty, @Size, @Min
### ProductRepository.java
  - Interface qui étend JpaRepository<Product, Long>
  - Permet les opérations CRUD standard sans implémentation manuelle

## Vue (Thymeleaf + Bootstrap)
### products.html
  - Template principal héritant d’une structure commune
  - Barre de navigation responsive avec Bootstrap
  - Affichage dynamique de la liste des produits
  - Menu utilisateur avec affichage du nom connecté et lien de déconnexion
### layout1.html
  - Template servant comme layout pour la décoration des pages avec un navbar.
  - Contient des liens redirigeant vers :
      * Products : page des produits.
      * Home : Page des produits
      * Logout : déconnexion
      * username : nom de l'utilisateur connecté
### newProduct.html
  - Formulaire permettant d’ajouter un nouveau produit
  - Champs :
      * name : Nom du produit
      * price : Prix
      * quantity : Quantité disponible
  - Validation côté serveur avec affichage des erreurs
### notAuthorized.html
  - Message simple indiquant que l’utilisateur n’a pas les droits nécessaires
  - Utilise le layout commun pour garder la cohérence visuelle
### login.html 
  - Formulaire simple d’authentification avec champs :
      * username
      * password
  - Utilise Bootstrap pour un style moderne
  - Redirige vers /login via méthode POST

## Resultats

### Premier test
![image](https://github.com/user-attachments/assets/7e3ee6fb-9d3f-4a8a-a673-ecef90d91ddb)
![image](https://github.com/user-attachments/assets/73a6bc2a-61a1-4be6-9ec5-870ac75e4479)

### Finale :
![image](https://github.com/user-attachments/assets/77442aec-6d72-41ad-b2ce-9aef4f0531a6)

#### Suppression
![image](https://github.com/user-attachments/assets/9f5fe939-5c75-42fb-b217-d426d84373ff)
![image](https://github.com/user-attachments/assets/42b527b0-4bfb-4856-8500-27213b332730)
![image](https://github.com/user-attachments/assets/1ff042eb-8e0e-4bd2-8faa-db101488af2b)

#### Ajout : 
![image](https://github.com/user-attachments/assets/0424ba58-edaa-453e-af2c-690b3a8db266)
![image](https://github.com/user-attachments/assets/3ae8c512-66e0-4a2e-a481-b314325f3b5d)

#### Role USER :
![image](https://github.com/user-attachments/assets/c7567425-e696-4048-a628-5a6a1bc85bc3)
![image](https://github.com/user-attachments/assets/45fcae18-9251-457d-afc8-6d8f2be53acf)

## Conclusion
Ce projet représente une application Spring MVC simple mais complète , mettant en œuvre les bonnes pratiques de développement :
  - Séparation des couches (MVC),
  - Validation des données,
  - Gestion des rôles utilisateurs,
  - Les vues HTML du projet montrent une bonne maîtrise de :
      * Thymeleaf (héritage de template, expressions dynamiques)
      * Bootstrap (responsive design, composants UI)
      * Spring Security (affichage conditionnel, authentification)
      * Elles sont cohérentes , claires , et bien structurées , ce qui facilite la maintenance et l’évolution.
Il peut servir de base pédagogique ou de prototype pour une application de gestion de stock ou de boutique en ligne simplifiée.








