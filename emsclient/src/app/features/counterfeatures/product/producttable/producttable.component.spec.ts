import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducttableComponent } from './producttable.component';

describe('ProducttableComponent', () => {
  let component: ProducttableComponent;
  let fixture: ComponentFixture<ProducttableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProducttableComponent]
    });
    fixture = TestBed.createComponent(ProducttableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
