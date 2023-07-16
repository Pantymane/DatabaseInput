package DaBaby;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	JButton save = new JButton("Save");
	JButton new1 = new JButton("New");
	JButton delete = new JButton("Delete");
	JButton exit = new JButton("Exit");
	JButton load = new JButton("Load");
	 static JTable tablex;
	 static String[] columns = new String[] {"ID","Name","Brand","Owner","Value","Age"};
	 static JScrollPane scrollPane = new JScrollPane();
	 static DefaultTableModel model = new DefaultTableModel(null ,columns);
	 static JCheckBox chckBox = new JCheckBox("");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JTextField text = new JTextField();
	JTextField carName;
	JTextField carBrand;
	JTextField carOwner;
	JTextField carValue;
	JTextField carAge;
	JFrame newFrame;
	
	Random r = new Random();
	Timer timer;
	
	public FoFrame() {
		
		this.setTitle("Car information");
		this.setSize(728,420);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setFocusable(false);
		getContentPane().setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				Object[] kerdes = {"Igen","Nem"};
				
				int valasz = JOptionPane.showOptionDialog(rootPane, "Bisztosan ki akar lépni?", "Kilépés", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kerdes, kerdes[0]);
				if (valasz == 0) {
					
					System.exit(0);
					
				}
			}
			
		});
		
		delete.setBounds(593,234,99,40);
		delete.setBorder(null);
		delete.setFocusable(false);
		delete.setFont(new Font("Ink Free",Font.BOLD,30));
		delete.setBackground(new Color(r.nextInt(1,255),r.nextInt(1,255),r.nextInt(1,255)));
		delete.setOpaque(true);
		delete.addActionListener(this);
		
		load.setBounds(503, 234, 80, 40);
		load.setBorder(null);
		load.setFocusable(false);
		load.setFont(new Font("Ink Free",Font.BOLD,30));
		load.setBackground(new Color(r.nextInt(1,255),r.nextInt(1,255),r.nextInt(1,255)));
		load.setOpaque(true);
		load.addActionListener(this);
		
		exit.setBounds(612,326,80,40);
		exit.setBorder(null);
		exit.setFocusable(false);
		exit.setFont(new Font("Ink Free",Font.BOLD,30));
		exit.setBackground(new Color(r.nextInt(1,255),r.nextInt(1,255),r.nextInt(1,255)));
		exit.setOpaque(true);
		exit.addActionListener(this);
		
		save.setBounds(310, 220, 60, 30);
		save.setBorder(null);
		save.setFocusable(false);
		save.setFont(new Font("Ink Free",Font.BOLD,25));
		save.setBackground(new Color(r.nextInt(1,255),r.nextInt(1,255),r.nextInt(1,255)));
		save.setOpaque(true);
		save.addActionListener(this);
		
		new1.setBounds(22, 235, 67, 39);
		new1.setBorder(null);
		new1.setFocusable(false);
		new1.setFont(new Font("Ink Free",Font.BOLD,30));
		new1.setBackground(new Color(r.nextInt(1,255),r.nextInt(1,255),r.nextInt(1,255)));
		new1.setOpaque(true);
		new1.addActionListener(this);
		panel.setToolTipText("Car ID:");
	
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setLocation(10, 326);
		panel.setSize(249, 46);
		panel.setLayout(null);
		
		label.setEnabled(true);
		
		getContentPane().add(new1);
		getContentPane().add(panel);
		text.setBounds(22, 21, 173, 20);
		text.setEditable(false);
		panel.add(text);
		
		chckBox.setBounds(210, 18, 21, 23);
		chckBox.addActionListener(this);
		
		panel.add(chckBox);
		getContentPane().add(label);
		getContentPane().add(exit);
		getContentPane().add(delete);
		getContentPane().add(load);
		
		scrollPane.setBounds(22, 11, 682, 213);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(tablex);
		this.setVisible(true);
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exit) {
			
			Object[] kerdes = {"Igen","Nem"};
			
			int valasz = JOptionPane.showOptionDialog(rootPane, "Bisztosan ki akar lépni?", "Kilépés", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kerdes, kerdes[0]);
			if (valasz == 0) {
				
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
			
			newFrame.getContentPane().add(carName);
			newFrame.getContentPane().add(carBrand);
			newFrame.getContentPane().add(carOwner);
			newFrame.getContentPane().add(carValue);
			newFrame.getContentPane().add(carAge);
			newFrame.getContentPane().add(save);
			newFrame.setVisible(true);
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
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			else {
				
				try {
					
					model.addRow(DataBase.search(text.getText()));
					tablex.setModel(model);
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
}
