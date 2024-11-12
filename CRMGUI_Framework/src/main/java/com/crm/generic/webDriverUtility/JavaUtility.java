package com.crm.generic.webDriverUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	//to get random number
	public int getRandomNum() {
		Random random=new Random();
		int randomNum=random.nextInt(5000);
		return randomNum;
	}

	//in any format just pass
	public String getSystemDate(String format)
	{
		LocalDateTime time=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern(format);
		
		String date=time.format(formatter);
		return date;
	}
	
	//to get date after 30 days or before
	public String getRequiredDate(int days)
	{
		LocalDateTime time=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		String date;
		if(days>=0)
		{
		LocalDateTime s = time.plusDays(days);
		date=s.format(formatter);
		}
		else
		{
			LocalDateTime s = time.minusDays(days);
			date=s.format(formatter);
		}
		return date;
	}
}
