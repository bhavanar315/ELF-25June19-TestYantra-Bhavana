import React, { Component } from 'react'

export default class Otherinfo extends Component {
    constructor(props){
        super(props)
        this.state={
            otherinfo:[
                
            ]


        }
    }
    render() {
        return (
            <div>
                <h4 className="text-center">EMPLOYEE OTHER INFORMATION</h4>
                <div class="row">
							<div class="col">
								<label for="Id">ID</label> <input type="number"
									class="form-control" name="otherInfoBean.id" id="otherId"
									readonly="readonly"/>
							</div>
							<div class="col">
								<label for="exampleInputemergenum">Emergency Contact
									Number</label> <input type="tel" class="form-control"
									name="otherInfoBean.emergencyContactNumber"
									placeholder="Please Enter Emergency Contact Number"/>
							</div>
							<div class="col">
								<label for="exampleInputmotname">Mother Name</label> <input
									type="text" class="form-control" id="mothername" name="otherInfoBean.motherName"
									placeholder="Please Enter Mother Name"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="exampleInputPan">Pan Number</label> <input
									type="text" class="form-control" name="otherInfoBean.pan"
									placeholder="Please Enter Pan Number"/>
							</div>
							<div class="col">
								<label for="exampleInputemergeName">Emergency Contact
									Name</label> <input type="text" class="form-control"
									name="otherInfoBean.emergencyContactName"
									placeholder="Please Enter Emergency Contact Name"/>
							</div>
							<div class="col">
								<label for="exampleInputspouse">Spouse Name</label> <input
									type="text" class="form-control" name="otherInfoBean.spouseName"
									placeholder="Please Enter Spouse Name"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="inputStatus">Marrital Status</label> <select
									name="otherInfoBean.inputStatus" class="form-control">
									<option selected>Married</option>
									<option value="1">Married</option>
									<option value="0">Unmarried</option>

								</select>
							</div>
							<div class="col">
								<label for="inputnationality">Nationality</label> <select
									name="otherInfoBean.inputnationality" class="form-control">
									<option selected>---Select One---</option>
									<option value="indian">Indian</option>
									<option value="other">Other</option>
								</select>
							</div>
							<div class="col">
								<label for="exampleInputpassport">Passport Number</label> <input
									type="text" class="form-control" name="otherInfoBean.passport"
									placeholder="Please Enter Passport Number"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="inputbloodgrp">Blood Group</label> <select
									name="otherInfoBean.inputbloodgrp" class="form-control">
									<option selected>---Select One---</option>
									<option value="AB+">AB+</option>
									<option value="AB-">AB-</option>
									<option value="A+">A+</option>
									<option value="A-">A-</option>
									<option value="o+">o+</option>
									<option value="o-">o-</option>
								</select>
							</div>
							<div class="col">
								<label for="inputreligion">Religion</label> <select
									name="otherInfoBean.inputreligion" class="form-control">
									<option selected>---Select One---</option>
									<option value="hindu">Hindu</option>
									<option value="christian">Christian</option>
									<option value="muslim">Muslim</option>
								</select>
							</div>
							<div class="col">
								<label for="exampleInputaadhar">Aadhar Number</label> <input
									type="text" class="form-control" name="otherInfoBean.adharnumber"
									placeholder="Please Enter Aadhar Number"/>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								<label for="inputphysicallych">Physically Challenged</label> <select
									name="otherInfoBean.physicallyChallenged" class="form-control">
									<option selected>---Select One---</option>
									<option value="yes">Yes</option>
									<option value="no">No</option>
								</select>
							</div>
							<div class="col-4">
								<label for="exampleInputfather">Father Number</label> <input
									type="text" class="form-control" name="otherInfoBean.fathername"
									placeholder="Please Enter Father Number"/>
							</div>
                            </div>
            </div>
        )
    }
}
