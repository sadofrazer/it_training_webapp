import { Component, OnInit } from '@angular/core';
import { Formation } from 'src/app/entities/Formation/formation';
import { Session } from 'src/app/modules/session/entities/Session';
import { DashboardService } from '../../services/dashboard.service';

@Component({
  selector: 'app-dashboard-logistique',
  templateUrl: './dashboard-logistique.component.html',
  styleUrls: ['./dashboard-logistique.component.scss']
})
export class DashboardLogistiqueComponent implements OnInit {

    public formation : Formation;

    public session : Session;

    public sessions : Session[];

    public formations : Formation[];

    public errorMsg: string="";

    public currentDate = new Date();


  constructor(private dashBoardService: DashboardService) { }

  ngOnInit(): void {
    this.dashBoardService.getApiFormations().subscribe({
      next: formations => {
        this.formations = formations;
      },
      error: err => this.errorMsg = err
    });
  }

  onSubmitFormFormation(){
    console.log(this.formation)
    this.dashBoardService.getFormationSessions(this.formation.idFormation).subscribe({
      next: sessions => {
        this.sessions = sessions;
      },
      error: err => this.errorMsg = err
    });
  }

}
