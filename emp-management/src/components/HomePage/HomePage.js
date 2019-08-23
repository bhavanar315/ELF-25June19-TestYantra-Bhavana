import React, { Component } from 'react'
import { Navbar,Nav, Form, FormControl, Button } from 'react-bootstrap'


export class HomePage extends Component {
    constructor(props) {
        super(props)
        this.state = {
            beandata: JSON.parse(localStorage.getItem("beans"))
        }
    }
    render() {
        return (
            <div>

                <Navbar expand="lg" variant="light" bg="light">
                    
                        <h1 className="navbar-brand">Employee Details</h1>
                        <Navbar.Toggle />
                        <Navbar.Collapse className="justify-content-center">
                        <Navbar.Text>
                                Signed in as:<h1>{this.state.beandata.empName}</h1>
                            </Navbar.Text>
                        </Navbar.Collapse>
                   
                    <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-primary">Search</Button>
                    </Form>
                    <Nav.Link Link="/logout">Logout</Nav.Link>
                </Navbar>

                Welcome

            </div>
        )
    }
}

export default HomePage
