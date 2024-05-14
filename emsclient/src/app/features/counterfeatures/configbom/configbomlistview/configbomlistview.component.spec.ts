import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigbomlistviewComponent } from './configbomlistview.component';

describe('ConfigbomlistviewComponent', () => {
  let component: ConfigbomlistviewComponent;
  let fixture: ComponentFixture<ConfigbomlistviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConfigbomlistviewComponent]
    });
    fixture = TestBed.createComponent(ConfigbomlistviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
