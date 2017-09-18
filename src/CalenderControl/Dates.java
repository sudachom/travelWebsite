package CalenderControl;

public class Dates {
	
	private int date;
	private String style;
	private String desc;

	public Dates(int date,String style)
	{
		this.date = date;
		this.style = style;
	}
	
	public Dates(int date,String style,String desc)
	{
		this.date = date;
		this.style = style;
		this.desc = desc;
	}
	
	public String getStyle()
	{
		return this.style;
	}
	
	public int getDate()
	{
		return this.date;
	}
	
	public String getDesc()
	{
		return this.desc;
	}
}
