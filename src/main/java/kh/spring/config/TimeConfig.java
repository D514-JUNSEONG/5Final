package kh.spring.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConfig {
	private static class TIME_MAXIMUM {

	    public static final int SEC = 60;
	    public static final int MIN = 60;
	    public static final int HOUR = 24;
	    public static final int DAY = 30;
	    public static final int MONTH = 12;
	}

	public static String calculateTime(Date date) {
	    long curTime = System.currentTimeMillis();
	    long regTime = date.getTime();
	    long diffTime = (curTime - regTime) / 1000;

	    String msg = null;

	    if(diffTime < TIME_MAXIMUM.SEC) {
	        // sec
	    	if(diffTime==0) {msg="방금전";}
	    	else {msg = diffTime + "초 전";}
	        
	    } else if ((diffTime /= TIME_MAXIMUM.SEC) < TIME_MAXIMUM.MIN) {
	        // min
	        System.out.println(diffTime);
	        msg = diffTime + "분 전";
	    } else if ((diffTime /= TIME_MAXIMUM.MIN) < TIME_MAXIMUM.HOUR) {
	        // hour
	        msg = (diffTime ) + "시간 전";
	    } else if ((diffTime /= TIME_MAXIMUM.HOUR) < TIME_MAXIMUM.DAY) {
	        // day
	        msg = (diffTime ) + "일 전";
	    } else if ((diffTime /= TIME_MAXIMUM.DAY) < TIME_MAXIMUM.MONTH) {
	        // day
	        msg = (diffTime ) + "달 전";
	    } else {
	        msg = (diffTime) + "년 전";
	    }
	    

	return msg;

	}
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		long curTime = System.currentTimeMillis();
		String s_date = "2021-08-12";
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s_date);
	    long regTime = date.getTime();
	    long diffTime = (curTime - regTime) / 1000;
	    
		System.out.println(curTime);
		System.out.println(date);
		System.out.println(regTime);
		System.out.println(diffTime);
		
		System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(calculateTime(date)));
	}
}
