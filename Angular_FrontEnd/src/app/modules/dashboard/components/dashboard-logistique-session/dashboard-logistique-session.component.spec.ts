import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardLogistiqueSessionComponent } from './dashboard-logistique-session.component';

describe('DashboardLogistiqueSessionComponent', () => {
  let component: DashboardLogistiqueSessionComponent;
  let fixture: ComponentFixture<DashboardLogistiqueSessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardLogistiqueSessionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardLogistiqueSessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
