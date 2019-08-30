import React from 'react'
import {BrowserRouter as Router,Route} from 'react-router-dom';
import CreateTask from '../TaskHome/CreateTask';
import Register from '../User/Register';
import MyProfile from '../User/MyProfile';
import Taskhome from '../TaskHome/Taskhome';
import Login from '../User/Login'

export default function Navbar(props) {
  return (
    <div>
      <Router>
            <Route exact path='/' component={Login}></Route>
              
               <Route path='/CreateTask' component={CreateTask}></Route>
               <Route path='/TaskHome' component={Taskhome}></Route>
              <Route path='/myprofile' component={MyProfile}></Route>
               <Route path='/addUser' component={Register}></Route>
           </Router>
    </div>
  )
}
