package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	private final static  Logger  _instance =  new Logger();
	BufferedWriter writer;
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
	
	//constructor
	private Logger()	
	{     try {
		writer= new BufferedWriter(new FileWriter("C:\\Git\\Insurance\\src\\application\\Logger.txt"));
	} catch (IOException e) {
		e.printStackTrace();
	}
		System.out.println("Constructor was called");
		
	}
	public static Logger getInstance()
	{
        return _instance;
	}
	
	
	
	public void writeLog(String str)  {
		 try {
			 //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			 String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
			    writer.write(timestamp + ": " + str + "\n");
			     
			   
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
	}
}

