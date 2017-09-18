<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href = "style.css" type = "text/css">
<meta name ="viewport" content="width=device-widht,initial-scale = 1">
<style type="text/css">
    <%@include file="style.css" %>
</style>
<script type = "text/javascript" >
<%@include file="jquery/jquery-3.2.1.min.js" %>
<%@include file="jquery/jquery.js" %>
</script>
<title>Calendar</title>
<%@ page import="java.util.*"%>
<%@ page import = "CalenderControl.*"%>
</head>
<body>
<%
	ArrayList<Dates> monthArray=(ArrayList<Dates>)request.getAttribute("monthArray");
	ArrayList<String> monthDesc=(ArrayList<String>)request.getAttribute("monthDesc");
	ControlCalender control = new ControlCalender();
	Calendar now = Calendar.getInstance();
	int number = now.get(Calendar.MONTH)+1;
	int today = now.get(Calendar.DATE);
	String day = "";
	int date =0;
	//set the desc first to 0 and then will assign using monthArray index this one control the description when the first load
	//this number will use in the flight click if the user didnt click anyday and want to choose today is the day
	int number4DescToday = 0;
	if(monthArray == null)
	{
		ArrayList<Dates>temp = control.getArrayOfMonth(number);
		for(int i = 0;i<temp.size();i++)
		{
			if(temp.get(i).getDate() == today)
			{
				number4DescToday = i;
			}
		}
	}

%>
<%!

