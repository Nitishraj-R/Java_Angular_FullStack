import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablerenderComponent } from './tablerender.component';

describe('TablerenderComponent', () => {
  let component: TablerenderComponent;
  let fixture: ComponentFixture<TablerenderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablerenderComponent]
    });
    fixture = TestBed.createComponent(TablerenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
