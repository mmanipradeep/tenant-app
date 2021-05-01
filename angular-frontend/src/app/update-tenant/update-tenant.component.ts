import { Component, OnInit } from '@angular/core';
import { TenantService } from '../tenant.service';
import { Tenant } from '../tenant';
import { ActivatedRoute, Router } from '@angular/router';

import { Location } from '@angular/common';
@Component({
  selector: 'app-update-tenant',
  templateUrl: './update-tenant.component.html',
  styleUrls: ['./update-tenant.component.css']
})
export class UpdateTenantComponent implements OnInit {

   id: number;
    tenant: Tenant = new Tenant();
    constructor(private _location: Location,private tenantService: TenantService,
      private route: ActivatedRoute,
      private router: Router) { }

    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];

      this.tenantService.getTenantById(this.id).subscribe(data => {
        this.tenant = data;
      }, error => console.log(error));
    }

    onSubmit(){
      this.tenantService.updateTenant(this.id, this.tenant).subscribe( data =>{
        this.goToTenantList();
      }
      , error => console.log(error));
    }

    goToTenantList(){
      this.router.navigate(['/tenants']);
    }

     goBack() {

         this._location.back();

         console.log( 'goBack()...' );
       }
}
