import React, { Component } from 'react'
import { Modal, Button, Card } from 'react-bootstrap'
import Axios from 'axios';
import NavbarforAll from '../NavaBar/NavbarforAll';

export default class MyProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            beans: [],
            Id: '',
            show: false,
        }

        this.state.beans = JSON.parse(localStorage.getItem("beans"));
    }



    editUser(bean) {

        this.setState({
            empName: bean.empName,
            email: bean.email,
            designation: bean.designation,
            show: !this.state.show,
            empId: bean.empId
        })
    }
    handleClose() {
        this.setState({ show: !this.state.show })
    }
    updateUserData() {
        const beans = this.state;
        const userData = beans;
        console.log('AccountData', userData);
        Axios.put('http://localhost:8080/taskmanagement/updateUser', userData).then((response) => {
            console.log('Updated Successfully');
            this.handleClose();

        }).catch((error) => {
            console.log('Error', error);
        })
    }
    render() {
        return (
            <div>
                <NavbarforAll />
                <div>
                   
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Designation</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.beans.map((bean) => {
                                    return <tr key={bean.empId}>
                                        <td>{bean.empName}</td>
                                        <td>{bean.email}</td>
                                        <td>{bean.designation}</td>

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
                                <Modal.Title>Update User Details</Modal.Title>
                            </Modal.Header>
                            <Modal.Body>
                                <div className="row">
                                    <div className="col">
                                        <input type="text" onChange={(event) => { this.setState({ empName: event.target.value }) }}
                                            value={this.state.empName} className="form-control" readOnly />
                                    </div>

                                    <div className="col">
                                        <input type="text" onChange={(event) => { this.setState({ email: event.target.value }) }}
                                            value={this.state.email} className="form-control" readOnly />
                                    </div>
                                </div>
                                <br />
                                <div className="row">
                                    <div className="col">
                                        <input type="text" onChange={(event) => { this.setState({ designation: event.target.value }) }}
                                            value={this.state.designation} className="form-control" readOnly />
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