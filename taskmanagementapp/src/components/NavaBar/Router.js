import React from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom';
import CreateTask from '../TaskHome/CreateTask';
import MyProfile from '../User/MyProfile';
import Taskhome from '../TaskHome/Taskhome';
import Login from '../User/Login'
import Tome from '../TaskHome/Tome';
import Byme from '../TaskHome/Byme';
import CompletedTask from '../TaskHome/CompletedTask';
import TaskIndex from '../draganddrop/TaskIndex';


export default function Navbar(props) {
  return (
    <div>
      <Router>
        <Route exact path='/' component={Login}></Route>
        <Route path='/CreateTask' component={CreateTask}></Route>
        <Route path='/TaskHome' component={Taskhome}></Route>
        <Route path='/myprofile' component={MyProfile}></Route>
        <Route path='/tome' component={Tome}></Route>
        <Route path='/byme' component={Byme}></Route>
        <Route path='/completedTask' component={CompletedTask}></Route>
        <Route path='/TaskIndex' component={TaskIndex}></Route>
      </Router>
    </div>
  )
}
