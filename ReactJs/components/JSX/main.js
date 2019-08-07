// const name="Bhavana"
// const element=<h1>{name}</h1>

function Welcome(props){
    return(
        <div>
           <h1 style={{color:'Green'}}>{props.name}</h1>
           {/* <button onClick={()=>alert('Button')}>click</button> */}
           <button onClick={alert.bind(this,' This is Button')}>click</button>
           </div>

    )
}

class Message extends React.Component{
    constructor(props){
        super(props);
        this.state={
            name:'Gayi'
        }
        this.changeMessage=this.changeMessage.bind(this);
       // this.clickLink=this.clickLink.bind(this);

    }
    render(){
        console.log("Rendering");
        return(
            <div>
                <h1>{this.state.name}</h1>
                <button onClick={this.changeMessage}>changeMessage</button>
                <a href="https://reactjs.org/docs/cdn-links.html" onClick={this.clickLink}>Link</a>
            </div>
        )

    }
    changeMessage(){
        console.log("hjbnjbnjk")
        this.setState({
            name:'Bhavana'

        })
    }
    // clickLink(event){
    //     event.preventDefault();

    // }
    clickLink=(e)=>{
        e.preventDefault();//to prevent the default function/behaviour of anchor tag
    }
}

// ReactDOM.render(<Welcome name="Bhavana" />, document.getElementById("app"))

ReactDOM.render(<Message />, document.getElementById("app"))