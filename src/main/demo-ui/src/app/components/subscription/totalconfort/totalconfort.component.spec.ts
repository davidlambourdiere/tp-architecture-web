import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalconfortComponent } from './totalconfort.component';

describe('TotalconfortComponent', () => {
  let component: TotalconfortComponent;
  let fixture: ComponentFixture<TotalconfortComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TotalconfortComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalconfortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
