import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardFormationSessionComponent } from './dashboard-formation-session.component';

describe('DashboardFormationSessionComponent', () => {
  let component: DashboardFormationSessionComponent;
  let fixture: ComponentFixture<DashboardFormationSessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardFormationSessionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardFormationSessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
