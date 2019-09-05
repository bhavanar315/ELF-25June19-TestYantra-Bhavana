import React, { Component } from 'react'
import { Nav,  NavDropdown} from 'react-bootstrap'
import { NavLink } from 'react-router-dom';
import SearchNavabar from '../NavaBar/SearchNavabar';


export default class Taskhome extends Component {
    constructor(props){
        super();
        
      }

     


    
    render() {
        return (
            <div>
               <SearchNavabar/>
               <Nav className="nav-link">               
                            <NavDropdown  title="ToMe" id="basic-nav-dropdown">
                                <NavLink className="nav-link" to="/tome" >To Me</NavLink>                                
                                <NavLink className="nav-link" to="/byme">By Me</NavLink>                                             
                            </NavDropdown>
                        </Nav>                  
            </div>
        )
    }
}
