import React, { Component } from 'react'
import Axios from 'axios';

export class CreateAccount extends Component {
    constructor(props){
        super(props);
        this.state={
            name:'',
            email:'',
            phoneno:'',
            password:''
        }
        this.postData=this.postData.bind(this);
    }
    postData(event){
        event.preventDefault();
        console.log("post data", this.state);
        let accountData=this.state;
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
    
    render() {
        return (
            <div>
                <form style={{marginTop:50, marginLeft:200,marginRight:200}} onSubmit={this.postData}>
                    <div className="row">
                        <div className="col">
                            <input type="text" onChange={(event)=>{this.setState({name:event.target.value})}}
                            value={this.state.name}className="form-control" placeholder="Name" required/>
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
