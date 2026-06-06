# 🎓 GestionEtudiants

> Application Android de gestion des étudiants avec base de données SQLite embarquée.  
> **Salma AIT ZIDAN** 

---

## 📱 Aperçu

Application mobile Android permettant de gérer une liste d'étudiants localement sur l'appareil, sans connexion Internet. Toutes les données sont stockées dans une base SQLite embarquée.
 
**Package :** `com.example.gestionetudiants`  
**Min SDK :** 21 (Android 5.0 Lollipop)  
**Target SDK :** 34 (Android 14)

---

## ✨ Fonctionnalités

| Fonctionnalité | Description |
|---|---|
| ➕ Ajouter | Saisir Nom + Prénom → insérer en base SQLite |
| 🔍 Chercher | Rechercher un étudiant par son ID |
| 🗑️ Supprimer | Supprimer un étudiant par son ID |
| 📋 Logcat | Toutes les opérations loggées pour débogage |

---

## 🏗️ Architecture

```
app/src/main/java/com/example/gestionetudiants/
├── classes/
│   └── Etudiant.java          ← Modèle métier (id, nom, prenom)
├── util/
│   └── MySQLiteHelper.java    ← Création / mise à jour de la base SQLite
├── service/
│   └── EtudiantService.java   ← CRUD : create, findById, findAll, update, delete
└── MainActivity.java          ← UI : boutons Valider / Chercher / Supprimer
```

### Base de données

- **Fichier :** `ecole.db` (stocké en interne sur l'appareil)
- **Table :** `etudiant(id INTEGER PK AUTOINCREMENT, nom TEXT, prenom TEXT)`

---

## 🚀 Installation & Lancement

### Prérequis
- Android Studio Hedgehog (2023.1) ou plus récent
- JDK 8+
- SDK Android 21+

### Étapes

1. **Cloner le dépôt**
   ```bash
   git clone https://github.com/salmaaitzidan/Lab15.git 
   ```

2. **Ouvrir dans Android Studio**
   - `File → Open` → sélectionner le dossier `GestionEtudiants`
   - Attendre la synchronisation Gradle

3. **Lancer l'application**
   - Connecter un appareil Android ou démarrer un émulateur
   - Cliquer sur ▶️ **Run**

---

## 📂 Structure complète du projet

```
GestionEtudiants/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/gestionetudiants/
│   │   │   ├── classes/Etudiant.java
│   │   │   ├── util/MySQLiteHelper.java
│   │   │   ├── service/EtudiantService.java
│   │   │   └── MainActivity.java
│   │   ├── res/
│   │   │   ├── layout/activity_main.xml
│   │   │   ├── drawable/  (header_bg, card_bg, button_*.xml…)
│   │   │   └── values/    (colors.xml, strings.xml, styles.xml)
│   │   └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── gradle/wrapper/gradle-wrapper.properties
├── build.gradle
├── settings.gradle
├── .gitignore
└── README.md
```

---


## 🐛 Dépannage courant

- **IDs qui augmentent entre les lancements** → Désinstaller l'app pour réinitialiser la base SQLite
- **Crash sur recherche ID inexistant** → Déjà géré : un Toast s'affiche
- **Erreur Gradle sync** → Vérifier la version du JDK dans `File → Project Structure`

---
