package logger;

import utility.Utility;

public class Logger {
	
	private static Logger instance;
	
	/**
	 * Make Logger constructor private so that nobody can use it
	 */
	private Logger() {
		
	}
	
	/**
	 * Proper way to initialize Logger
	 * If Logger is already initialized it just returns the instance
	 * @return Logger instance which is initialized once
	 */
	public static Logger getInstance() {
		synchronized (Logger.class) {
			
			if (instance == null) {
				instance = new Logger();
			}
		}
		return instance;
	}
	
	
	/**
	 * Function to return linenumber of exception
	 * @param exception
	 * @return linenumber as int
	 */
	private int getLineNumberOfException(Exception exception) {
		return exception.getStackTrace()[0].getLineNumber();
	}
	
	/**
	 * Formats the loggerMessage
	 * @param loggerLevel
	 * @param Class
	 * @param line
	 * @param message
	 * @return formatted message with brackets etc.
	 */
	private String createLoggerMessage(String loggerLevel, String Class, int line, String message) {
		return "["
				+ Utility.getDateAndTime()
				+ "]"
				+ "[" + loggerLevel + "]"
				+ "[" + Class + "]"
				+ "[" + "Line"
				+ String.valueOf(line) + "] "
				+ message;
	}
	
	private void writeLoggerMessageToConsole(String loggerLevel, String Class, Exception exception, String message) {
		
		int lineNumber = getLineNumberOfException(exception);
		String loggerMessage = createLoggerMessage(loggerLevel, Class, lineNumber, message);
		System.out.println(loggerMessage);
		
	}
	
	public void error(String Class, Exception exception, String message) {
		writeLoggerMessageToConsole("ERROR", Class, exception, message);
	}
	
	public void warn(String Class, Exception exception, String message) {
		writeLoggerMessageToConsole("WARN", Class, exception, message);
	}
	
	public void info(String Class, Exception exception, String message) {
		writeLoggerMessageToConsole("INFO", Class, exception, message);
	}
	
	public void debug(String Class, Exception exception, String message) {
		writeLoggerMessageToConsole("DEBUG", Class, exception, message);
	}
	
}
