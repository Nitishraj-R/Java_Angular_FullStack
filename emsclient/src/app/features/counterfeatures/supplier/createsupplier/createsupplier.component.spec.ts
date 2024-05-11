import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatesupplierComponent } from './createsupplier.component';

describe('CreatesupplierComponent', () => {
  let component: CreatesupplierComponent;
  let fixture: ComponentFixture<CreatesupplierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatesupplierComponent]
    });
    fixture = TestBed.createComponent(CreatesupplierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
