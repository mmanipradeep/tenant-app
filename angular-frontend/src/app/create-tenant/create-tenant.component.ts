import { Component, OnInit } from '@angular/core';
import { Tenant } from '../tenant';
import { TenantService } from '../tenant.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
@Component({
  selector: 'app-create-tenant',
  templateUrl: './create-tenant.component.html',
  styleUrls: ['./create-tenant.component.css']
})

export class CreateTenantComponent implements OnInit {
  submitted = false;
  tenant: Tenant = new Tenant();
  form: FormGroup;
  constructor(private _location: Location,private tenantService: TenantService,
    private router: Router,public formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
    tenantName: [null, Validators.required,!Validators.pattern('^[a-zA-Z0-9!@#$%^&*()]+$')],
    advanceAmount: [null, Validators.required],
    monthlyRent : [null,Validators.required],
    onboardDate : [null,Validators.required]});
  }

  get registerFormControl() {
    return this.form.controls;
  }

  saveTenant(){
    this.tenantService.createTenant(this.tenant).subscribe( data =>{
      console.log(data);
      this.goToTenantList();
    },
    error => console.log(error));
  }

  goToTenantList(){
    this.router.navigate(['/tenants']);
  }


  get getControl(){
    return this.form.controls;
  }
  onSubmit(){
    this.submitted = true;
    console.log(this.form);
  }

   goBack() {
  this._location.back();
  console.log( 'goBack()...' );
     }

}
