-- Suppression des contraintes 
-- ALTER TABLE Theme DROP FOREIGN KEY FK_Themes_Domaines;
-- ALTER TABLE SousTheme DROP FOREIGN KEY FK_SThemes_Themes;
-- ALTER TABLE Formation DROP FOREIGN KEY FK_Formation_SThemes;
-- ALTER TABLE Formation DROP FOREIGN KEY FK_Formation_Utilisateur;
-- ALTER TABLE TestPrerequis DROP FOREIGN KEY FK_TestP_Formation;
-- ALTER TABLE ValidationTest DROP FOREIGN KEY FK_ValidTest_TestP;
-- ALTER TABLE ValidationTest DROP FOREIGN KEY FK_ValidTest_Utilisateur;
-- ALTER TABLE Utilisateur DROP FOREIGN KEY FK_Utilisateur_TypeU;
-- ALTER TABLE Operations DROP FOREIGN KEY FK_Ope_User;
-- ALTER TABLE `Session` DROP FOREIGN KEY FK_Session_User;
-- ALTER TABLE `Session` DROP FOREIGN KEY FK_Session_Formation;
-- ALTER TABLE `Session` DROP FOREIGN KEY FK_Session_Salle;
-- ALTER TABLE Inscription DROP FOREIGN KEY FK_Ins_Session;
-- ALTER TABLE Inscription DROP FOREIGN KEY FK_Ins_Utilisateur;
-- ALTER TABLE CheckLogistic DROP FOREIGN KEY FK_Check_Utilisateur;
-- ALTER TABLE CheckLogistic DROP FOREIGN KEY FK_Check_Session;
-- ALTER TABLE Emargement DROP FOREIGN KEY FK_Emarg_Inscription ;
-- ALTER TABLE Evaluation DROP FOREIGN KEY FK_Eval_Inscription;
-- ALTER TABLE Alerte DROP FOREIGN KEY FK_Alert_Inscription;
-- ALTER TABLE Alerte DROP FOREIGN KEY FK_Alert_Session ;
-- ALTER TABLE Alerte DROP FOREIGN KEY FK_Alert_User ;


-- ######################### Nouvelle Création ###########################
-- Creation de la BDD
DROP DATABASE IF EXISTS it_training_bdd;
CREATE DATABASE it_training_bdd;

use it_training_bdd;

-- Suppression des tables
-- DROP TABLE IF EXISTS Utilisateur, TypeUtilisateur, Operations, Domaines, Themes, SousThemes, Formation, TestPrerequis, 
-- ValidationTest, Salle, `Session`, `Checklogistic`, `Inscription`, `Emargements`, `Evaluation`, `Alerte`;

-- Creation des tables
CREATE TABLE `Utilisateur` (
  `idUtilisateur` int PRIMARY KEY AUTO_INCREMENT, -- Clé primaire auto incrémentée
  `codeUser` varchar(10) not null UNIQUE, -- code qui alpha numérique affiché au user (USR + (ID sur 5 digits)) USR00001
  `nom` varchar(50) not Null,
  `prenom` varchar(50),
  `telephone` varchar(20),
  `email` varchar(50) UNIQUE,
  `dateNaiss` date,
  `numeroSiret` varchar(50),
  `certifications` varchar(250),
  `dernierDiplome` varchar(250),
  `login` varchar(20) not null,
  `password` varchar(20) not null,
  `societe` varchar(50),
  `fonction` varchar(50),
  `statut` varchar(10) not null, -- ACTIVE / INACTIVE attribut à utiliser pour faire du safe delete
  `idTypeUser` int not null
);

CREATE TABLE `TypeUtilisateur` (
  `idType` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) not null,
  `description` varchar(250)
);

CREATE TABLE `Operation` (
  `idOperation` int PRIMARY KEY AUTO_INCREMENT,
  `codeOpe` varchar(10) not null UNIQUE,
  `nom` varchar(250) not null,
  `description` varchar(250),
  `typeres` varchar(10) not null,
  `dateDebut` datetime not null,
  `idUtilisateur` int not null
);


CREATE TABLE `Domaine` (
  `idDomaine` int PRIMARY KEY AUTO_INCREMENT,
  `codeDom` varchar(10) not null UNIQUE,
  `nom` varchar(250) not null,
  `description` varchar(250)
);

