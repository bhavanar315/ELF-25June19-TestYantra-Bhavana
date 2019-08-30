import React, { Component } from 'react'
import Axios from 'axios';
import Navbarwithoutsearch from '../NavaBar/Navbarwithoutsearch';

export default class CreateTask extends Component {


  postData(e) {
    e.preventDefault();
    Axios.get('http://localhost:8080/createTask', null
    ).then((response) => {
       
        console.log('Response Object', response.data);
        if (response.data.message === "success") {
            console.log(this.props);
            this.props.history.push('/TaskHome');
            localStorage.setItem('logoutmsg', response.data.description);
        }

    }).catch((error) => {
        console.log('Error', error);
    })
}
  render() {
    return (
      <div>
        <Navbarwithoutsearch/>
       creat Task
      </div>
    )
  }
}
