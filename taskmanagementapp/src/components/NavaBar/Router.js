import React from 'react'
import {BrowserRouter as Router,Route} from 'react-router-dom';
import CreateTask from '../TaskHome/CreateTask';
import Register from '../User/Register';
import MyProfile from '../User/MyProfile';
import Taskhome from '../TaskHome/Taskhome';
import Login from '../User/Login'
import Tome from '../TaskHome/Tome';
import Byme from '../TaskHome/Byme';

export default function Navbar(props) {
  return (
    <div>
      <Router>
            <Route exact path='/' component={Login}></Route>
              
               <Route path='/CreateTask' component={CreateTask}></Route>
               <Route path='/TaskHome' component={Taskhome}></Route>
              <Route path='/myprofile' component={MyProfile}></Route>
               <Route path='/addUser' component={Register}></Route>
               <Route path='/tome' component={Tome}></Route>
               <Route path='/byme' component={Byme}></Route>
           </Router>
    </div>
  )
}
