import React, { Component } from 'react'
import { Nav, Navbar, NavDropdown, NavbarBrand, Image} from 'react-bootstrap'
import { NavLink, withRouter } from 'react-router-dom';
import Axios from 'axios';

 class Navbarwithoutsearch extends Component {
    
    logout(e) {
        e.preventDefault();
        Axios.get('http://localhost:8080/taskmanagement/logout', null
        ).then((response) => {
            localStorage.clear();
            console.log('Response Object', response.data);
            if (response.data.message === "Success") {
                console.log(this.props);
                this.props.history.push('/');
                localStorage.setItem('logoutmsg', response.data.description);
            }

        }).catch((error) => {
            console.log('Error', error);
        })
    }
    render() {
        return (
            <div>
                <Navbar bg="dark" expand="lg" className="mr-auto">
                    <NavbarBrand Link="/TaskHome">Task Manager</NavbarBrand>
                    <Navbar.Toggle aria-controls="justify-content-end" />
                    <Navbar.Collapse id="justify-content-end">                        
                        {/* <Nav className="nav-link">               
                            <NavDropdown  title={<Image src="src/assets/images.jpeg" roundedCircle />} id="basic-nav-dropdown">
                                <NavDropdown.Item variant="link" onClick={this.logout.bind(this)}>Logout</NavDropdown.Item>                                
                                <NavLink className="nav-link" to="/myprofile"> Profile</NavLink>                                             
                            </NavDropdown>
                        </Nav> */}
                    </Navbar.Collapse>
                </Navbar>

        </div>
        )
    }
}

export default withRouter(Navbarwithoutsearch)