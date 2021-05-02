import React, { Component } from 'react'
import TenantService from '../services/TenantService';

class UpdateTenantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            emailId: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.updateTenant = this.updateTenant.bind(this);
    }

    componentDidMount(){
        TenantService.getTenantById(this.state.id).then( (res) =>{
            let tenant = res.data;
            this.setState({firstName: tenant.firstName,
                lastName: tenant.lastName,
                emailId : tenant.emailId
            });
        });
    }

    updateTenant = (e) => {
        e.preventDefault();
        let tenant = {firstName: this.state.firstName, lastName: this.state.lastName, emailId: this.state.emailId};
        console.log('tenant => ' + JSON.stringify(tenant));
        console.log('id => ' + JSON.stringify(this.state.id));
        TenantService.updateTenant(tenant, this.state.id).then( res => {
            this.props.history.push('/tenants');
        });
    }
    
    changeFirstNameHandler= (event) => {
        this.setState({tenantName: event.target.value});
    }

    changeLastNameHandler= (event) => {
        this.setState({lastName: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({emailId: event.target.value});
    }

    cancel(){
        this.props.history.push('/tenants');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Employee</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> First Name: </label>
                                            <input placeholder="First Name" name="firstName" className="form-control" 
                                                value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Last Name: </label>
                                            <input placeholder="Last Name" name="lastName" className="form-control" 
                                                value={this.state.lastName} onChange={this.changeLastNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email Id: </label>
                                            <input placeholder="Email Address" name="emailId" className="form-control" 
                                                value={this.state.emailId} onChange={this.changeEmailHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateEmployee}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateTenantComponent
