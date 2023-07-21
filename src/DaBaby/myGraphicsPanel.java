package DaBaby;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
	
	public class myGraphicsPanel extends JLayeredPane implements ActionListener,Runnable{

			static Timer timer = new Timer(0, null);
			Image frame;
			static int whatFrame = 1;
			static myGraphicsPanel myGPanel;
			static boolean firstRound = true;
			
			myGraphicsPanel() {
				
				this.setPreferredSize(new Dimension(threadClass.x, threadClass.y));
				this.setLayout(null);
				this.setVisible(true);
					
					timer.addActionListener(this);
					timer.start();
					
				
			}
			
			public void paint(Graphics g) {
				
				if (whatFrame == 36) {
					
					whatFrame = 1;
					
				}
				
				
				Graphics2D g2D = (Graphics2D) g;
				
					String actualFrame = "Graphics Frames//frame_"+whatFrame+".gif";
				
					frame = new ImageIcon(actualFrame).getImage();
					
					g2D.drawImage(frame, 0, 0, null);
					
					
					whatFrame++;
				
					/*System.out.println("még fut");
					System.out.println(whatFrame);
					System.out.println(actualFrame);*/
			}
			
			

			@Override
			public void actionPerformed(ActionEvent e) {

				if (firstRound == true && whatFrame == 36) {
					timer.setDelay(60);
					//timer.setDelay(60);
					
					firstRound = false;
				}
				
				if (e.getSource() == timer) {
					
					if (whatFrame == 36) {
						
						whatFrame = 1;
						
					}
				
				repaint();
				}
				
				
			}

			@Override
			public void run() {
				
				
			}
		
	}

	
	
	
	

