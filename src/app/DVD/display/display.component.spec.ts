import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DISPLAYComponent } from './display.component';

describe('DISPLAYComponent', () => {
  let component: DISPLAYComponent;
  let fixture: ComponentFixture<DISPLAYComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DISPLAYComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DISPLAYComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
