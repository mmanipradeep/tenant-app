import React, { Component } from 'react'
import TenantService from '../services/TenantService';

class ListTenantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                tenants: []
        }
        this.addTenant = this.addTenant.bind(this);
        this.editTenant = this.editTenant.bind(this);
        this.deleteTenant = this.deleteTenant.bind(this);
    }

    deleteTenant(id){
        TenantService.deleteTenant(id).then( res => {
            this.setState({tenants: this.state.tenants.filter(tenant => tenant.id !== id)});
        });
    }
    viewTenant(id){
        this.props.history.push(`/tenant-details/${id}`);
    }
    editTenant(id){
        this.props.history.push(`/add-tenant/${id}`);
    }

    componentDidMount(){
        TenantService.getTenants().then((res) => {
            this.setState({ tenants: res.data});
        });
    }

    addTenant(){
        this.props.history.push('/add-tenant/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Tenants List</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addTenant}> Add Tenant</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Tenant First Name</th>
                                    <th> Tenant Last Name</th>
                                    <th> Tenant Email Id</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.tenants.map(
                                        tenant => 
                                        <tr key = {tenant.id}>
                                             <td> {tenant.tenantName} </td>   
                                             <td> {tenant.lastName}</td>
                                             <td> {tenant.emailId}</td>
                                             <td>
                                                 <button onClick={ () => this.editTenant(tenant.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTenant(tenant.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTenant(tenant.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListTenantComponent
