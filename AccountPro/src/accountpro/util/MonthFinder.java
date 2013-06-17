package accountpro.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;


import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Period;

public class MonthFinder {

	public static void main(String args[]) {
		
		
		DateTime start = new DateTime(2012, 05, 15, 0, 0, 0, 0);
		DateTime end = new DateTime(2013, 06, 16, 0, 0, 0, 0);
		
		System.out.println("Testing month between days");
		System.out.println("Day 1 : "+start);
		System.out.println("Day 2 : "+ end);

		// able to calculate whole months between two dates easily
		Months months = Months.monthsBetween(start, end);
		System.out.println("months between days "+months.getMonths());
		
		// period of 1 year and 7 days
		Period period = new Period(start, end);
		System.out.println("period between days :" +period);
		
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter("C:\\Vishal\\deploy_AccountPro\\timelog.txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write("Hello Java");
			  Date current = new Date();
			  out.write("\t Time stamp \n"+current);
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }

	}
	
}
