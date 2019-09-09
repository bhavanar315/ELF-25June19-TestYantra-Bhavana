import React, { Component } from 'react'
import { NavLink } from 'react-router-dom';
import NavbarforAll from '../NavaBar/NavbarforAll';
import Navbarwithoutsearch from '../NavaBar/Navbarwithoutsearch';
import Axios from 'axios';
import Form from 'react-bootstrap/Form'
import { Button } from 'react-bootstrap'
import './Login.css'
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'


export class Login extends Component {
    constructor(props) {
        super(props)

        this.state = {
            email: '',
            password: '',

        }
        this.pRef = React.createRef();
        this.error = "Login failed"

    }
    login(event) {
        event.preventDefault();
        Axios.post('http://localhost:8080/taskmanagement/login/authenticate', null,
            {
                params: {
                    email: this.state.email,
                    password: this.state.password
                }
            }
        ).then((response) => {
            console.log(response.data.message)
            if (response.data.message === 'Success') {
                console.log('data', response.data)
                localStorage.setItem("beans", JSON.stringify(response.data.userBean));
                this.props.history.push('/TaskHome')
            }
        }).catch((error) => {
            console.log(error)
        })
    }

    render() {
        return (
            <div>
                <Navbarwithoutsearch/>
                <body >
                    <div className='a'><center>
                        <p className="hidden" ref={this.pRef}>{this.error}</p></center>
                        <div className="d-flex justify-content-center h-100">
                            <div className="cardlogin">
                                <div className="cardheader">
                                    <h3><img src='https://icon-library.net/images/login-icon/login-icon-2.jpg' className="imgcss" /> </h3>
                                </div>
                                <div className="cardbody">
                                    <form>
                                        <div className="input-group form-group">
                                            <div className="input-group-prepend">
                                                <span className="input-group-text"><i className="fas fa-user"></i></span>
                                            </div>
                                            <input type="text" className="form-control" value={this.state.email} placeholder="user Email" onChange={(event) => { this.setState({ email: event.target.value }) }} />

                                        </div>
                                        <div className="input-group form-group">
                                            <div className="input-group-prepend">
                                                <span className="input-group-text"><i className="fas fa-key"></i></span>
                                            </div>
                                            <input type="password" className="form-control" placeholder="password" value={this.state.password} onChange={(event) => { this.setState({ password: event.target.value }) }} />
                                        </div>

                                        <div className="form-group">
                                            <input type="submit" value="Login" onClick={this.login.bind(this)} className="btn float-right login_btn" />
                                        </div>
                                        <br />
                                        <br />
                                        <div className="form-group">
                                            <input type="submit" value="Forgot Password" id="forgot" className="btn float-right login_btn" />
                                        </div>
                                    </form>
                                </div>

                                <div className="card-footer">
                                    <div className="d-flex justify-content-center links">
                                        {/* Don't have an account?<a href="#">Sign Up</a> */}
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </body>
            </div>
        )
    }
}
export default Login

