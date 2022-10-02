import { TypeUser } from "./typeuser";

export const UTILISATEUR_API_URL: string = "UTILISATEUR_REST_API_URL";

export class Utilisateur{
   idUtilisateur: number ;
    codeUser: string;
    nom: string;
    prenom: string;
    telephone: string;
    email: string;
    adresse: string;
    dateNaiss: Date;
    numeroSiret: string;
    login: string;
    password: string;
    picture: string;
    societe: string;
    statut: string;
    
    typeUser: TypeUser
 

constructor(
   
    codeUser: string = "",
    nom: string = "",
    prenom: string ="",
    telephone: string ="",
    email: string = "",
    adresse: string = "",
    dateNaiss: Date = new Date,
    numeroSiret: string = "",
    login: string ="",
    password: string ="",
    societe: string ="",
    statut: string="",
   
   // picture: string = "/assets/Images/utilisateur.png",
    
){
    
    this.codeUser = codeUser;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.email = email;
    this.adresse =adresse;
    this.dateNaiss = dateNaiss;
    this.numeroSiret = numeroSiret;
    this.login = login;
    this.password = password;
    this.societe = societe;
    this.statut = statut;
  //  this.picture = picture
   
   
}
}