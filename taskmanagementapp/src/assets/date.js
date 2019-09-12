import React, { Component } from 'react'
import { Accordion, Card, Button } from 'react-bootstrap'
import './CompletedTask.css'
import moment from 'moment';
import Axios from 'axios';
import SearchNavabar from '../NavaBar/SearchNavabar';
import {
    ReactiveBase,
    DateRange,
    ResultCard,
    SelectedFilters,
    ReactiveList,
} from '@appbaseio/reactivesearch';

export default class CompletedTask extends Component {
    constructor(props) {
        super(props)
        this.state = {
            doneTask: [],
            endate: [],
            date:new Date(),
        }
    }
    dateQuery(value) {
        let query = null;
        if (value) {
            query = [
                {
                    range: {
                        date_from: {
                            gte: moment(value.start).format('YYYYMMDD'),
                        },
                    },
                },
                {
                    range: {
                        date_to: {
                            lte: moment(value.end).format('YYYYMMDD'),
                        },
                    },
                },
            ];
        }
        return query ? { query: { bool: { must: query } } } : null;
    }
    componentDidMount() {
        console.log('componentDidMount');
        Axios.get('http://localhost:8080/taskmanagement/getCompletedtask').then((response) => {
            console.log('Response Object', response);
            if (response.data.message === "Success") {
                this.setState({
                    doneTask: response.data.taskBean.filter(item => item.status === 'Done'),
                    //endate: response.data.taskBean[0].endDate
                })
                console.log("date", this.state.doneTask);
                console.log("enddate1", this.state.endate)
                console.log("date1", this.state.doneTask[0].status);
                this.getEndate();

            }
        }).catch((error) => {
            console.log('Error', error);
        })
    }
    getEndate() {

        const date = this.state.endDate
        const DateObj = new Date(date);
        console.log("enddate", this.state.endate)
    }

    render() {
        return (
            <div>
                <SearchNavabar />

                <div  >
                    <ReactiveBase
                       
                    >

                        <div className="col">
                            <DateRange
                                componentId="DateSensor"
                                dataField="date_from"
                                customQuery={this.dateQuery}
                                initialMonth={new Date('2019-01-05')}
                            />
                        </div>

                        <div className="col">
                            <SelectedFilters />
                            <ReactiveList
                                componentId="SearchResult"
                                dataField="name"
                                from={0}
                                size={20}
                                showPagination
                                react={{
                                    and: ['DateSensor'],
                                }}
                                render={({ }) => (
                                    <ReactiveList.ResultCardsWrapper>
                                       {console.log("date",this.state.date)}
                                       
                                       {console.log("=====end date====",(moment(this.state.doneTask.endDate).format("MM")))}
                                        {this.state.doneTask.filter(item=>(moment(item.endDate).format("MM")===moment(this.state.date).format("MM"))).map(item => (
                                            <div key={item.taskId}>

                                                <div id="drag3" className="sticky" >
                                                    <p class="danger">{item.description} </p>

                                                    <p class="danger">{(moment(item.endDate).format("MM-DD-YYYY"))} </p>
                                                </div>
                                            </div>
                                        ))}
                                         {console.log("=====end date====",(moment(this.state.doneTask.endDate).format("MM")))}
                                         {console.log("start and end date", (moment(this.dateQuery.gte).format("MM")))}
                                         {console.log("end date", moment(this.dateQuery.lte).format("MM"))}
                                        {this.state.doneTask.filter(item=>(moment(item.endDate).format("MM")===moment(this.state.date).format("MM"))).map(item => (
                                            <div key={item.taskId}>

                                                <div id="drag3" className="sticky" >
                                                    <p class="danger">{item.description} </p>

                                                    <p class="danger">{(moment(item.endDate).format("MM"))} </p>
                                                </div>
                                            </div>
                                        ))}
                                    </ReactiveList.ResultCardsWrapper>
                                )}
                            />
                        </div>

                    </ReactiveBase>

                </div>


            </div>
        )
    }
}
