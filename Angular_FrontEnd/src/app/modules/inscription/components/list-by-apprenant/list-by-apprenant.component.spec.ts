import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListByApprenantComponent } from './list-by-apprenant.component';

describe('ListByApprenantComponent', () => {
  let component: ListByApprenantComponent;
  let fixture: ComponentFixture<ListByApprenantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListByApprenantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListByApprenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
