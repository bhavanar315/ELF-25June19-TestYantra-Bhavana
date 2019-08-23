import React, { Component } from 'react'
import Addressinfo from './Addressinfo';
import Info from './info';
import Axios from 'axios';
import Otherinfo from './Otherinfo';
import Education from './Education';
import Experience from './Experience';

export default class Base extends Component {
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
        let accountData=this.state;
        Axios.post('http://localhost:9090/emp-springrest/employeeResponse/createEmployee',null, 
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

    render() {
        return (
            <div>
                <form>
                    <div>
                     <Info></Info>
                     <Otherinfo></Otherinfo>
                     <Addressinfo></Addressinfo>
                     <Education></Education>
                     <Experience></Experience>
                     </div>
                    
                    <button type="submit" >Create</button>
                </form>
                
            </div>
        )
    }
}
