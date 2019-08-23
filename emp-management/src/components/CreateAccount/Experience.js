import React, { Component } from 'react'

export default class Experience extends Component {
    render() {
        return (
            <div>
                <h4 class="text-center">EMPLOYEE EXPERIENCE DETAILS</h4>
            <div class="row">
                    <div class="col">
                            <label for="name">Company Name</label>
                            <input type="text" id="companyname" name="companyname" placeholder="Enter Company Name"
                             class="form-control"/>
                    </div>
                    <div class="col">
                            <label for="designation">Designation</label>
                            <input type="text" id="designation" name="designation"
                             placeholder="Enter Designation" class="form-control"/>
                    </div>
                </div>
                    <div class="row">
                        <div class="col">
                        <label for="Joining Date">JOINING DATE</label>
                        <input type="date" class="form-control" id="dateofjoin" 
                        placeholder="Enter Joining date"/>
                    </div>
    
                    <div class="col">
                            <label for="Leaving Date">Leaving Date</label>
                            <input type="date" class="form-control" id="dateofleave" 
                            placeholder="Enter Leaving date"/>
                    </div>
                </div>               
            </div>
        )
    }
}

