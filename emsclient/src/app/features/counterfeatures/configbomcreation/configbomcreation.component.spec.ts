import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigbomcreationComponent } from './configbomcreation.component';

describe('ConfigbomcreationComponent', () => {
  let component: ConfigbomcreationComponent;
  let fixture: ComponentFixture<ConfigbomcreationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConfigbomcreationComponent]
    });
    fixture = TestBed.createComponent(ConfigbomcreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
