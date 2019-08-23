import React, { Component } from 'react'
import Axios from 'axios'



export class Login extends Component {
    constructor(props){
        super(props);
        this.state={
            id:'',                 
            password:''
        }
        this.postData=this.postData.bind(this);
    }
    postData(event){
        event.preventDefault();
        console.log("post data", this.state);
        //let accountData=this.state;
        Axios.post('http://localhost:8080/emp-springrest/login/login',null, 
        {
            params:
            {
                id:this.state.id,
                password:this.state.password
            }
        })
        .then((response)=>{
            console.log("response", response)
          
            console.log("response.data.message", response.data.message)
          
            if(response.data.message==="Sucessfully"){
                
             this.props.history.push('/home')
             localStorage.setItem("beans", JSON.stringify(response.data.beans[0]))
            //console.log("object", localStorage.setItem("bean", JSON.stringify(response.data.beans[0])));
             
             console.log(this.props.history)

             }else{
                 this.props.history.push('/')

             }
       
       
        }).catch((error)=>{  
            console.log("Error", error)

        })
    }
 render(){
     return(
        <div>

        <form style={{marginTop:50, marginLeft:200,marginRight:200}} onSubmit={this.postData}>
          <label>
            ID:
            <input type="number" name="id" onChange={(event)=>{this.setState({id:event.target.value})}}
                            value={this.state.id} />
          </label>
          <label>
            Password:
            <input type="password" name="password" onChange={(event)=>{this.setState({password:event.target.value})}}
                            value={this.state.password}/>
          </label>
          <input type="submit" value="Submit" />
        </form>
        </div>
       
    

     )
     
 }

}
export default Login