public boolean getApril(String input){
	boolean showLine = false;
	if(input.equals("4"))
	{
		showLine = true;
	}else
	{
		showLine = false;
	}
return showLine;
}
%>
<div id="calender">
	<div id = "descriptionBoxLeft">
		<div id = "wrapper">
			<header>
				<h1 class = "textH1">
				<%
					String [] weeks = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
				if(monthArray !=null)
				{
					Integer num = (Integer)request.getAttribute("dayName");
					%><%=weeks[num]%><% 
				}else
				{
					Month month = new Month(number);
					%><%=weeks[month.getStartDay()]%><% 
				}	
				%>
				</h1>
				<div id = "box">
				<h2><span class = "textH2">
				<% 
					if(monthArray != null)
					{
						%><%=1%><%
					}else{
						%><%=today%><%
					}
				%></span><span  class = "monthN">
				<%	
					if(monthArray !=null)
					{
						%><%=request.getAttribute("monthName")%><% 
					}else
					{
						%><%=control.getNameOfMonth(number)%><% 
								//assign the number4DescToday
					}
				
				%></span>
				</h2>
				</div>
			</header>
			<div id = "addBox">
				<ul>
					<li onclick="myFunction()" class="dropbtn">FLIGHT</li>
					<li>HOTEL</li>
					<li>TOUR</li>
				</ul>
				<%@include file = "flightForm.jsp" %>
			</div>
			<div id = "description">
				<h3>Things To Do</h3>
				<ul class = "monthDesc">
				<%
					String image = null;
					if(monthDesc != null)
					{
						String[]temp = null;
							for(int i = 0;i<monthDesc.size();i++)
						{	
					
						if(monthDesc.get(i) != null)
						{
							temp = monthDesc.get(i).split("!");
							image = request.getContextPath()+"/calendaWithJava/"+ temp[0];
						}else{
							image= request.getContextPath()+"/calendaWithJava/temple.jpg";
						}
				%>
						<img class = "hidden" src="<%=image %>">
						<li class = "hidden"><%=(monthDesc.get(i)!=null&&temp!=null)?temp[1]:""%></li>
			
				<% 
						}
						if(request.getAttribute("getFirst") != null)
							{
								image  = request.getContextPath()+"/calendaWithJava/temple.jpg";
								%>
								<img src="<%=image %>"> 
								<li class = "once"><%=request.getAttribute("getFirst")%></li>
								<% 
							}
					}else{
						Load tempL = new Load();
						tempL.setMonth(number);
						monthDesc  = tempL.getResult();
						String[]temp = null;
						for(int i = 0;i<monthDesc.size();i++)
						{	
							if(monthDesc.get(i) != null)
							{
								temp = monthDesc.get(i).split("!");
								image = request.getContextPath()+"/calendaWithJava/"+ temp[0];
							}else{
								image= request.getContextPath()+"/calendaWithJava/temple.jpg";
							}
							%>
							<img class = "hidden" src="<%=image %>">
							<li class = "hidden"><%=(monthDesc.get(i)!=null&&temp!=null)?temp[1]:""%></li>
					<% 
					}
						String[]temp2 = monthDesc.get(number4DescToday).split("!");
						%>
						<img class = "once" src="<%=temp2[0] %>">
						<li class = "once"><%=temp2[1]%></li><% 
				}
								
			%>
				</ul>
			</div>
		</div>
	</div>
	<div id = "calenderBoxRight">
		<header>
			<h1 class = "year">2016</h1>
			<h2 class = "monthName">
			<%
	
				if(monthArray !=null)
				{
					%><%=request.getAttribute("monthName")%><% 
				}else
				{
					%><%=control.getNameOfMonth(number)%><% 
				}
			%>
			
			</h2>
				 <form id = "month" action = "/Service_Content/ControlCalender" method = "post">
				<input type = "hidden" name = "action" value = "dologin"/ >
				  <select name="user" value = "Choose Month">
				  	 <option value = "<%=number%>">Which Month</option>
  					 <option value="1">January</option>
    				 <option value="2">Febuary</option>
  					 <option value="3">March</option>
    				 <option value="4">April</option>
    				 <option value="5">May</option>
  					 <option value="6">June</option>
    				 <option value="7">July</option>
    				 <option value="8">August</option>
    				 <option value="9">September</option>
    				 <option value="10">October</option>
  					 <option value="11">November</option>
    				 <option value="12">December</option>
  				  </select>
            	<input type = "submit" value=" HIT ME!!" class = "button">
			</form>
				<h5 class="hidden">
				<%
					if(monthArray !=null)
					{
						%><%=request.getAttribute("user")%><% 
					}else
					{
						%><%=number%><% 
					}
				%>
				</h5>
		</header>
		<div id = "calenderContainer">
			<ul>
				<li>SUN</li>
				<li>MON</li>
				<li>TUE</li>
				<li>WED</li>
				<li>THU</li>
				<li>FRI</li>
				<li>SAT</li>
			</ul>	<%
				int count = 0;
			%><ul><%
			//this if will handle when the user input the number or not the if will handle when the user input the month
			//else if will handle only the month is April which has the SongKran Festival
			//the else will handle when the first this page load will show based on the today 
				if(monthArray != null)
				{
					String  user = (String)request.getAttribute("user");
					boolean showLine = getApril(user);
					
					for(int i =0;i<monthArray.size();i++)
					{
						%><li class = <%=monthArray.get(i).getStyle() %>>
						<% 
						
						   if(showLine)
						   {
							   if(monthArray.get(i).getDate() == 1)
								{
								//this if will automatice to be the first day of that month
									%>
										<div class = "thisDate"><%=monthArray.get(i).getDate()%></div>
									<% 
								}else if(monthArray.get(i).getDate() == 13)
								{
									%>
										<div id = "thisDateM"><%=monthArray.get(i).getDate()%></div><section id = "lines"></section>
									<% 
								}else if(monthArray.get(i).getDate() == 14)
								{
									%>
										<div id = "thisDateM"><%=monthArray.get(i).getDate()%></div><section id = "lines"></section>
									<% 
								}else if(monthArray.get(i).getDate() == 15)
								{
									%>
										<div id = "thisDateM"><%=monthArray.get(i).getDate()%></div>
									<% 
								}else{
								%>
									<div><%=monthArray.get(i).getDate()%></div>
								<% };	   
						   }else
						   {
								if(monthArray.get(i).getDate() == 1)
								{
								//this if will automatice to be the first day of that month
									%>
										<div class = "thisDate"><%=monthArray.get(i).getDate()%></div>
									<% 
							}else{
							%>
									<div><%=monthArray.get(i).getDate()%></div>
							<% };
						   };
						%>
						</li>
						<% 
						count++;
						if(count==7)
						{
							count=0; 
						%>
								</ul>
								<ul>  	
						 <%
						};
					}					
				}else{
					monthArray = control.getArrayOfMonth(number);
					String num = String.valueOf(number);
					boolean showLine = getApril(num);
							for(int i =0;i<monthArray.size();i++)
					{
						%><li class = <%=monthArray.get(i).getStyle() %>>
							<%
							if(!showLine)
						{
							if(monthArray.get(i).getDate() == today && i> today)
							{
									%>
										<div class = "thisDate"><%=monthArray.get(i).getDate()%></div>
									<% 
							}else{
								%>
									<div><%=monthArray.get(i).getDate()%></div>
							<% };	
						}else
						{
							   if(monthArray.get(i).getDate() == 1)
								{
								//this if will automatice to be the first day of that month
									%>
										<div class = "thisDate"><%=monthArray.get(i).getDate()%></div>
									<% 
								}else if(monthArray.get(i).getDate() == 10)
								{
									%>
										<div class = "thisDateM"><%=monthArray.get(i).getDate()%></div><div class = "lines"></div>
									<% 
								}else if(monthArray.get(i).getDate() == 11)
								{
									%>
										<div class = "thisDateM"><%=monthArray.get(i).getDate()%></div><div class = "lines"></div>
									<% 
								}else if(monthArray.get(i).getDate() == 12)
								{
									%>
										<div class = "thisDateM"><%=monthArray.get(i).getDate()%></div>
									<% 
								}else{
								%>
									<div><%=monthArray.get(i).getDate()%></div>
								<% };
						}
						%></li>
						<% 
						count++;
						if(count==7)
						{
							count=0; 
						%>
								</ul>
								<ul>  	
						 <%
						};
				    }
				}
			
				%>
		</div>
	</div>
</div>
</body>
</html>