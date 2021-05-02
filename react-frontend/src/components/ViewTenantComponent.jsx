import React, { Component } from 'react'
import TenantService from '../services/TenantService'

class ViewTenantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            tenant: {}
        }
    }

    componentDidMount(){
        TenantService.getTenantById(this.state.id).then( res => {
            this.setState({tenant: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Tenant Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Employee First Name: </label>
                            <div> { this.state.tenant.tenantName }</div>
                        </div>
                        <div className = "row">
                            <label> Employee Last Name: </label>
                            <div> { this.state.tenant.lastName }</div>
                        </div>
                        <div className = "row">
                            <label> Employee Email ID: </label>
                            <div> { this.state.tenant.emailId }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewTenantComponent
