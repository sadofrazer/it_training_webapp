import { Component, Input, OnInit } from '@angular/core';
import { Session } from 'src/app/modules/session/entities/Session';
import { DashboardService } from '../../services/dashboard.service';


@Component({
  selector: 'app-dashboard-logistique-session',
  templateUrl: './dashboard-logistique-session.component.html',
  styleUrls: ['./dashboard-logistique-session.component.scss']
})
export class DashboardLogistiqueSessionComponent implements OnInit {

  @Input()
  public sessions : Session[];

  public session : Session;


  public errorMsg: string="";

  constructor(private dashBoardService: DashboardService) { }

  ngOnInit(): void {
  }

  onSubmitFormSession(){
    console.log(this.sessions);
    console.log(this.session);
    this.dashBoardService.getSessionById(this.session.idSession).subscribe({
      next: session => {
        this.session = session;
      },
      error: err => this.errorMsg = err
    });
  }

}