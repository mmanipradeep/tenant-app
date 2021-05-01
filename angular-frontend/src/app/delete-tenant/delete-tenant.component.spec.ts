import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteTenantComponent } from './delete-tenant.component';

describe('DeleteTenantComponent', () => {
  let component: DeleteTenantComponent;
  let fixture: ComponentFixture<DeleteTenantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteTenantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteTenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
