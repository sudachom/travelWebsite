 
 <%@ page import = "CalenderControl.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.IOException"%>
<% 
	ArrayList<String>name = new ArrayList<String>();
	ArrayList<String>price = new ArrayList<String>();
	ArrayList<String>links = new ArrayList<String>();
	name = (ArrayList<String>)request.getAttribute("flightName");
	price = (ArrayList<String>)request.getAttribute("flightPrice"); 
	links = (ArrayList<String>)request.getAttribute("flightLink"); 
	if(name == null)
	{
		Flight flightO = new Flight();
		name = flightO.getName();
		price = flightO.getPrice();
	}
	
	
	
	
%>
<div class="dropdown">
  <div id="myDropdown" class="dropdown-content">
  <%
  	for(int i =0;i<name.size();i++)
  	{
  		%>
  			 <a href="#"><%=name.get(i) + "  " +price.get(i) %></a>
  		<%
  	}
  %>
  </div>
</div>