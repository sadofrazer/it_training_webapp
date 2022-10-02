-- ######################################################################################@
-- suppression des precedentes valeurs entrees dans la base de donnees

DELETE FROM `Utilisateur`;
DELETE FROM `TypeUser`;
DELETE FROM `Operations`;
DELETE FROM `Domaine`;
DELETE FROM `Theme`;
DELETE FROM `SousTheme`;
DELETE FROM `Formation`;
DELETE FROM `TestPrerequis`;
DELETE FROM `ValidationTest`;
DELETE FROM `Salle`;
DELETE FROM `Session`;
DELETE FROM `CheckLogistic`;
DELETE FROM `Inscription`;
DELETE FROM `Emargement`;
DELETE FROM `Evaluation`;
DELETE FROM `Alerte`;
DELETE FROM `AttribSalle`;

-- Domaines
INSERT INTO Domaine (codeDom, nom,`description`) 
VALUES('DINF00001', 'Technologies Informatiques', 'Domaine traitant des principales technologies informatiques existantes à ce jour' );

INSERT INTO Domaine (codeDom, nom,`description`) 
VALUES('DINF00002', 'Gouvernance Informatiques', 'Domaine traitant du management, la stratégie et les gestion des projets TIC' );

INSERT INTO Domaine (codeDom, nom,`description`) 
VALUES('DINF00003', 'Bureautique', "Domaine traitant des outils informatiques d'aide à la Bureautique" );

-- Themes
INSERT INTO Theme (codeTheme, nom,`description`, idDomaine) 
VALUES('TINF00001','Les frameworks web', 'Apprendre à développer des application web complètes... Dev FULLSTACK', 1);

INSERT INTO Theme (codeTheme, nom,`description`, idDomaine) 
VALUES('TINF00002','Devops, Industrialisation et gestion de la production', 'Formations DevOps, industrialisation et gestion de la production', 1);

INSERT INTO Theme (codeTheme, nom,`description`, idDomaine) 
VALUES('TINF00003','Cloud computing', 'Formations Cloud computing', 1);

-- SousThemes
INSERT INTO SousTheme (codeStheme, nom,`description`, idTheme) 
VALUES('STINF00001', 'Création de sites web', 'Formations Création de sites web', 1);

INSERT INTO SousTheme (codeStheme, nom,`description`, idTheme) 
VALUES('STINF00002', 'Intégration et déploiement continue', 'Formations Intégration continue', 2);

INSERT INTO SousTheme (codeStheme, nom,`description`, idTheme) 
VALUES('STINF00003', 'Amazon Web Services', 'Formations Amazon Web Services', 3);

-- TypeUtilisateur
INSERT INTO TypeUser (nom, `description`) 
VALUES ('Responsable', "Responsable ayant un certain niveau d'exploitation sur l'application");

INSERT INTO TypeUser (nom, `description`) 
VALUES ('APPRENANT', "Client devant consommer des produits ou formations du site");

INSERT INTO TypeUser (nom, `description`) 
VALUES ('FORMATEUR', "Intervenant devant animer des formations");

-- Utilisateur
INSERT INTO Utilisateur (`type`, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idType, fonction) 
VALUES ('RESP','USER0001', 'sado', 'frazer','','frazer@frazer.fr',NULL,'','','','ACTIVE','sadofrazer','ittraining@123', 'IT TRAINING', 1, 'Admin');

INSERT INTO Utilisateur (`type`,codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idType, fonction) 
VALUES ('RESP','USER0002', 'Michel', 'Bouari','','michel@michel.com',NULL,'','','','ACTIVE','b.michel','michel@123', 'IT TRAINING', 1, 'RESP CAT');

INSERT INTO Utilisateur (`type`,codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idType, fonction) 
VALUES ('RESP','USER0003', 'Guillaume', 'TSAGUE','','tsague@tsague.net',NULL,'','','','ACTIVE','t.guillaume','guillaume@123', 'IT TRAINING', 1, 'RESP FORM');

INSERT INTO Utilisateur (`type`,codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idType, fonction) 
VALUES ('RESP','USER0004', 'jean', 'LAPORTE','','jean@jean.cm',NULL,'','','','ACTIVE','l.jean','jean@123', 'IT TRAINING', 1, 'RESP LOG');

