import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSubfeedComponent } from './create-subfeed.component';

describe('CreateSubfeedComponent', () => {
  let component: CreateSubfeedComponent;
  let fixture: ComponentFixture<CreateSubfeedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSubfeedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSubfeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
