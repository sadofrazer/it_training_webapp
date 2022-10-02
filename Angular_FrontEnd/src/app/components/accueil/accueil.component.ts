import { Component, OnInit, ViewChild  } from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs';
import { Formation } from 'src/app/entities/Formation/formation';
import { FormationService } from 'src/app/modules/formation/services/formation.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {
  public formations$: Observable<Formation[]>;
  constructor( private formationService: FormationService, private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.formations$=this.formationService.getAllFormations();
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  //Caroussel
  images = [1,2,3].map((n) => `../../../assets/img/caroussel${n}.jpg`);
  paused = false;
  unpauseOnArrow = false;
  pauseOnIndicator = false;
  pauseOnHover = true;
  pauseOnFocus = true;
  @ViewChild('carousel', {static : true}) carousel: NgbCarousel;
  
  togglePaused() {
    if (this.paused) {
      this.carousel.cycle();
    } else {
      this.carousel.pause();
    }
    this.paused = !this.paused;
  }

  onSlide(slideEvent: NgbSlideEvent) {
    if (this.unpauseOnArrow && slideEvent.paused &&
      (slideEvent.source === NgbSlideEventSource.ARROW_LEFT || slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)) {
      this.togglePaused();
    }
    if (this.pauseOnIndicator && !slideEvent.paused && slideEvent.source === NgbSlideEventSource.INDICATOR) {
      this.togglePaused();
    }
  }
}
