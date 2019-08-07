function Header(props){
    console.log(props);
   return React.createElement('h1',null,"Header");

}
function Content(){

    return React.createElement('p',null,"content");
}

function Footer(){

    return React.createElement('h1',null,"Footer");
}
const header = React.createElement(Header);
const content = React.createElement(Content);
const footer = React.createElement(Footer);
const myApp= React.createElement("div",null, header, content,footer)
ReactDOM.render(myApp, document.getElementById('app'));