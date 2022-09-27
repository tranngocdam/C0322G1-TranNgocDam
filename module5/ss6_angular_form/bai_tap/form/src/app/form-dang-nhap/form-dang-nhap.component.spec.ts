import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDangNhapComponent } from './form-dang-nhap.component';

describe('FormDangNhapComponent', () => {
  let component: FormDangNhapComponent;
  let fixture: ComponentFixture<FormDangNhapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormDangNhapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormDangNhapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
