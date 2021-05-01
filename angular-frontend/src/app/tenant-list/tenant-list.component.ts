import { Component, OnInit } from '@angular/core';
import { Tenant } from '../tenant';
import { TenantService } from '../tenant.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-tenant-list',
  templateUrl: './tenant-list.component.html',
  styleUrls: ['./tenant-list.component.css']
})
export class TenantListComponent implements OnInit {

 tenants: Tenant[];
  constructor(private tenantService: TenantService,
                  private router: Router) { }

  ngOnInit(): void {
     this.getTenants();
  }

  private getTenants(){
      this.tenantService.getTenantsList().subscribe(data => {
        this.tenants = data;
      });
    }

  tenantDetails(id: number){
      this.router.navigate(['tenant-details', id]);
    }

    updateTenant(id: number){
      this.router.navigate(['update-tenant', id]);
    }

    deleteTenant(id: number){
      this.tenantService.deleteTenant(id).subscribe( data => {
        console.log(data);
        this.getTenants();
      })
    }

}
