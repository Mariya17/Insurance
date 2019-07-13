package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	private final static Logger _instance = new Logger();
	BufferedWriter writer;

	// constructor
	private Logger() {
		try {
			writer = new BufferedWriter(
					new FileWriter("C:\\Users\\Galit\\workspace\\Insurance-master\\src\\application\\Logger.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Logger getInstance() {
		return _instance;
	}

	public void writeLog(String str) {
		try {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
			writer.write(timestamp + ": " + str + "\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
