import React from 'react'
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'
import HomePage from '../HomePage/HomePage'
import Login from '../Login/Login';
import base from '../CreateAccount/base';



export default function Navbar(props) {
    return (

        <Router>
             

                <Route exact path='/' component={Login}></Route>
                <Route  path='/home' component={HomePage}></Route>
                <Route path='/CreateEmployee' component={base}></Route>
            

    </Router>

            )
      }
