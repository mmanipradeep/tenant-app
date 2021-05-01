import { Component, OnInit } from '@angular/core';
import { Tenant } from '../tenant';
import { ActivatedRoute } from '@angular/router';
import { TenantService } from '../tenant.service';

import { Location } from '@angular/common';



@Component({
  selector: 'app-tenant-details',
  templateUrl: './tenant-details.component.html',
  styleUrls: ['./tenant-details.component.css']
})
export class TenantDetailsComponent implements OnInit {

    id: number
    tenant: Tenant
    constructor(private _location: Location,
                private route: ActivatedRoute,
                private tenantService: TenantService) { }

    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];

      this.tenant = new Tenant();
      this.tenantService.getTenantById(this.id).subscribe( data => {
        this.tenant = data;
      });
    }
 goBack() {

     this._location.back();

     console.log( 'goBack()...' );
   }
}
