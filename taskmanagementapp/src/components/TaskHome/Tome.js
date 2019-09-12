import React, { Component } from 'react'
import Axios from 'axios';
import SearchNavabar from '../NavaBar/SearchNavabar';

export default class Tome extends Component {
    constructor(props) {
        super(props)
        this.state = {
            Tome: [],
            //tomeBean:JSON.parse(localStorage.getItem("beans"))
        }
        this.state.Tome = JSON.parse(localStorage.getItem("beans"));
    }

    componentDidMount() {

        console.log('componentDidMount', Tome);
        Axios.get('http://localhost:8080/tome?email=' + this.state.Tome.email
        ).then((response) => {
            console.log('Response taskBean', response);
            if (response.data.message === "Success") {
                localStorage.setItem("taskBeans", JSON.stringify(response.data.taskBean));
                this.setState({
                    Tome: response.data.taskBean

                })




            }
        }).catch((error) => {
            console.log('Error', error);
        })


    }
    render() {
        return (
            <div>
                <SearchNavabar />
                <div>
                    {this.state.Tome.map(item => {


                        return (
                            <div id="drag3" className="sticky" >
                                <p class="danger">{item.description} </p>
                            </div>
                        )
                    })}
                </div>

            </div>
        )
    }
}
