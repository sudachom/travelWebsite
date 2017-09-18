package CalenderControl;

import java.util.ArrayList;

public class Month {
	
	//make it for 13 plus december from last year
	private int[] dateMonth = {31,31,28,31,30,31,30,31,31,30,31,30,31};
	
	private int[] startMonth ={1,0,3,3,6,1,4,6,2,5,0,3,5};
	
	private int month;
	private int totalDay;
	private ArrayList<Dates> monthArray;
	private ArrayList<String>describe;
	static int numberLeft;

	public Month(int month)
	{
		this.month = month;
	}
	public Month(int month,ArrayList<String>describe)
	{
		this.describe = describe;
		this.month = month;
	}

	public ArrayList<Dates> getMonth()
	{
		ArrayList<Dates> numMonth = new ArrayList<Dates>();
				
		int count = startMonth[month];
		numberLeft = count;
		int number = dateMonth[month-1]-startMonth[month]+1;
		//get the style of the date
		String styleD = "difM";
		String styleS = "sameM";
		if(count != 0)
		{
			for(int i = 0;i<count;i++)
				{
					String numberW = number+"";
					numMonth.add(new Dates(number,styleD));
					number = number+1;
				}
		}
		for(int i = 0;i<dateMonth[month];i++)
		{
			int num = i;
			numMonth.add(new Dates(num+1,styleS));
		}			
		return numMonth;
	}
	
	public int getStartDay()
	{
		return startMonth[month];
	}
	
	public ArrayList<String> getDesc()
	{
		return this.describe;
	}
}
