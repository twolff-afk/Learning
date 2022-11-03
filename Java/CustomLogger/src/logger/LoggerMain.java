package logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerMain {

	private static String getDateAndTime() {
		
		LocalDateTime dateObject = LocalDateTime.now();
	    DateTimeFormatter formattedDateObject = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss:SSS");
	    String formattedDate = dateObject.format(formattedDateObject);
		
		return formattedDate;
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());
		System.out.println(getDateAndTime());

	}

}
