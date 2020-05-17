import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Mock.BillingComponent } from './mock.billing.component';

describe('Mock.BillingComponent', () => {
  let component: Mock.BillingComponent;
  let fixture: ComponentFixture<Mock.BillingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Mock.BillingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Mock.BillingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
