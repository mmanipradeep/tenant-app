import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TenantListComponent } from './tenant-list/tenant-list.component';
import { CreateTenantComponent } from './create-tenant/create-tenant.component';
import { TenantDetailsComponent } from './tenant-details/tenant-details.component';
import { UpdateTenantComponent } from './update-tenant/update-tenant.component';
const routes: Routes = [
    {path: 'tenants',component : TenantListComponent},
    {path: 'create-tenant', component: CreateTenantComponent},
    {path: 'tenant-details/:id', component: TenantDetailsComponent},
    {path: 'update-tenant/:id', component: UpdateTenantComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
