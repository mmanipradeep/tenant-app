import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs' ;
import { Tenant} from './tenant';

@Injectable({
  providedIn: 'root'
})
export class TenantService {



private baseURL = "http://localhost:8080/api/v1/tenants";
constructor(private httpClient : HttpClient) { }

 getTenantsList(): Observable<Tenant[]>{
    return this.httpClient.get<Tenant[]>(`${this.baseURL}`);
  }


  createTenant(tenant: Tenant): Observable<Object>{
    const headers = { 'content-type': 'application/json'}
    const body=JSON.stringify(tenant);
    console.log(body)
    return this.httpClient.post(`${this.baseURL}`, body,{'headers':headers});
  }

  getTenantById(id: number): Observable<Tenant>{
    return this.httpClient.get<Tenant>(`${this.baseURL}/tenant/${id}`);
  }

  updateTenant(id: number, tenant: Tenant): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, tenant);
  }

  deleteTenant(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
