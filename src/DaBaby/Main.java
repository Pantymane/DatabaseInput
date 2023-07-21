package DaBaby;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

public class Main {

	static Thread thread2 = new Thread(threadClass.graphicsPanel);
	static threadClass thread = new threadClass();
	static Thread thread1 = new Thread(thread);
	
	public static void main(String[] args) throws SQLException, IOException {
		
		loggerClass.LogDirectoryCreate();
		loggerClass.logCleanUP();
		loggerClass.logSetup();
		new loggerClass().logger.log(Level.INFO, "Program elindult, logCleanUp megkezdése.");
		
		DataBase.csatlakozas();
		DataBase.CarBeolvasas();
		
		thread2.setPriority(2);
		thread2.start();
		
		thread1.setPriority(1);
		thread1.start();
		
	}

}
