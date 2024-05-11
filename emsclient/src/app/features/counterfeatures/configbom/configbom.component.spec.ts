import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigbomComponent } from './configbom.component';

describe('ConfigbomComponent', () => {
  let component: ConfigbomComponent;
  let fixture: ComponentFixture<ConfigbomComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConfigbomComponent]
    });
    fixture = TestBed.createComponent(ConfigbomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
