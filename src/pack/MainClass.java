package pack;


import java.io.File;
import java.util.Calendar;
import java.util.Date;

import net.sf.microlog.core.Level;
import net.sf.microlog.core.Logger;
import net.sf.microlog.core.LoggerFactory;
import net.sf.microlog.core.appender.ConsoleAppender;
import net.sf.microlog.core.format.PatternFormatter;
import net.sf.microlog.midp.file.FileAppender;
import net.sf.microlog.core.Appender;



public class MainClass 
{
	// Format string for all loggers
	private static String fmtString = "%d{HH:mm:ss:SSS} [%P] [%c{1}] %m";
	
	// Set the logging directory to a subdirectory of the home directory 
	private static String logDir = System.getProperty("user.home") + "/logging";
	
	// Appender stuff
	private static PatternFormatter formPattern;
	private static ConsoleAppender consoleAppender;
	private static FileAppender fileAppender;
	
	
	
	
	
	public static void main(String[] args) 
	{
		// make sure the logging dir exists
		mkdirIfNeeded(logDir);
		
		// initialize the appenders
		initAppenders();
		
		// Initialize the logger
		Logger log = LoggerFactory.getLogger(MainClass.class);
		configLogger(log);
		
		for(int i = 0; i < 5; i++)
		{
			log.info("Helloooooooooooooooo World!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	public static Logger configLogger(Logger log)
	{
		// set the root level
		log.setLevel(Level.TRACE);
		
		// Add the appenders
		log.addAppender(consoleAppender);
		
		// return the finished logger
		return log;
	}
	
	
	
	
	public static void initAppenders()
	{
		// Setup the pattern formatter to the proper pattern
		formPattern = new PatternFormatter();
		formPattern.setPattern(fmtString);
		
		// Setup console appender and add it to the logger
		consoleAppender = new ConsoleAppender();
		consoleAppender.setFormatter(formPattern);
		
		
		
		// Get the subdirectory and filename that we will log to
		
		// initialize the calendar to the date
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		// get the date components
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		// format the subdirectory name
		String dirName = year +"-"+ month +"-" + day;
		
		// get the time components
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		// format the log file name
		String logName = hour +"h-"+ minute +"m-"+ second + "s_roboLog";
		
		
		// make sure the logging subdirectory exists
		mkdirIfNeeded(logDir +"/"+ dirName);
		
		// full path to the log file
		String fullLogPath = logDir +"/"+ dirName +"/"+ logName +".log";
		
		// Initialize the FileAppender
		fileAppender = new FileAppender();
		fileAppender.setFormatter(formPattern);
		fileAppender.setFileName(fullLogPath);
	}
	
	
	
	private static void mkdirIfNeeded(String directoryName)
	{
		File theDir = new File(directoryName); 
		if (!theDir.exists())
		    theDir.mkdirs();
	}

}












