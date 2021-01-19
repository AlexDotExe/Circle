import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCirclesComponent } from './list-circles.component';

describe('ListCirclesComponent', () => {
  let component: ListCirclesComponent;
  let fixture: ComponentFixture<ListCirclesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCirclesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCirclesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
