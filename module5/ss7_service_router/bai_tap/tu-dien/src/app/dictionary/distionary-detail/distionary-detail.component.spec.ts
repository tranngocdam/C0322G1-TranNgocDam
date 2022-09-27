import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DistionaryDetailComponent } from './distionary-detail.component';

describe('DistionaryDetailComponent', () => {
  let component: DistionaryDetailComponent;
  let fixture: ComponentFixture<DistionaryDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DistionaryDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DistionaryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
