import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SerenityComponent } from './serenity.component';

describe('SerenityComponent', () => {
  let component: SerenityComponent;
  let fixture: ComponentFixture<SerenityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SerenityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SerenityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