INSERT INTO Utilisateur (`type`, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idType) 
VALUES ('APP', 'USER0005', 'Mathieu', 'NGASSA','+331789900','test@test.com',STR_TO_DATE('10-May-2005', '%d-%M-%Y'),'244434555','','BAC +2','ACTIVE','n.mathieu','mathieu@123', 'GLOB CONSULTING', 2);

INSERT INTO Utilisateur (`type`, codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idType) 
VALUES ('FORM', 'USER0006', 'Etienne', 'CASSIN','','etienne@etienne.com',NULL,'','','JAVA Certified','ACTIVE','c.etienne','etienne@123', 'Dreams', 3);

-- Formation
INSERT INTO Formation (codeFormation, nom,`description`, `nbreJrs`, idStheme, idRespCat) 
VALUES("FOR00001", "Conception d'interfaces graphiques full JavaScript avec Angular, TypeScript et Bootstrap",
"Formation Conception d'interfaces graphiques full JavaScript avec Angular, TypeScript et Bootstrap",3, 1, 2);

INSERT INTO Formation (codeFormation, nom,`description`,`nbreJrs`, idStheme, idRespCat) 
VALUES("FOR00002", "Gitlab CI/CD",
"Bien démarrer sur la plate-forme DevOps complète GitLab",3, 2, 2);

INSERT INTO Formation (codeFormation, nom,`description`,`nbreJrs`, idStheme, idRespCat) 
VALUES("FOR00003", "Amazon Web Services (AWS) - Architecture avancé",
"Amazon Web Services (AWS) - Architecture avancée; Concevoir des solutions complexes" ,3, 3, 2);

-- Salle
INSERT INTO Salle (codeSalle, adresse, nomSalle, nbrePlaces, statut, ville) 
VALUES ('NTE0001', '44000 NANTES', 'LA BEAUJOIRE', 12, 'RESERVED', 'NANTES');

INSERT INTO Salle (codeSalle, adresse, nomSalle, nbrePlaces, statut, ville) 
VALUES ('NTE0002', '44230 Saint Seb', 'ATLANTIS', 10, 'RESERVED', 'NANTES');

INSERT INTO Salle (codeSalle, adresse, nomSalle, nbrePlaces, statut, ville) 
VALUES ('NTE0003', '44000 NANTES', 'MANGIN', 4, 'FREE', 'NANTES');

-- Session
INSERT INTO `Session` (codeSession, nom, `description`, statut, `type`, dateDebut, dateFin, prix, idRespFor, idFormateur, idFormation)
VALUES ('SESS00001','FORMATION DEVELOPPEMENT WEB ','SESSION DE FORMATION SUR LE DEVELOPPEMENT WEB DE FIN MAI', 
'PLAN', 'INTER', STR_TO_DATE('25-May-2022', '%d-%M-%Y'), STR_TO_DATE('31-May-2022', '%d-%M-%Y'), 2395, 3, 6, 1);

-- AttribSalle
INSERT INTO AttribSalle (dateAttrib, statut, idSession, idSalle, idRespFor) 
VALUES (STR_TO_DATE('22-May-2022', '%d-%M-%Y'),'ACTIVE', 1, 1, 3);

-- CheckLogistic
INSERT INTO CheckLogistic (codeCheck, salleIsOk, toolsIsOk, commentaires, idRespLog, idSession) 
VALUES ('CHK00001', false, false, "Check Pas encore réalisé",4, 1);

-- Inscription
INSERT INTO Inscription (codeInscription, statut, dateInscription, idApprenant, idSession) 
VALUES('INS00001', 'NEW', STR_TO_DATE('15-May-2022', '%d-%M-%Y'), 5, 1);

-- Emargements
INSERT INTO Emargement (codeEmarg, nom, periode, statut, dateSign, presenceIsOk, idInscription) 
VALUES('SIGN00001', 'SIGNATURE MATIN SESS00001', 'MATIN', 'NEW', NULL, false, 1);
INSERT INTO Emargement (codeEmarg, nom, periode, statut, dateSign, presenceIsOk, idInscription) 
VALUES('SIGN00001', 'SIGNATURE SOIR SESS00001', 'SOIR', 'NEW', NULL, false, 1);

-- Evaluations
INSERT INTO Evaluation (codeEval, nom, `description`, dateEval, statut, evalIsOk, idInscription) 
VALUES('EVAL00001','EVALUATION SESS00001','EVALUATION SESS00001',NULL, 'NEW', false, 1);
