import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhanListComponent } from './benhan-list.component';

describe('BenhanListComponent', () => {
  let component: BenhanListComponent;
  let fixture: ComponentFixture<BenhanListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhanListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhanListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
