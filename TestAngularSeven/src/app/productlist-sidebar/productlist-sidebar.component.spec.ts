import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductlistSidebarComponent } from './productlist-sidebar.component';

describe('ProductlistSidebarComponent', () => {
  let component: ProductlistSidebarComponent;
  let fixture: ComponentFixture<ProductlistSidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductlistSidebarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductlistSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
