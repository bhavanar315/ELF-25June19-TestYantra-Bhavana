class Header extends React.Component{
    constructor(props){
        super(props);
        console.log(this.props);
    }
    render(){
        return React.createElement('h1', null, 'Header');
    }
}

class Content extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return React.createElement('ul', null,
        this.props.item.map((value,index)=>{
            return React.createElement("li",{key:index},value);
        }))
    }
}

class Footer extends React.Component{
    render(){
        return React.createElement('h1', null, 'Footer');
    }
}

const itemlist=['bag','pen','book'];

const header = React.createElement(Header,{items:['bag']});
const content = React.createElement(Content,{item:itemlist});
const footer = React.createElement(Footer);
const myapp = React.createElement("div",null, header, content,footer);
ReactDOM.render(myapp, document.getElementById('app'))