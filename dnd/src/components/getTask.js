import React, { Component } from 'react'
import Axios from 'axios';




const x = {
    "draggableId": 2,
    "type": "DEFAULT",
    "source": {"index": 1, "droppableId": 1},
    "reason": "DROP",
    "mode": "FLUID",
    "destination": {"droppableId": 2, "index": 0},
    "combine": null
}





export default class getTask extends Component {

    constructor(props) {
        super(props)
        this.state = {
            //items:initialData,
            todo: [],
            complete: [],
            blocked: [],
            onProgress: [],
            userEmail: JSON.parse(window.localStorage.getItem('beans')),

        }
    }
    componentDidMount() {
        this.getTask();

    }

    
    getTask() {

        Axios.get('http://localhost:8080/tome?email=' + this.state.userEmail.email)
            .then((response) => {
                console.log(response.data.message)
                if (response.data.statusCode === 201) {
                    //setstat
                    
                    this.setState({
                        todo: response.data.taskBean.filter(item => item.status === 'todo')
                        

                    })
                    
                    this.setState({
                        complete: response.data.taskBean.filter(item => item.status === 'complete')
                    })
                    this.setState({
                        blocked: response.data.taskBean.filter(item => item.status === 'blocked')
                    })
                    this.setState({
                        onProgress: response.data.taskBean.filter(item => item.status === 'onProgress')
                    })
                    console.log('bean if', this.state.todo);
                }
                localStorage.setItem("taskBeans", JSON.stringify(response.data.taskBean));

            }).catch((error) => {
                console.log(error)
            })

        }
   
    render() {
        return (
            <div>

            </div>
        )
    }
}
