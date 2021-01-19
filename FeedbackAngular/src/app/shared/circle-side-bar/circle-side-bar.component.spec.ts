import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CircleSideBarComponent } from './circle-side-bar.component';

describe('CircleSideBarComponent', () => {
  let component: CircleSideBarComponent;
  let fixture: ComponentFixture<CircleSideBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CircleSideBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CircleSideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
