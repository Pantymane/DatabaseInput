package DaBaby;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		
		loggerClass.LogDirectoryCreate();
		loggerClass.logCleanUP();
		loggerClass.logSetup();
		new loggerClass().logger.log(Level.INFO, "Program elindult, logCleanUp megkezdése.");
		
		DataBase.csatlakozas();
		DataBase.CarBeolvasas();
		FoFrame frame = new FoFrame();
		
	}

}
