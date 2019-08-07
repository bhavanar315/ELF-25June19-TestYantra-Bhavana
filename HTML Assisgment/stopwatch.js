
       
       var count = 0; 
       var clearTime; 
       var seconds = 0, 
       minutes = 0, 
       hours = 0; 
       var clearState; 
       var secs, mins, gethours ; 
       function startWatch( ) { 
       function startTime( ) { 
       if ( seconds === 0 && minutes === 0 && hours === 0 ) { 
 
 var fulltime = document.getElementById( "fulltime" ); 
 fulltime.style.display = "none"; /* hide the start button if the stop watch is running */ 
 this.style.display = "none"; /* call the startWatch( ) function to execute the stop watch whenever the startTime( ) is triggered */ 
 startWatch( ); 
 } 
 // if () } 
 // startTime() 
 /* you need to bind the startTime( ) function to any event type to keep the stop watch alive ! */ 
 window.addEventListener( 'load', function ( ) { 
 var start = document .getElementById("start"); 
 start.addEventListener( 'click', startTime ); 
 }); // startwatch.js end 

 }
}
