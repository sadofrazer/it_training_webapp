
import { Session } from "src/app/modules/session/entities/Session";
import { Apprenant } from "../Utilisateur/Apprenant";


export class Inscription{
    public idInscription : number;
    public codeInscription : string;
    public statut : string;
    public dateInscription : Date;
    public apprenant : Apprenant;
    public session : Session;
}