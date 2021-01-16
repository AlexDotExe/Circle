import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSubfeedsComponent } from './list-subfeeds.component';

describe('ListSubfeedsComponent', () => {
  let component: ListSubfeedsComponent;
  let fixture: ComponentFixture<ListSubfeedsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListSubfeedsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSubfeedsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
