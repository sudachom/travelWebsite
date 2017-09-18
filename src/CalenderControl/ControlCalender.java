package CalenderControl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControlCalender
 */
@WebServlet("/ControlCalender")
public class ControlCalender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Load load = new Load();
	private static HttpServletResponse response = null;
	ArrayList<String>flightName = new ArrayList<String>();
	ArrayList<String>flightPrice = new ArrayList<String>();
	ArrayList<String>flightLink = new ArrayList<String>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlCalender() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException
    {
		ArrayList<String>flight = new ArrayList<String>();
		Flight flightO = new Flight();
		flightName = flightO.getName();
		flightPrice = flightO.getPrice();
		flightLink = flightO.getLink();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.response = response;
		String action = request.getParameter("action");
		String message = "the number";
		ArrayList<Dates>month = null;
		Month monthName = null;
		String user = null;
		int number = 0;
		//for month description
		ArrayList<String>monthDes = null;

		if(action!=null)
		{
			
			
			user = request.getParameter("user");
			message = message +"  " + user;
			number = Integer.parseInt(user);
			month = getArrayOfMonth(number);
			monthName = new Month(number);
			//get the file and arraylist from load and assign the ArrayList 
			load.setMonth(number);
			monthDes = load.getResult();
			
		}else
		{
			message = message + " "+ " Null";
		}
		
		request.setAttribute("user",user);
		request.setAttribute("monthNumber",message);
		request.setAttribute("monthArray", month);
		request.setAttribute("monthName", getNameOfMonth(number));
		request.setAttribute("dayName",monthName.getStartDay());
		request.setAttribute("monthDesc", monthDes);
		//the first day of the month when the user change the month 
		request.setAttribute("getFirst",getTheFirstDay(number));
		request.setAttribute("flightName", flightName);
		request.setAttribute("flightPrice",flightPrice);
		request.setAttribute("flightLink",flightLink);
		request.getRequestDispatcher("calendaWithJava/index.jsp").forward(request,response);
	}

	public static ArrayList<Dates> getArrayOfMonth(int number)
	{
		Month month = new Month(number);
		ArrayList<Dates> getArrayDate = month.getMonth();
		return getArrayDate;
	}
	
	public static String getNameOfMonth(int number)
	{
		String [] months = {"December","Janyuary","Feburay","March","April","May","June",
				"July","August","September","October","November","December"};
		return months[number];
	}
	public static String getTheFirstDay(int number)
	{
		String one = "this is the test";
		return one;
	}
	
}

