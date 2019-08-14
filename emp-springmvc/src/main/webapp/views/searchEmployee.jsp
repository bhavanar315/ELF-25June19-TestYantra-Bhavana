			<!DOCTYPE html>                                                                        
			
<%@page import="com.tyss.emp.dto.EmployeeInfoBean"%>
<%@page import="java.util.ArrayList"%>
<html>                                                                                 
			<head>                                                                                 
			<meta charset="ISO-8859-1">                                                          
			<title>Insert title here</title>                                                       
			<link rel="stylesheet"                                                               
				href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"       
				integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"   
				crossorigin="anonymous">                                                              
			<script                                                                            
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
				></script>
			</head>                                                                            
			<body>                                                                             
			<nav class="navbar navbar-expand-lg navbar-light bg-light">                      
			  <a class="navbar-brand" href="./home">EMP</a>                               
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navrSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>                                       
			  </button>                                                                           
			                                                                                      
			                                                                                      
			    <!-- <form class="form-inline my-2 my-lg-0" action="./validate" method="GET"> -->
			    <form class="form-inline my-2 my-lg-0" action="../employee/search" method="GET">                                  
			      <input class="form-control mr-sm-2" type="search" placeholder="Search" name="id" aria-labelSearch>
			      <!-- <input type="hidden" name="url" value="search"> -->
			      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			    </form>                                                                           
				<h6>Welcome ${bean.empName }</h6>
			    <a class="ml-auto" href="./logout">Logout</a>                  
			</nav> 
			<%ArrayList<EmployeeInfoBean> arrId=(ArrayList<EmployeeInfoBean>)request.getAttribute("ArrayIds"); %>                                                                               
			 <div class="card-body"> 
			 <h3>List of Employees</h3>                                                           
			<table class="table table-borderless">  
			
			  <thead>                              
			    <tr>                               
			      <th >Employee Id</th>  
			      <th >Name</th>         
			    </tr>                           
			  </thead>                             
			  <tbody>                              
			<% for (EmployeeInfoBean employeeInfoBean : arrId) {%>
			    <tr>                                
			     <%--  <td><a href="./validate?url=fetch&emp=<%=employeeInfoBean.getId() %>"><%=employeeInfoBean.getId() %></a></td> --%>
			      <td><a href="../employee/fetch?emp=<%=employeeInfoBean.getId() %>"><%=employeeInfoBean.getId() %></a></td>              
			      <td><%=employeeInfoBean.getEmpName() %></td>                    
			    </tr>                               
			<%} %>
			  </tbody>                              
			</table>                                
			 </div >                                
			</body>                                 
			</html>            