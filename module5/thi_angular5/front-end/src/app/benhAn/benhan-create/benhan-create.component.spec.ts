import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhanCreatComponent } from './benhan-create.component';

describe('BenhanCreatComponent', () => {
  let component: BenhanCreatComponent;
  let fixture: ComponentFixture<BenhanCreatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhanCreatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhanCreatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