CREATE TABLE `Theme` (
  `idTheme` int PRIMARY KEY AUTO_INCREMENT,
  `codeTheme` varchar(10) not null UNIQUE,
  `nom` varchar(250) not null,
  `description` varchar(250),
  `idDomaine` int not null
);

CREATE TABLE `SousTheme` (
  `idStheme` int PRIMARY KEY AUTO_INCREMENT,
  `codeSthem` varchar(10) not null UNIQUE,
  `nom` varchar(250) not null,
  `description` varchar(250),
  `idTheme` int not null
);

CREATE TABLE `Formation` (
  `idFormation` int PRIMARY KEY AUTO_INCREMENT,
  `codeFormation` varchar(10) not null UNIQUE,
  `nom` varchar(250) not null,
  `description` varchar(250),
  `nbreJrs` int not null,
  `idStheme` int not null,
  `idRespCat` int not null
);

CREATE TABLE `TestPrerequis` (
  `idTest` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(60) not null,
  `description` varchar(250),
  `idFormation` int not null
);

CREATE TABLE `ValidationTest` (
  `idVal` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(250) not null,
  `commentaires` varchar(250),
  `resultat` numeric not null,
  `idtest` int not null,
  `idapprenant` int not null
);

CREATE TABLE `Salle` (
  `idSalle` int PRIMARY KEY AUTO_INCREMENT,
  `codeSalle` varchar(10) not null UNIQUE, -- ROOM00001
  `adresse` varchar(50),
  `nomSalle` varchar(50) not null,
  `nbrePlaces` int not null,
  `statut` varchar(10) not null --  FREE (Libre) | BUSY (Occupée) | RESERVED | ACTIVE | INACTIVE
);

CREATE TABLE `AttribSalle` (
  `idAttribSalle` int PRIMARY KEY AUTO_INCREMENT,
  `dateAttrib` date,
  `statut` varchar(10), -- ACTIVE | INACTIVE
  `idSession` int not null,
  `idSalle` int not null,
  `idRespFor` int not null
);

CREATE TABLE `Session` (
  `idSession` int PRIMARY KEY AUTO_INCREMENT,
  `codeSession` varchar(10) not null UNIQUE, -- SESS00001
  `nom` varchar(120) not null,
  `description` varchar(250),
  `statut` varchar(10) not null, -- PLAN (Planifiée) | CONF (Confirm) | ENC (En cours) | TERM (Terminée) | ACTIVE | INACTIVE
  -- Lorsque l'on crée une session, elle se met automatiquement à l'état PLAN et par la meme occasion fait passer ses 
  -- salles à l'état RESERVED. Si toutes les conditions sont remplies, elle passe à l'état  CONF et la salle BUSY 
  -- a la fin de la session, l'état est TERM et la salle passe à FREE (ACTIVE et INACTIVE concenent la suppression des éléments)
  `type` varchar(10) not null,
  `dateDebut` date not null,
  `dateFin` date not null,
  `prix` decimal(10,2),
  `idRespFor` int not null,
  `idFormateur` int not null,
  `idFormation` int not null
);

CREATE TABLE `CheckLogistic` (
  `idCheck` int PRIMARY KEY AUTO_INCREMENT,
  `codeCheck` varchar(10) not null UNIQUE, -- CHECK00001
  `salleIsOk` boolean not null,
  `toolsIsOk` boolean not null,
  `commentaires` varchar(250),
  `idRespLog` int not null,
  `idSession` int not null
);

CREATE TABLE `Inscription` (
  `idInscription` int PRIMARY KEY AUTO_INCREMENT,
  `codeInscription` varchar(10) not null UNIQUE, -- INSC00001
  `statut` varchar(10) not null, -- NEW (Nouvelle inscription pas encore validée) | VALID (Validée) | ENC (En cours) | TERM (Terminée) | ACTIVE | INACTIVE
  `dateInscription` date not null,
  `idApprenant` int not null,
  `idSession` int not null
);

