import React, { Component } from 'react'
import Axios from 'axios';
import SearchNavabar from '../NavaBar/SearchNavabar';

export default class Byme extends Component {
    constructor(props){
        super(props)
        this.state={
            Byme:[],
            email:'ranji.pendli155@gmail.com'
        }
    }

    componentDidMount(){
        console.log('componentDidMount');
        Axios.get('http://localhost:8080/taskmanagement/byme?email='+this.state.email
           
        ).then((response)=>{
            console.log('Response taskBean',response);
            if(response.data.message ==="Success"){
              localStorage.setItem("taskBeans",JSON.stringify(response.data.taskBean));
              this.setState({
                Byme: response.data.taskBean

            })

               

                     
            }
      }).catch((error)=>{
             console.log('Error',error);
         })
     

    }
    render() {
        return (
            <div>
                <SearchNavabar/>
                <div>
                    {this.state.Byme.map(item => {
                        return (
                            <div id="drag3" className="sticky" >
                                <p class="danger">{item.description} </p>
                            </div>                            
                    )
                    })}
                </div>

            </div>
        )
    }
}
