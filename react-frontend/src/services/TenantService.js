import axios from 'axios';

const TENANT_API_BASE_URL = "http://localhost:8080/api/v1/tenants";

class TenantService {

    getTenants(){
        return axios.get(TENANT_API_BASE_URL);
    }

    createTenant(tenant){
        return axios.post(TENANT_API_BASE_URL, tenant);
    }

    getTenantById(tenantId){
        return axios.get(TENANT_API_BASE_URL + '/' + tenantId);
    }

    updateTenant(tenant, tenantId){
        return axios.put(TENANT_API_BASE_URL + '/' + tenantId, tenant);
    }

    deleteTenant(tenantId){
        return axios.delete(TENANT_API_BASE_URL + '/' + tenantId);
    }
}

export default new TenantService()