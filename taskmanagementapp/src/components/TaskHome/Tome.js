import React, { Component } from 'react'
import Axios from 'axios';

export default class Tome extends Component {
    constructor(props){
        super(props)
        this.state={
            email:'ranji.pendli155@gmail.com'
        }
    }

    componentDidMount(){
        console.log('componentDidMount');
        Axios.get('http://localhost:8084/tome?email='+this.state.email
           
        ).then((response)=>{
            console.log('Response Object',response);
            if(response.data.message === "success"){
              localStorage.setItem("beans",JSON.stringify(response.data.beans));
                     
            }
      }).catch((error)=>{
             console.log('Error',error);
         })
     

    }
    render() {
        return (
            <div>
                 To Me
            </div>
        )
    }
}
