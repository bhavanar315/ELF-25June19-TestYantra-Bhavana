import React, { Component } from 'react'


export class Addressinfo extends Component {
    constructor(props){
        super(props);
        
        //this.postData=this.postData.bind(this);
    }
   

    render() {
        return (
            <div>
               <h4 className="text-center">EMPLOYEE PERMANENT ADDRESS </h4>
                            <div class="row">
      <div class="col">
        <label for="Employee Id">ID</label>
        <input type="number" class="form-control" id="id" placeholder="Enter ID"/>
      </div>
      <div class="col">
        <label for="city">City</label>
        <input type="text" class="form-control" id="city" placeholder="Enter City"/>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <label for="address type">Address Type</label>
        <input type="text" class="form-control" id="addresstype" placeholder="Enter Address Type"/>
      </div>
      <div class="col">
        <label for="state">State</label>
        <input type="text" class="form-control" id="state" placeholder="Enter State"/>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <label for="address1">Address1 </label>
        <input type="text" class="form-control" id="address1" placeholder="Enter Address 1"/>
      </div>
      <div class="col">
        <label for="country">Country </label>
        <input type="text" class="form-control" id="country" placeholder="Enter Country"/>
      </div>
    </div>
    
    <div class="row">
      <div class="col">
       <label for="address2">Address 2 </label>
        <input type="text" class="form-control" id="address2" placeholder="Enter Address 2"/>
      </div>
      <div class="col">
        <label for="pin">Pincode</label>
        <input type="number" class="form-control" id="pincode" placeholder="Enter Pincode"/>
      </div>
    </div>
   
    <div class="row">

      <div class="col-6">
        <label for="landmark">Landmark</label>
        <input type="text" class="form-control" id="landmark" placeholder="Enter Landmark"/>
      </div>
      {/* <div class="col-2">
        <br>
        <!-- <button type="submit" class="form-control btn btn-outline-success" > Submit</button> -->
        <input type="button" data-toggle="collapse"
        class="form-control btn btn-outline-success"
        data-target="#empTempararyAddressInfo" value="Temparary Address" />
        
      </div>
       */}
    </div>
    
    <hr/>
    <div id="empTempararyAddressInfo" class="collapse"></div>
    <p >EMPLOYEE TEMPARARY ADDRESS </p>
                              <div class="row">
        <div class="col">
          <label for="Employee Id">ID</label>
          <input type="number" class="form-control" id="id" placeholder="Enter ID"/>
        </div>
        <div class="col">
          <label for="city">City</label>
          <input type="text" class="form-control" id="city" placeholder="Enter City"/>
        </div>
      </div>
      <div class="row">
        <div class="col">
          <label for="address type">Address Type</label>
          <input type="text" class="form-control" id="addresstype" placeholder="Enter Address Type"/>
        </div>
        <div class="col">
          <label for="state">State</label>
          <input type="text" class="form-control" id="state" placeholder="Enter State"/>
        </div>
      </div>
      <div class="row">
        <div class="col">
          <label for="address1">Address1 </label>
          <input type="text" class="form-control" id="address1" placeholder="Enter Address 1"/>
        </div>
        <div class="col">
          <label for="country">Country </label>
          <input type="text" class="form-control" id="country" placeholder="Enter Country"/>
        </div>
      </div>
      
      <div class="row">
        <div class="col">
         <label for="address2">Address 2 </label>
          <input type="text" class="form-control" id="address2" placeholder="Enter Address 2"/>
        </div>
        <div class="col">
          <label for="pin">Pincode</label>
          <input type="number" class="form-control" id="pincode" placeholder="Enter Pincode"/>
        </div>
      </div>
     
      <div class="row">
  
        <div class="col-6">
          <label for="landmark">Landmark</label>
          <input type="text" class="form-control" id="landmark" placeholder="Enter Landmark"/>
        </div>
			</div>
            </div>
            
        )
    }
}

export default Addressinfo
