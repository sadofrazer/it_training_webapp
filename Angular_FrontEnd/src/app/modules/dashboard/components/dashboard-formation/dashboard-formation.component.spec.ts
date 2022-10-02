import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardFormationComponent } from './dashboard-formation.component';

describe('DashboardFormationComponent', () => {
  let component: DashboardFormationComponent;
  let fixture: ComponentFixture<DashboardFormationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardFormationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardFormationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
