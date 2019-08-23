import React, { Component } from 'react'

export default class Education extends Component {
    render() {
        return (
            <div>
               <h4 class="text-center">EMPLOYEE EDUCATION INFORMATION</h4>
    
    <div class="row">
            <div class="col">
                    <label for="Education">Education Type</label>
                    <input type="text" id="educationtype" placeholder="Enter Education Type" class="form-control" autofocus/>
            </div>
            <div class="col">
                    <label for="degree" class="col-sm-3 control-label">Degree Type </label>
                    <input type="text" id="degree" placeholder="Enter Degree Type" class="form-control" name= "degree"/>
            </div>
        </div>    
        <div class="row">
                <div class="col">
                        <label for="branch" class="col-sm-3 control-label">Branch</label>
                        <input type="branch" id="branch" placeholder="Enter Branch" class="form-control"/>
                </div>
                <div class="col">
                        <label for="college" class="col-sm-3 control-label">College Name</label>
                        <input type="text" id="collge" placeholder="Enter College Name" class="form-control"/>
                </div>
            </div>    
            <div class="row">
                    <div class="col">
                            <label for="yop" >Year of Passing</label>
                            
                                <input type="date" id="yop" class="form-control"/>
                            
                    </div>
                    <div class="col">
                            <label for="university" class="col-sm-3 control-label">University</label>
                           
                                <input type="text" id="university" placeholder="Enter University" class="form-control"/>
                            
                    </div>
                </div>
                <div class="row">
                        <div class="col">
                               
                        <label for="percentage" class="col-sm-3 control-label">Percentage </label>
                                        
                     <input type="number" id="percentage" placeholder="Enter Percentage" class="form-control"/>                            
                                   
                        </div>
                        <div class="col">
                                <label for="location" class="col-sm-3 control-label">Location</label>
                                       
                                <input type="text" id="height" placeholder="Enter College Location" class="form-control"/>
                        </div>
                    </div>   
                    
            </div>
        )
    }
}
