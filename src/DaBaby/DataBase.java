package DaBaby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;




public class DataBase {

		private static Connection con;
		private static PreparedStatement sql;
		
		private DataBase() {
			
			
		}
		
		public static void csatlakozas() throws SQLException {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				String connectionURL = "jdbc:mysql://127.0.0.1:3306/car_db?user=root&useSSL=false&autoReconnect=true";
				con = DriverManager.getConnection(connectionURL,"root","Tamas001");
				new loggerClass().logger.log(Level.INFO, "Sikeres csatlakozás az adatbázishoz!");
				
			}
			catch (Exception e) {
				
				new loggerClass().logger.log(Level.SEVERE, e.getMessage());
				
				throw new SQLException("A csatlakozás sikertelen "+e.getMessage());
				
			}
			
		}
		
		public static void kapcsolatBontas() throws SQLException {
			
			try {
				
				con.close();
				
			}
			catch (Exception e) {
				
				throw new SQLException("A kapcsolat bontása sikertelen! "+e.getMessage());
				
			}
			
		}
		
		public static void CarBeolvasas() throws SQLException {
			
			try {
				
				sql = con.prepareStatement("SELECT * from carlist");
				ResultSet res = sql.executeQuery();
				
				String id,name,brand,owner,value,age;
				
				while (res.next() == true) {
					
					id = res.getString(1);
					name = res.getString(2);
					brand = res.getString(3);
					owner = res.getString(4);
					value = res.getString(5);
					age = res.getString(6);
					String[] row = {id, name, brand, owner, value,age};
					threadClass.beolvas(row);
					
				}
				new loggerClass().logger.log(Level.INFO, "A táblázat frissült.");
				
			}
			catch(Exception e) {
				
				new loggerClass().logger.log(Level.SEVERE, e.getMessage());
				
				throw new SQLException("SQL adat beolvasás sikertelen "+e.getMessage());
				
			}
		
			
		}
		
		public static void ujCar(CarRecord car) throws SQLException {
			
			try {
				
				sql = con.prepareStatement("INSERT INTO carlist VALUES(?,?,?,?,?,?)");
				sql.setString(1, car.id());
				sql.setString(2, car.name());
				sql.setString(3, car.brand());
				sql.setString(4, car.owner());
				sql.setInt(5, car.value());
				sql.setInt(6, car.age());
				
				sql.executeUpdate();
				new loggerClass().logger.log(Level.INFO, "Új elem hozzáadva az adatbázishoz: "+car.id());
			}
			catch (Exception e) {
				
				new loggerClass().logger.log(Level.SEVERE, e.getMessage());
				
				throw new SQLException("Adatbázis hiba az adatfelvitelnél! "+e.getMessage());
				
			}
			
			
		}
		
		public static String idGenerator() {
			
			String ID = null;
			int count = 0;
			
			try {
				sql = con.prepareStatement("SELECT id from carList");
				ResultSet rs = sql.executeQuery();
				while (rs.next()) {
					String id = rs.getString(1).toString();
					//System.out.println(id);
					String idSplit[] = id.split(".", 5);
					//System.out.println(Arrays.toString(idSplit));
						if (count == Integer.parseInt(idSplit[4])) {
							count++;
						}
						else if (count < Integer.parseInt(idSplit[4])) {
							
							count = Integer.parseInt(idSplit[4])+1;
							
						}
						else {
							
		
							
						}
					
				}
				
			} catch (SQLException e) {
				
				new loggerClass().logger.log(Level.SEVERE, e.getMessage());
				
				e.printStackTrace();
			}
			
			ID = "Car."+count;
			
			return ID;
		}
		
		
		public static void delete() {
			
			try {
				sql = con.prepareStatement("DELETE FROM carlist WHERE id = ?");
				String carSelected = (String) (threadClass.tablex.getValueAt(threadClass.tablex.getSelectedRow(), 0));
				sql.setString(1, carSelected);
				sql.executeUpdate();
				System.out.println("Deletion complete!");
				System.out.println(carSelected);
				new loggerClass().logger.log(Level.INFO, "Sikeresen törölve az adatbázisból: "+carSelected);
			} catch (SQLException e) {
				
				new loggerClass().logger.log(Level.SEVERE, e.getMessage());
				
				e.printStackTrace();
			}
			
			
			
		}
		
		public static Optional<String[]> search(String HDHD) throws SQLException {
				
			
			
				sql = con.prepareStatement("SELECT * from carlist WHERE id = ?");
				System.out.println(HDHD);
				sql.setString(1, HDHD);
				ResultSet res = sql.executeQuery();
				
				String id,name,brand,owner,value,age;
				String[] rowFinal = null;
				
				while (res.next()) {
					
					id = res.getString(1);
					name = res.getString(2);
					brand = res.getString(3);
					owner = res.getString(4);
					value = res.getString(5);
					age = res.getString(6);
					String[] row = {id, name, brand, owner, value,age};
					rowFinal = row;
					new loggerClass().logger.log(Level.INFO, "Keresés végrehajtva, keresett data: "+id);
				}
					
				return Optional.ofNullable(rowFinal);
					
			
		
			
		}
		
		
	}

	

