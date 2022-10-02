import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListByThemeComponent } from './list-by-theme.component';

describe('ListFormationComponent', () => {
  let component: ListByThemeComponent;
  let fixture: ComponentFixture<ListByThemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListByThemeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListByThemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
