package CalenderControl;


import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Flight {

	ArrayList<String>name = new ArrayList<String>();
	ArrayList<String>price = new ArrayList<String>();
	ArrayList<String>links = new ArrayList<String>();
	
	public Flight()
	{
		Document d = null;
		try {
			d = Jsoup.connect("https://www.skyscanner.com/flights-to/th/cheap-flights-to-thailand.html").ignoreContentType(true)
					   .referrer("http://www.google.com")   
			           .timeout(12000) 
			           .followRedirects(true).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//a#BD8U-cabin-2732-b-price.price
		Elements ele = d.select("div.square_content");
		Elements elo = ele.select("span.name");
		Elements wow = ele.select("span.price");
		Elements link = ele.select("a href");
		name = new ArrayList<String>();
		price = new ArrayList<String>();
		for(Element each : elo)
		{
			String text = each.text();
			name.add(text);
		}
		
		for(Element each : wow)
		{
			String text = each.text();
			price.add(text);
		}
		
		for(Element each : link)
		{
			String text = each.text();
			links.add(text);
		}
		
	}
	

	public ArrayList<String> getLink()
	{
		
		return this.links;
	}
	public String getLinkFromName(String name)
	{
		String result = "";
		
		return result; 
	}
	public ArrayList<String> getName()
	{
		return this.name;
	}
	
	public ArrayList<String> getPrice()
	{
		return this.price;
	}
	
}
