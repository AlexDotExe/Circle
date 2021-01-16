import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubfeedSideBarComponent } from './subfeed-side-bar.component';

describe('SubfeedSideBarComponent', () => {
  let component: SubfeedSideBarComponent;
  let fixture: ComponentFixture<SubfeedSideBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubfeedSideBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubfeedSideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
