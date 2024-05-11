import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofassetsComponent } from './listofassets.component';

describe('ListofassetsComponent', () => {
  let component: ListofassetsComponent;
  let fixture: ComponentFixture<ListofassetsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListofassetsComponent]
    });
    fixture = TestBed.createComponent(ListofassetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
