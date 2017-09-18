package CalenderControl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Load {

	private int month;
	private ArrayList<String> result;
	private ArrayList<Desc> desc = new ArrayList();
	
	public Load()
	{
		
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public void reset()
	{
		desc = null;
	}
	//save the file for each month in seperate file
	private static String getFileName(int number)
	{
		String fileName = null;
		
		 switch (number) {
		  case 0:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/exDecember.txt";
          break;
         case 1:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/January.txt";
                  break;
         case 2:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/February.txt";
                  break;
         case 3:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/March.txt";
                  break;
         case 4:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/April.txt";
                  break;
         case 5:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/May.txt";
                  break;
         case 6:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/June.txt";
                  break;
         case 7:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/July.txt";
                  break;
         case 8:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/August.txt";
                  break;
         case 9:  fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/September.txt";
                  break;
         case 10: fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/October.txt";
                  break;
         case 11: fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/November.txt";
                  break;
         case 12: fileName = "/Users/sudachom/Documents/workspace/Service Content/WebContent/calendaWithJava/monthFile/December.txt";
                  break;
         default: fileName = "Invalid month";
                  break;
     }
		return fileName;
	}
	
	private static ArrayList<String> getDesc(int number) throws FileNotFoundException, IOException
	{
		//this month
		ArrayList<String> result = new ArrayList();
		//previewsly month
		ArrayList<String> al = new ArrayList();
		String fileName = getFileName(number-1);
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        al.add(line);
		    }
		    
		}
		//the arrayList will have the last one is null
		int startNum = al.size()-Month.numberLeft-1;
		int max = al.size();
		for(int i=startNum;i<max;i++)
		{
			result.add(al.get(i));
		}
		result.removeAll(Collections.singleton(null));
		//get the input month 
		fileName = getFileName(number);
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    result.add(line);
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        result.add(line);
		    }
		}
		result.remove(result.size()-1);
		return result;
	}

	
	public ArrayList<String> getResult()
	{
		try {
			result = getDesc(month);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
