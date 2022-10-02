import { Component, Input, OnInit } from '@angular/core';
import { Session } from 'src/app/modules/session/entities/Session';
import { DashboardService } from '../../services/dashboard.service';



@Component({
  selector: 'app-dashboard-formation-session',
  templateUrl: './dashboard-formation-session.component.html',
  styleUrls: ['./dashboard-formation-session.component.scss']
})
export class DashboardFormationSessionComponent implements OnInit {


  @Input()
  public sessions : Session[];

  public session : Session;

  public errorMsg: string="";


  constructor(private dashBoardService: DashboardService) { }

  ngOnInit(): void {
  }

  onSubmitFormSession(){
    this.dashBoardService.getSessionById(this.session.idSession).subscribe({
      next: session => {
        this.session = session;
      },
      error: err => this.errorMsg = err
    });
  }

}
