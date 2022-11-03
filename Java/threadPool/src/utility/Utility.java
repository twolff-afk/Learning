package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {
	
	/**
	 * Returns date and time in format: dd-MM-yy HH:mm:ss:SSS
	 * 
	 * @return Date and Time as String
	 */
	public static String getDateAndTime() {
		
		LocalDateTime dateObject = LocalDateTime.now();
		DateTimeFormatter formattedDateObject = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss:SSS");
		String formattedDate = dateObject.format(formattedDateObject);
		
		return formattedDate;
		
	}
	
}
