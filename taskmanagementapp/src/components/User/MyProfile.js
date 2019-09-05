import React, { Component } from 'react'
import {Modal, Button} from 'react-bootstrap'
import Navbarwithoutsearch from '../NavaBar/Navbarwithoutsearch';
import Axios from 'axios';

export default class MyProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            beans: [],
            id: '',
            show: false
        }
        
    }

     componentDidMount(){
         Axios.get('http://localhost:8080/getUsers').then((response)=>{
            console.log('Response Object',response.data);
            if(response.data.message === "success"){
              localStorage.setItem("beans",JSON.stringify(response.data.beans));
                     
            }
      }).catch((error)=>{
             console.log('Error',error);
         })
     }

    
    editUser(bean) {

        this.setState({
            firstName: bean.firstName,
            lastName: bean.lastName,
            email: bean.email,
            phoneNo: bean.phoneNo,
            show: !this.state.show,
            userId: bean.userId
        })
    }
    handleClose() {
        this.setState({ show: !this.state.show })
    }
    updateUserData() {
        const beans = this.state;
        const userData = beans;
        console.log('AccountData', userData);
        Axios.put('http://localhost:8080/updateUser' ,userData).then((response) => {
            console.log('Updated Successfully');
            this.handleClose();

        }).catch((error) => {
            console.log('Error', error);
        })
    }
    render() {
        return (
            <div>
                <Navbarwithoutsearch/>
                <div>
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone number</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.beans.map((bean) => {
                                    return <tr key={bean.userId}>
                                        <td>{bean.firstName}</td>
                                        <td>{bean.email}</td>
                                        <td>{bean.phoneNo}</td>
                                       
                                        <td>
                                            <button onClick={this.deleteUser.bind(this, bean)} className='btn btn-danger'>Delete</button>
                                        </td>
                                        <td>
                                            <button onClick={this.editUser.bind(this, bean)} className='btn btn-success'>Edit</button>
                                        </td>
                                    </tr>
                                })

                            }
                        </tbody>
                    </table>
                    <div>

                        <Modal show={this.state.show} onHide={this.handleClose.bind(this)}>
                            <Modal.Header closeButton>
                                <Modal.Title>Modal heading</Modal.Title>
                            </Modal.Header>
                            <Modal.Body>
                                <div className="row">
                                    <div className="col">
                                        <input type="text" onChange={(event) => { this.setState({ firstName: event.target.value }) }}
                                            value={this.state.firstName} className="form-control" readOnly/>
                                    </div>
                                    <div className="col">
                                        <input type="text" onChange={(event) => { this.setState({ lastName: event.target.value }) }}
                                            value={this.state.lastName} className="form-control" readOnly/>
                                    </div>
                                    <div className="col">
                                        <input type="text" onChange={(event) => { this.setState({ email: event.target.value }) }}
                                            value={this.state.email} className="form-control" readOnly/>
                                    </div>
                                </div>
                                <br />
                                <div className="row">
                                    <div className="col">
                                        <input type="number" onChange={(event) => { this.setState({ phoneNo: event.target.value }) }}
                                            value={this.state.phoneNo} className="form-control" readOnly/>
                                    </div>
                                    
                                    
                                </div>

                            </Modal.Body>
                            <Modal.Footer>
                                <Button variant="secondary" onClick={this.handleClose.bind(this)}>
                                    Close
</Button>
                                <Button variant="primary" onClick={this.updateUserData.bind(this)}>
                                    Save Changes
</Button>
                            </Modal.Footer>
                        </Modal>
                    </div>
                </div>
            </div>
        )
    }
}