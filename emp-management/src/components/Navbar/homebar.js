import React from 'react'
import {Navbar} from 'react-bootstrap'

export default function Homebar(props) {
    return (
        <div>
             <Navbar>
                    <nav className="navbar navbar-expand-lg navbar-light bg-light">
                        <h1 className="navbar-brand">Employee</h1>
                        <Navbar.Toggle />
                        <Navbar.Collapse className="justify-content-end">
                            <Navbar.Text>
                                Signed in as: <h1>{this.state.beandata.empName}</h1>
                            </Navbar.Text>
                        </Navbar.Collapse>
                    </nav>
                </Navbar>
        </div>
    )
}
