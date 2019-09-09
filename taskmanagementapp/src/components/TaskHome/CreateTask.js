import React, { Component } from 'react'
import Axios from 'axios';
import { Form} from 'react-bootstrap'
import { Button } from 'react-bootstrap'
import Navbarwithoutsearch from '../NavaBar/Navbarwithoutsearch';
import SearchNavabar from '../NavaBar/SearchNavabar';

export default class CreateTask extends Component {
  constructor(props) {
    super(props)
    this.state = {
        taskId: '',
        description: '',
        email: '',
        subject: '',
        priority: '',
        assignDate: '',
        assignedTo: '',
        status: '',
        endDate: '',
        userBean: JSON.parse(localStorage.getItem('beans')),

    }
}
cancle(e) {
  e.preventDefault();
  this.props.history.push('/homePage')
}
  postData(e) {
    e.preventDefault();
    console.log("object",this.state.userBean.email);
    this.setState({
      email:this.state.userBean.email,
      status:'todo'
      
    })
    let postData = this.state
    Axios.post('http://localhost:8080/taskmanagement/createTask', postData).then((response) => {
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
        <SearchNavabar/>
        <div className="back" >
                    <div className="carduser col-md-4 offset-4" >
                        <h2 className="header-pos">ADD TASK</h2>

                        <div className="add-det">
                            <Form >

                                

                                <div class="col-sm- my-1">
                                    <div class="input-group">
                                       
                                        <Form.Group controlId="formBasicEmail">
                                            <Form.Control className="input-width" type="text" placeholder="subject" onChange={(event) => {
                                                this.setState({
                                                    subject: event.target.value
                                                })
                                            }} />
                                        </Form.Group>

                                    </div>
                                </div>

                                <div class="col-sm- my-1">
                                    <div class="input-group">
                                        
                                        <Form.Group controlId="formBasicEmail">
                                            <textarea className="input-width " type="text" placeholder="description" onChange={(event) => {
                                                this.setState({
                                                    description: event.target.value
                                                })
                                            }} />
                                        </Form.Group>

                                    </div>
                                </div>

                                <div class="col-sm- my-1">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            
                            <div class="input-group-text">Priority</div>
                                        </div>
                                        <select name="dropdown" onChange={(event) => {
                                            this.setState({
                                                priority: event.target.value
                                            })
                                        }}>
                                            <option value="high" selected>High</option>
                                            <option value="intermediate">Intermediate</option>
                                            <option value="low">Low</option>
                                        </select>
                                        </div></div>

                                        <div class="col-sm- my-1">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">Assign Date</div>
                                                </div>
                                                <Form.Group controlId="formBasicEmail">
                                                    <Form.Control className="input-width" type="date" placeholder="assignDate" onChange={(event) => {
                                                        this.setState({
                                                            assignDate: event.target.value
                                                        })
                                                    }} />
                                                </Form.Group>

                                            </div>
                                        </div>
                                        
                                        <div class="col-sm- my-1">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">Assigned To</div>
                                                </div>
                                                <Form.Group controlId="formBasicEmail">
                                                    <Form.Control className="input-width" type="text" placeholder="assignedTo" onChange={(event) => {
                                                        this.setState({
                                                            assignedTo: event.target.value
                                                        })
                                                    }} />
                                                </Form.Group>

                                            </div>
                                        </div>

                                        <div class="col-sm- my-1">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">End Date</div>
                                                </div>
                                                <Form.Group controlId="formBasicEmail">
                                                    <Form.Control className="input-width" type="Date" placeholder="endDate" onChange={(event) => {
                                                        this.setState({
                                                            endDate: event.target.value
                                                        })
                                                    }} />
                                                </Form.Group>

                                            </div>
                                        </div>
                                        <div class="col-sm- my-1">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">Status</div>
                                                </div>

                                                <Form.Group controlId="formBasicEmail">
                                                    <Form.Control className="input-width" type="text" placeholder="status" onChange={(event) => {
                                                        this.setState({
                                                            status: event.target.value
                                                        })
                                                    }} />
                                                </Form.Group>

                                            </div>
                                        </div>
                                        <Button className="submit-button" variant="primary" type="submit" onClick={this.postData.bind(this)}>
                                            Submit
                    </Button>
                                        <Button className="submit-button" variant="primary" type="cancel" onClick={this.cancle.bind(this)}>
                                            cancel
                    </Button>
                            </Form>
                                </div>
                    </div>
                        </div>
      </div>
    )
  }
}
