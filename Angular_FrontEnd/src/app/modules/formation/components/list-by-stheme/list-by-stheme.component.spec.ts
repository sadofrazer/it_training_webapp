import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBySthemeComponent } from './list-by-stheme.component';

describe('ListByThemeComponent', () => {
  let component: ListBySthemeComponent;
  let fixture: ComponentFixture<ListBySthemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBySthemeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBySthemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
