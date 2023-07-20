package DaBaby;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class loggerClass implements Runnable{

	static File filetxt = new File("Logs/LatestLog.txt");
	static Logger logger = Logger.getLogger(loggerClass.class.getName());
	
	@Override
	public void run() {
		
	}
	
	public static void logSetup() throws SecurityException, IOException {
		
		FileHandler file = new FileHandler("Logs/LatestLog.txt");
		
		SimpleFormatter sf = new SimpleFormatter();
		file.setFormatter(sf);
		
		
		logger.setLevel(Level.ALL);
		logger.addHandler(file);
		
		if (filetxt.isDirectory() == false && filetxt.exists() != true) {
			
			filetxt.createNewFile();
			
		}
		
	}
	
	public static void logCleanUP() {
		
		int logFiles = 0;
		String nev;
		File tothis;
		
		if (new File("Logs/LatestLog.txt").exists()) {
			
			do  {
				
				logFiles++;
				nev = "Log" + logFiles + ".txt";
				
				tothis = new File("Logs/"+nev);
						
			}while (tothis.exists() == true);
			
			filetxt.renameTo(tothis = new File("Logs/"+nev));
			}
	}
	
	public static void LogDirectoryCreate() throws IOException {
		
		File folder = new File("Logs");
		
		if (folder.exists() == false || folder.isDirectory() != true) {
			
			new File("Logs").mkdir();
			
		}
	}

}
