import React, { Component } from 'react'
import Axios from 'axios';
import { Modal, Button } from 'react-bootstrap'

export class ViewAccount extends Component {
    constructor(props) {
        super(props)
        this.state = {
            accounts: [],
            show:false,
            name:'',
            email:'',
            phoneno:'',
            password:'',
            id:''
        }
    }
    componentDidMount() {
        Axios.get('https://emp-app-405f8.firebaseio.com/accounts.json')
            .then((response) => {
                console.log("response", response.data)
                let fetchedaccount = [];
                for (let key in response.data) {
                    fetchedaccount.push({
                        ...response.data[key],
                        id: key
                    })
                    this.setState({
                        accounts: fetchedaccount
                    })
                    //console.log("fetched account", this.state.accounts)

                }
                console.log("fetchedaccount", fetchedaccount)

            }).catch((error) => {
                console.log("Error", error)

            })
    }
    deleteAccount(account) {
        Axios.delete('https://emp-app-405f8.firebaseio.com/accounts/' + account.id + '/.json')
            .then((response) => {
                alert('Deleted Successfully');
                let allaccounts = this.state.accounts;
                let index = allaccounts.indexOf(account);
                let newAccount = allaccounts.splice(index, 1);
                console.log("newAccount", newAccount);
                this.setState({
                    accounts: allaccounts
                })
            }).catch((error) => {
                alert('Deleted Failed');
            })
    }
    editAccount(account) {
        this.setState({
            show:!this.state.show,
            name:account.name,
            email:account.email,
            phoneno:account.phoneno,
            password:account.password,
            id:account.id

        })
      
    }
    handleClose(){
        this.setState({
            show:!this.state.show
        })

    }
    updateAccountData(){
        const{id, name,email,phoneno,password}=this.state;
        const account={name,email,phoneno,password};
        console.log("object", account)
        Axios.put('https://emp-app-405f8.firebaseio.com/accounts/'+id + '/.json', account)
        .then((response) => {
           console.log('Updated Successfully');
           this.handleClose();
           
            
        }).catch((error) => {
            alert('Updated Failed');
        })

    }

    render() {

        return (
            <div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Password</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.accounts.map((account) => {
                                return <tr key={account.id}>
                                    <td>{account.name}</td>
                                    <td>{account.email}</td>
                                    <td>{account.phone}</td>
                                    <td>{account.password}</td>
                                    <td>
                                        <button onClick={this.editAccount.bind(this, account)} className='btn btn-success'>
                                            Update
          
                                </button>
                                    </td>
                                    <td>
                                        <button onClick={this.deleteAccount.bind(this, account)} className='btn btn-danger'>
                                            Delete
        
                                </button>
                                    </td>
                                </tr>

                            }
                            )
                        }


                    </tbody>
                </table>
                <div>

                    <Modal show={this.state.show} onHide={this.handleClose.bind(this)}>
                        <Modal.Header closeButton>
                            <Modal.Title>Update Account</Modal.Title>
                        </Modal.Header>
                        <Modal.Body> <div className="row">
                            <div className="col">
                                <input type="text" onChange={(event) => { this.setState({ name: event.target.value }) }}
                                    value={this.state.name} className="form-control" placeholder="Name" />
                            </div>
                            <div className="col">
                                <input type="text" onChange={(event) => { this.setState({ email: event.target.value }) }}
                                    value={this.state.email} className="form-control" placeholder="Email" />
                            </div>
                        </div>
                            <div className="row">
                                <div className="col">
                                    <input type="number" onChange={(event) => { this.setState({ phoneno: event.target.value }) }}
                                        value={this.state.phoneno} className="form-control" placeholder="phone" />
                                </div>
                                <div className="col">
                                    <input type="password" onChange={(event) => {
                                        this.setState({
                                            password: event.target.value
                                        })
                                    }}
                                        value={this.state.password} className="form-control" placeholder="password" />
                                </div>
                            </div>
                        </Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={this.handleClose.bind(this)}>
                                Close
          </Button>
                            <Button variant="primary" onClick={this.updateAccountData.bind(this)}>
                                Save Changes
          </Button>
                        </Modal.Footer>
                    </Modal>
                </div>
            </div>
        )
    }
}

export default ViewAccount
