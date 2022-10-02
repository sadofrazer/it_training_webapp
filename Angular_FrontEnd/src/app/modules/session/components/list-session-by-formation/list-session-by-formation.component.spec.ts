import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSessionByFormationComponent } from './list-session-by-formation.component';

describe('ListSessionByFormationComponent', () => {
  let component: ListSessionByFormationComponent;
  let fixture: ComponentFixture<ListSessionByFormationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSessionByFormationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSessionByFormationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
