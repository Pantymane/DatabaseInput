package DaBaby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;

public class FoFrame extends JFrame implements ActionListener{

	static JButton save = new JButton("Save");
	static JButton new1 = new JButton("New");
	static JButton delete = new JButton("Delete");
	static JButton exit = new JButton("Exit");
	static JButton load = new JButton("Load");
	 static JTable tablex;
	 static String[] columns = new String[] {"ID","Name","Brand","Owner","Value","Age"};
	 static JScrollPane scrollPane = new JScrollPane();
	 static DefaultTableModel model = new DefaultTableModel(null ,columns);
	 static JCheckBox chckBox = new JCheckBox("");
	 static myGraphicsPanel graphicsPanel;
	 static JLayeredPane userSide = new JLayeredPane();
	static JPanel panel = new JPanel();
	JTextField text = new JTextField();
	JTextField carName;
	JTextField carBrand;
	JTextField carOwner;
	JTextField carValue;
	JTextField carAge;
	JFrame newFrame;

	Timer timer;
	
	public FoFrame() {
		
		this.setTitle("Car information");
		this.setSize(1200,675);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.white);
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
		delete.setBounds(1050, 234, 100, 40);
		delete.setBorder(null);
		delete.setFocusable(false);
		delete.setFont(new Font("Tahoma",Font.BOLD,25));
		delete.setForeground(Color.WHITE);
		delete.setBackground(new Color(0, 0, 0, 80));
		delete.setOpaque(false);
		delete.addActionListener(this);
		
		load.setBounds(950, 234, 80, 40);
		load.setBorder(null);
		load.setFocusable(false);
		load.setFont(new Font("Tahoma",Font.BOLD,25));
		load.setForeground(Color.WHITE);
		load.setBackground(new Color(0, 0, 0, 80));
		load.setOpaque(false);
		load.addActionListener(this);
		
		exit.setBounds(1050, 550, 80, 40);
		exit.setBorder(null);
		exit.setFocusable(false);
		exit.setFont(new Font("Tahoma",Font.BOLD,25));
		exit.setForeground(Color.WHITE);
		exit.setForeground(Color.WHITE);
		exit.setBackground(new Color(0, 0, 0, 80));
		exit.setOpaque(false);
		exit.addActionListener(this);
		
		save.setBounds(290, 210, 80, 40);
		save.setBorder(null);
		save.setFocusable(false);
		save.setFont(new Font("Tahoma",Font.BOLD,25));
		save.setForeground(Color.WHITE);
		save.setBackground(new Color(0, 0, 0, 80));
		save.setOpaque(true);
		save.addActionListener(this);
		
		new1.setBounds(22, 450, 67, 39);
		new1.setBorder(null);
		new1.setFocusable(false);
		new1.setFont(new Font("Tahoma",Font.BOLD,25));
		new1.setForeground(Color.WHITE);
		new1.setBackground(new Color(0, 0, 0, 80));
		new1.setOpaque(false);
		new1.addActionListener(this);
		
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
		userSide.setPreferredSize(new Dimension(1200, 675));
		userSide.setLayout(null);
		userSide.setBackground(new Color(0, 0, 0, 80));
		//userSide.settr
		userSide.setVisible(true);
		
		graphicsPanel = new myGraphicsPanel();
		Thread thread2 = new Thread(graphicsPanel);
		thread2.setPriority(1);
		thread2.start();
		
		graphicsPanel.setBounds(0, 0, 1186, 638);
		userSide.add(FoFrame.new1);
		userSide.add(FoFrame.delete);
		userSide.add(FoFrame.load);
		userSide.add(FoFrame.exit);
		userSide.add(FoFrame.scrollPane);
		userSide.add(FoFrame.panel);
		getContentPane().setLayout(null);
		getContentPane().add(userSide);
		getContentPane().add(graphicsPanel);
		//this.setLayeredPane(userSide);
		
		
		this.setVisible(true);
		
		colorChange();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exit) {
			
			Object[] kerdes = {"Igen","Nem"};
			
			int valasz = JOptionPane.showOptionDialog(rootPane, "Bisztosan ki akar lépni?", "Kilépés", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kerdes, kerdes[0]);
			if (valasz == 0) {
				
				new loggerClass().logger.log(Level.INFO, "Kilépés a programból.");
				System.exit(0);
				
			}
			
		}
		else if (e.getSource() == new1) {
			
			newFrame = new JFrame("New Car");
			
			newFrame.setLocationRelativeTo(this);
			newFrame.setSize(400,300);
			newFrame.getContentPane().setLayout(null);
			
			carName = new JTextField("Car Name");
			carName.setBounds(20, 20, 200, 30);
			
			carBrand = new JTextField("Car Brand");
			carBrand.setBounds(20, 70, 200, 30);
			
			carOwner = new JTextField("Car Owner");
			carOwner.setBounds(20, 120, 200, 30);
			
			carValue = new JTextField("Car Value");
			carValue.setBounds(20, 170, 200, 30);
			
			carAge = new JTextField("Car Age");
			carAge.setBounds(20, 220, 200, 30);
			
			userSide.add(carName);
			userSide.add(carBrand);
			userSide.add(carOwner);
			userSide.add(carValue);
			userSide.add(carAge);
			userSide.add(save);
		
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
				System.out.println("olvas");
				DataBase.CarBeolvasas();
				tablex.setBackground(new Color(0, 0, 0, 80));
				tablex.setForeground(Color.WHITE);
				tablex.setOpaque(false);
				this.add(graphicsPanel);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			else {
				
				try {
					
					model.addRow(DataBase.search(text.getText()));
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
	
	public static void beolvas(String[] row) {
		
		
			model.addRow(row);
			
			
		tablex = new JTable(model);
		scrollPane.setViewportView(tablex);
		
	}
	
	public static void colorChange() {
		
		new timerClass().run();
		
	}
	
}
