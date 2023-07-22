package DaBaby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class threadClass implements Runnable{

	static int x = 1200;
	static int y = 675;
	
	static JTable tablex;
	static String[] columns = new String[] {"ID","Name","Brand","Owner","Value","Age"};
	static DefaultTableModel model = new DefaultTableModel(null ,columns);
	static JScrollPane scrollPane = new JScrollPane();
	static myGraphicsPanel graphicsPanel;
	static JLayeredPane loading = new JLayeredPane();
	static JLayeredPane userSide = new JLayeredPane();
	static Timer timer;
	
	static animatedButtons save = new animatedButtons("Save", 560, 270, 80, 40);
	static animatedButtons new1 = new animatedButtons("New", 22, 450, 80, 40);
	static animatedButtons delete = new animatedButtons("Delete", 1020, 234, 110, 40);
	static animatedButtons exit = new animatedButtons("Exit", 1050, 550, 80, 40);
	static animatedButtons load = new animatedButtons("Load", 920, 234, 80, 40);
	static animatedButtons music = new animatedButtons("Music", 1030, 500, 100, 40);
	
	static animatedButtons musicBack = new animatedButtons("Back", 1030, 500, 100, 40);
	static animatedButtons new1Back = new animatedButtons("Back", 22, 450, 80, 40);
	
	 
	public static void beolvas(String[] row) {
		
		
		model.addRow(row);
		
		
	tablex = new JTable(model);
	scrollPane.setViewportView(tablex);
	
}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		
	
	
	
class FoFrame extends JFrame implements ActionListener{
	
	 static JCheckBox chckBox = new JCheckBox("");
	static JPanel panel = new JPanel();
	JTextField text = new JTextField();
	JTextField 	carName = new JTextField("Car Name");
	JTextField carBrand = new JTextField("Car Brand");
	JTextField carOwner = new JTextField("Car Owner");
	JTextField carValue = new JTextField("Car Value");
	JTextField carAge = new JTextField("Car Age");
	JFrame newFrame;
	
	public FoFrame() {
		
		this.setTitle("Car information");
		this.setSize(x,y);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setFocusable(false);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				Object[] kerdes = {"Igen","Nem"};
				
				int valasz = JOptionPane.showOptionDialog(rootPane, "Bisztosan ki akar lépni?", "Kilépés", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kerdes, kerdes[0]);
				if (valasz == 0) {
					
					new loggerClass().logger.log(Level.INFO, "Kilépés a programból.");
					System.exit(0);
					
				}
			}
			
		});
		
		carName.setBounds(500, 320, 200, 30);
		carName.setOpaque(false);
		carName.setForeground(Color.white);
		
		carBrand.setBounds(500, 370, 200, 30);
		carBrand.setOpaque(false);
		carBrand.setForeground(Color.white);
		
		carOwner.setBounds(500, 420, 200, 30);
		carOwner.setOpaque(false);
		carOwner.setForeground(Color.white);
		
		carValue.setBounds(500, 470, 200, 30);
		carValue.setOpaque(false);
		carValue.setForeground(Color.white);
		
		carAge.setBounds(500, 520, 200, 30);
		carAge.setOpaque(false);
		carAge.setForeground(Color.white);
		
		new1.addActionListener(this);
		save.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);
		load.addActionListener(this);
		music.addActionListener(this);
		new1Back.addActionListener(this);
		musicBack.addActionListener(this);
		
		
		tablex.setBackground(new Color(0, 0, 0, 80));
		tablex.setForeground(Color.WHITE);
		tablex.setOpaque(false);
		
		scrollPane.setBounds(22, 11, 1142, 213);
		scrollPane.setViewportView(tablex);
		scrollPane.setBackground(new Color(0, 0, 0, 80));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		text.setBounds(22, 21, 173, 20);
		text.setEditable(false);
		text.setOpaque(false);
		text.setForeground(Color.white);
		
		chckBox.setBounds(210, 18, 21, 23);
		chckBox.addActionListener(this);
		chckBox.setOpaque(false);
		
		panel.setBounds(22, 500, 249, 46);
		panel.setToolTipText("Car ID:");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.add(text);
		panel.add(chckBox);
		panel.setBackground(new Color(0, 0, 0, 80));
		panel.setOpaque(false);
		
		userSide.setBounds(0, 0, 1186, 638);
		userSide.setPreferredSize(new Dimension(x, y));
		userSide.setLayout(null);
		userSide.setBackground(new Color(0, 0, 0, 80));
		userSide.setVisible(true);
		
		graphicsPanel = new myGraphicsPanel();
		
		graphicsPanel.setBounds(0, 0, 1200, 675);
		userSide.add(new1);
		userSide.add(delete);
		userSide.add(load);
		userSide.add(exit);
		userSide.add(music);
		userSide.add(scrollPane);
		userSide.add(FoFrame.panel);
		getContentPane().setLayout(null);
		
		loading.setBackground(Color.black);
		loading.setLayout(null);
		loading.setLocation(0, 0);
		loading.setPreferredSize(new Dimension(1200, 675));
		
		//getContentPane().add(loading);
		getContentPane().add(userSide);
		getContentPane().add(graphicsPanel);
		
		this.setVisible(true);
		
		timer = new Timer(1600, this);
		timer.setRepeats(false);
		timer.start();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	if (e.getSource() == timer && myGraphicsPanel.ney == 100)
	{
	
		//this.remove(loading);
		//this.validate();
		
	}
	
	if (e.getSource() == exit) {
			
			Object[] kerdes = {"Igen","Nem"};
			
			int valasz = JOptionPane.showOptionDialog(rootPane, "Bisztosan ki akar lépni?", "Kilépés", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kerdes, kerdes[0]);
			if (valasz == 0) {
				
				new loggerClass().logger.log(Level.INFO, "Kilépés a programból.");
				System.exit(0);
				
			}
			
		}
		else if (e.getSource() == new1) {
			
			if (music.getText() == "Back") {
				
				userSide.remove(musicClass.pane);
				music.setText("Music");
				userSide.remove(musicBack);
				userSide.add(music);
				
			}
			
			if (new1.getText() == "New") {
			
			userSide.add(carName);
			userSide.add(carBrand);
			userSide.add(carOwner);
			userSide.add(carValue);
			userSide.add(carAge);
			carName.setVisible(true);
			carBrand.setVisible(true);
			carOwner.setVisible(true);
			carValue.setVisible(true);
			carAge.setVisible(true);
			userSide.add(save);
			new1.setSize(100, 40);
			new1.setText("Back");
			userSide.remove(new1);
			userSide.add(new1Back);
			
		
			}
		}
		else if (e.getSource() == save) {
			
			if (!carValue.getText().isBlank() &&
					isNumeric(carValue.getText()) &&
					!carAge.getText().isBlank() &&
					isNumeric(carAge.getText()) &&
					!carName.getText().isBlank() &&
					!carBrand.getText().isBlank() &&
					!carOwner.getText().isBlank()) {
				
			CarRecord newCar = new CarRecord( 
					DataBase.idGenerator(),
					carName.getText(),
					carBrand.getText(),
					carOwner.getText(),
					Integer.parseInt(carValue.getText()),
					Integer.parseInt(carAge.getText())
					);
			
			try {
				DataBase.ujCar(newCar);
				model = new DefaultTableModel(null, columns);
				DataBase.CarBeolvasas();
				tablex.setBackground(new Color(0, 0, 0, 80));
				tablex.setForeground(Color.WHITE);
				tablex.setOpaque(false);
				getContentPane().add(graphicsPanel);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog( rootPane, "Az új autó sikeresen elmentve.", "Sikeres felvitel!", JOptionPane.INFORMATION_MESSAGE, null);
			newFrame.dispose();
			
			}
			else {
				
				JOptionPane.showMessageDialog( rootPane, "Kérem ellenőrizze a megadott adatokat!", "Hiányos kitöltés", JOptionPane.INFORMATION_MESSAGE, null);
				
			}
			
		}
		else if (e.getSource() == load) {
			
			model = new DefaultTableModel(null, columns);
			
			if (!chckBox.isSelected()) {
			
			try {
				DataBase.CarBeolvasas();
				tablex.setBackground(new Color(0, 0, 0, 80));
				tablex.setForeground(Color.WHITE);
				tablex.setOpaque(false);
				getContentPane().add(graphicsPanel);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			else {
				
				try {
					Optional<String[]> acquired= DataBase.search(text.getText());
					
					String[] opcional = {"Nincs ilyen ID-val rendelkező adat!","Null","Null","Null","Null","Null"};
					
					model.addRow(acquired.orElse(opcional));
					tablex.setModel(model);
					tablex.setBackground(new Color(0, 0, 0, 80));
					tablex.setForeground(Color.WHITE);
					tablex.setOpaque(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		else if (e.getSource() == delete){
			
			
			
			if (tablex.getSelectedRow() == -1) {
				
				JOptionPane.showMessageDialog(rootPane, "Nincs kiválasztott elem.");
				
			}
			else  {
				DataBase.delete();
				model = new DefaultTableModel(null, columns);
				try {
					DataBase.CarBeolvasas();
					tablex.setBackground(new Color(0, 0, 0, 80));
					tablex.setForeground(Color.WHITE);
					tablex.setOpaque(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			
		}
		else if (e.getSource() == chckBox) {
			
			if (chckBox.isSelected()) {
			text.setEditable(true);
			
			}
			else {
				
				text.setEditable(false);
				
			}
		}
		else if (e.getSource() == music) {
			
			if (new1.getText() == "Back") {
				
				userSide.remove(carName);
				userSide.remove(carBrand);
				userSide.remove(carOwner);
				userSide.remove(carValue);
				userSide.remove(carAge);
				carName.setVisible(false);
				carBrand.setVisible(false);
				carOwner.setVisible(false);
				carValue.setVisible(false);
				carAge.setVisible(false);
				userSide.remove(save);
				new1.setSize(80, 40);
				new1.setText("New");
				userSide.remove(new1Back);
				userSide.add(new1);
				
			}
			
			if (music.getText() == "Music") {
			
			musicClass.musicPanelBuilder();
			userSide.add(musicClass.pane);
			music.setText("Back");
			userSide.remove(music);
			userSide.add(musicBack);
			
		
			}
		
	}
		else if (e.getSource() == new1Back) {
			
			userSide.remove(carName);
			userSide.remove(carBrand);
			userSide.remove(carOwner);
			userSide.remove(carValue);
			userSide.remove(carAge);
			carName.setVisible(false);
			carBrand.setVisible(false);
			carOwner.setVisible(false);
			carValue.setVisible(false);
			carAge.setVisible(false);
			new1.setText("New");
			userSide.remove(save);
			userSide.remove(new1Back);
			userSide.add(new1);
			
		}
		else if (e.getSource() == musicBack) {
			
			userSide.remove(musicClass.pane);
			music.setText("Music");
			userSide.remove(musicBack);
			userSide.add(music);
			
		}
		
	}
	


	public static boolean isNumeric(String string) {
	    int intValue;
			
	    System.out.println(String.format("Parsing string: \"%s\"", string));
			
	    if(string == null || string.equals("")) {
	        System.out.println("String cannot be parsed, it is null or empty.");
	        return false;
	    }
	    
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	        System.out.println("Input String cannot be parsed to Integer.");
	    }
	    return false;

	}
	
	
	
}

	FoFrame frame = new FoFrame();


}

}
