import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategotyDeleteComponent } from './category-delete.component';

describe('CategotyDeleteComponent', () => {
  let component: CategotyDeleteComponent;
  let fixture: ComponentFixture<CategotyDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategotyDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategotyDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
