import { Component } from '@angular/core';

@Component({
  selector: 'page-404',
  template: `
  <head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
  <div class='center'>
    <img src="http://assets.pokemon.com/assets/cms2/img/pokedex/full/035.png"/>
    <h1>Hey, cette page n'existe pas !</h1>
    <button><a routerLink="/acceuil" class="waves-effect waves-teal btn-flat">
      Retourner à l' accueil
    </a></button>
  </div>
  `,
  styles: [
  ]
})
export class PageNotFoundComponent  {

 
}
