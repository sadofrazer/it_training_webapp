import { Responsable } from "../Utilisateur/Responsable";
import { Stheme } from "./sous-theme";

export const FORMATION_API_URL: string = "FORMATION_REST_API_URL";

export class Formation{
    public idFormation : number;
    public codeFormation : string;
    public nom : string;
    public description : string;
    public nbreJrs : number;
    public respCat : Responsable;
    public stheme : Stheme;
    public objectifs : string;
    public programme : string;
}