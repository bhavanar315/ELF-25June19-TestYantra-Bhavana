import React, { Component } from 'react'
import './CompletedTask.css'
import Axios from 'axios';
import SearchNavabar from '../NavaBar/SearchNavabar';


export default class CompletedTask extends Component {
    constructor(props) {
        super(props)
        this.state = {
            doneTask: []
        }
    }
    componentDidMount() {
        console.log('componentDidMount');
        Axios.get('http://localhost:8080/taskmanagement/getCompletedtask').then((response) => {
            console.log('Response Object', response);
            if (response.data.message === "Success") {
                this.setState({
                    doneTask: response.data.taskBean.filter(item => item.subject === 'Done')

                })

                console.log('Response Status true', this.state.doneTask);



                //localStorage.setItem("beans",JSON.stringify(response.data.beans));

            }
        }).catch((error) => {
            console.log('Error', error);
        })


    }

    render() {
        return (
            <div>
                <SearchNavabar />
                <div>
                    {this.state.doneTask.map(item => {
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
