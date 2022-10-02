
import { Responsable } from "src/app/entities/Utilisateur/Responsable";
import { Session } from "../../session/entities/Session";
import { Salle } from "./salle";

export class AttribSalle{
    public idAttribSalle : number;
    public dateAttrib: Date;
    public dateModif: Date;
    public statut : string;
    public salle : Salle;
    public session : Session;
    public respFor : Responsable;
}