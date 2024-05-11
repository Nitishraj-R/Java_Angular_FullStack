import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierhomeComponent } from './supplierhome.component';

describe('SupplierhomeComponent', () => {
  let component: SupplierhomeComponent;
  let fixture: ComponentFixture<SupplierhomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SupplierhomeComponent]
    });
    fixture = TestBed.createComponent(SupplierhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
