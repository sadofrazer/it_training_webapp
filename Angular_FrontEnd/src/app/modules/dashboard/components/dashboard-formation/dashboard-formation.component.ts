import { Component, OnInit } from '@angular/core';


import { Formation } from 'src/app/entities/Formation/formation';
import { Session } from 'src/app/modules/session/entities/Session';

import { DashboardService } from '../../services/dashboard.service';


@Component({
  selector: 'app-dashboard-formation',
  templateUrl: './dashboard-formation.component.html',
  styleUrls: ['./dashboard-formation.component.scss']
})
export class DashboardFormationComponent implements OnInit {

  public currentDate = new Date();

  public formations : Formation[];

  public sessions : Session[];

  public session : Session;

  public formation : Formation;


  public errorMsg: string="";

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