CREATE TABLE `Emargement` (
  `idEmargement` int PRIMARY KEY AUTO_INCREMENT,
  `codeEmarg` varchar(10) not null, -- SIGN00001
  `nom` varchar(120) not null,
  `periode` varchar(10) not null,
  `statut` varchar(10), -- NEW | SEND (alerte envoyée) | SIGN 
  `dateSign` date,
  `presenceIsOk` boolean,
  `idInscription` int not null
);

CREATE TABLE `Evaluation` (
  `idEval` int PRIMARY KEY AUTO_INCREMENT,
  `codeEval` varchar(10) not null UNIQUE,  -- EVAL00001
  `nom` varchar(120) not null,
  `description` varchar(250),
  `dateEval` date,
  `statut` varchar(10), -- NEW | SEND (alerte/évaluation envoyée) | EVAL (Evalué)
  `evalIsOk` boolean,
  `idInscription` int not null
);

CREATE TABLE `Alerte` (
  `idAlerte` int PRIMARY KEY AUTO_INCREMENT,
  `codeAlerte` varchar(10) not null UNIQUE, -- ALERT00001
  `nom` varchar(250) not null,
  `gravite` varchar(10),
  `statut` varchar(10) not null,  -- NEW | VUE (Alerte vue par le user)
  `typeRes` varchar(10) not null,
  `idUtilisateur` int not null
);


-- Creation des contraintes
ALTER TABLE Theme ADD CONSTRAINT FK_Themes_Domaines FOREIGN KEY (idDomaine) REFERENCES Domaines(idDomaine); -- ON DELETE CASCADE;
ALTER TABLE SousTheme ADD CONSTRAINT FK_SThemes_Themes FOREIGN KEY (idTheme) REFERENCES Themes(idTheme);
ALTER TABLE Formation ADD CONSTRAINT FK_Formation_SThemes FOREIGN KEY (idStheme) REFERENCES SousThemes(idStheme);
ALTER TABLE Formation ADD CONSTRAINT FK_Formation_Utilisateur FOREIGN KEY (idRespCat) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE TestPrerequis ADD CONSTRAINT FK_TestP_Formation FOREIGN KEY (idFormation) REFERENCES Formation(idFormation);
ALTER TABLE ValidationTest ADD CONSTRAINT FK_ValidTest_TestP FOREIGN KEY (idTest) REFERENCES TestPrerequis(idTest);
ALTER TABLE ValidationTest ADD CONSTRAINT FK_ValidTest_Utilisateur FOREIGN KEY (idApprenant) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE Utilisateur ADD CONSTRAINT FK_Utilisateur_TypeU FOREIGN KEY (idTypeUser) REFERENCES TypeUtilisateur(idType);
ALTER TABLE Operation ADD CONSTRAINT FK_Ope_User FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_ResFor FOREIGN KEY (idRespFor) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_User FOREIGN KEY (idFormateur) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_Formation FOREIGN KEY (idFormation) REFERENCES Formation(idFormation);
ALTER TABLE `AttribSalle` ADD CONSTRAINT FK_AttribS_Session FOREIGN KEY (idSession) REFERENCES Session(idSession);
ALTER TABLE `AttribSalle` ADD CONSTRAINT FK_AttribS_Salle FOREIGN KEY (idSalle) REFERENCES Salle(idSalle);
ALTER TABLE `AttribSalle` ADD CONSTRAINT FK_AttribS_User FOREIGN KEY (idRespFor) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE Inscription ADD CONSTRAINT FK_Ins_Session FOREIGN KEY (idSession) REFERENCES `Session`(idSession);
ALTER TABLE Inscription ADD CONSTRAINT FK_Ins_Utilisateur FOREIGN KEY (idApprenant) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE CheckLogistic ADD CONSTRAINT FK_Check_Utilisateur FOREIGN KEY (idRespLog) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE CheckLogistic ADD CONSTRAINT FK_Check_Session FOREIGN KEY (idSession) REFERENCES `Session`(idSession);
ALTER TABLE Emargement ADD CONSTRAINT FK_Emarg_Inscription FOREIGN KEY (idInscription) REFERENCES Inscription(idInscription);
ALTER TABLE Evaluation ADD CONSTRAINT FK_Eval_Inscription FOREIGN KEY (idInscription) REFERENCES Inscription(idInscription);
ALTER TABLE Alerte ADD CONSTRAINT FK_Alert_User FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur);
