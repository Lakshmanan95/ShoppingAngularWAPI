package com.example.eshopping.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateFormat {

	public static String getTodayString(){

		//Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		//formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String today = formatter.format(new Date());
		
		return  today;
	}
	
	public static Date stringToDate(String argDate) {
		Date t = null;
		try {
			//TimeZone tz = TimeZone.getDefault();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			sdf.setLenient(false);
			//sdf.setTimeZone(tz);
			t = new Date(sdf.parse(argDate).getTime());

		} catch (java.text.ParseException pe) {
			//logger_.debug("ParseException encountered in stringToTimestamp. String = " + argDate + ", Msg = " + pe.getMessage());
		}
		return t;
	}
	
	public  static String convertStringToDate(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   /*you can also use DateFormat reference instead of SimpleDateFormat 
	    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
	    */
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}
	
	public static String getDateAndTime(){
		Date dNow = new Date( );
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("yyyy-MM-dd HH:mm:s");
	      return ft.format(dNow);
	}
	public static Date getTodayAsDate(){
	 return new Date();
	}
//	public static void main(String s[]) throws ParseException{
//		
//	
//
//	}

}
