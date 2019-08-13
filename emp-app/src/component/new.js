import React, { Component } from 'react'
import Axios from 'axios';

export class CreateAccount extends Component {
    constructor(props){
        super(props);
        this.state={
            name:'',
            email:'',
            phoneno:'',
            password:'',
            errors: {}
        }
        //this.handleChange = this.handleChange.bind(this);
        this.postData=this.postData.bind(this);
    }
    postData(event){
        event.preventDefault();
        console.log("post data", this.state);
        if(this.validateForm()){let accountData=this.state;
            Axios.post('https://emp-app-405f8.firebaseio.com/accounts.json', accountData)
            .then((response)=>{
                console.log("response", response)
                this.setState({
                    name:'',
                    email:'',
                    phoneno:'',
                    password:''
                })
    
            }).catch((error)=>{
                console.log("Error", error)
    
            })
        }
        
        alert("Form submitted");

    }

    validateForm() {

        let fields = this.state;
        let errors = {};
        let formIsValid = true;
  
        if (!fields["username"]) {
          formIsValid = false;
          errors["username"] = "*Please enter your username.";
        }
  
        if (typeof fields["username"] !== "undefined") {
          if (!fields["username"].match(/^[a-zA-Z ]*$/)) {
            formIsValid = false;
            errors["username"] = "*Please enter alphabet characters only.";
          }
        }
  
        if (!fields["emailid"]) {
          formIsValid = false;
          errors["emailid"] = "*Please enter your email-ID.";
        }
  
        if (typeof fields["emailid"] !== "undefined") {
          //regular expression for email validation
          var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
          if (!pattern.test(fields["emailid"])) {
            formIsValid = false;
            errors["emailid"] = "*Please enter valid email-ID.";
          }
        }
  
        if (!fields["mobileno"]) {
          formIsValid = false;
          errors["mobileno"] = "*Please enter your mobile no.";
        }
  
        if (typeof fields["mobileno"] !== "undefined") {
          if (!fields["mobileno"].match(/^[0-9]{10}$/)) {
            formIsValid = false;
            errors["mobileno"] = "*Please enter valid mobile no.";
          }
        }
  
        if (!fields["password"]) {
          formIsValid = false;
          errors["password"] = "*Please enter your password.";
        }
  
        if (typeof fields["password"] !== "undefined") {
          if (!fields["password"].match(/^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/)) {
            formIsValid = false;
            errors["password"] = "*Please enter secure and strong password.";
          }
        }
  
        this.setState({
          errors: errors
        });
        return formIsValid;
  
  
      }
    // handleOnChange(){
    //    let email = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");
    //    if(email.test){
    //      console.log("valid email");

    //    }else{
    //        console.log("invalid email");
    //    }

    // }
    render() {
        return (
            <div>
                <form style={{marginTop:50, marginLeft:200,marginRight:200}} onSubmit={this.postData}>
                    <div className="row">
                        <div className="col">
                            <input type="text" onChange={(event)=>{this.setState({name:event.target.value})}}
                            value={this.state.name}className="form-control" placeholder="Name"/>
                            </div>
                            <div className="col">
                                <input type="text" onChange={(event)=>{this.setState({email:event.target.value})}} 
                                value={this.state.email}className="form-control" placeholder="Email" />
                              </div>
                            </div>
                        <div className="row">
                        <div className="col">
                            <input type="number" onChange={(event)=>{this.setState({phoneno:event.target.value})}}
                            value={this.state.phoneno}className="form-control" placeholder="phone" required/>
                            </div>
                            <div className="col">
                                <input type="password" onChange={(event)=>{
                                    this.setState({
                                        password:event.target.value
                                    })
                                }} 
                                value={this.state.password} className="form-control" placeholder="password" required/>
                            </div>
                                                                                     
                            </div>
                            
                                <button type="submit" style={{marginLeft:500, marginTop:20}}
                                className="btn btn-success">Create</button>
                             
                         </form>
                    </div>
                    )
                }
            }
            
export default CreateAccount
