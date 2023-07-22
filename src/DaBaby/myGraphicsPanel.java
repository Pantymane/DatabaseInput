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
			static int time = 1;
			static int ney = 0;
			
			myGraphicsPanel() {
				
				this.setPreferredSize(new Dimension(threadClass.x, threadClass.y));
				this.setLayout(null);
				this.setVisible(true);
					
					timer.addActionListener(this);
					timer.start();
					
				
			}
			@Override
			public void paint(Graphics g) {
				
				Graphics2D g2D = (Graphics2D) g;
				
					String actualFrame = "Graphics Frames//frame_"+whatFrame+".gif";
				
					frame = new ImageIcon(actualFrame).getImage();
					
					g2D.drawImage(frame, 0, 0, null);
				
					/*System.out.println("még fut");
					System.out.println(whatFrame);
					System.out.println(actualFrame);*/
				
				
			}
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(firstRound);
				/*System.out.println("\n**************");
				System.out.println(time);
				System.out.println(whatFrame);*/
				
				if (e.getSource() == timer) {
					if (ney < 100) {
						
						ney++;
			
						
					}
					
				if (firstRound == true && whatFrame == 36) {
					timer.setDelay(10);
					//timer.setDelay(60);
					
					firstRound = false;
					
					new musicClass().initialize();
					musicClass.playMedia();
				}
				
				if (whatFrame == 36) {
					
					whatFrame = 1;
					
				}
		
					if (firstRound == false && time > 6) {
						
							time = 1;
						
					}
					else if (firstRound == false && time == 6) {
						
						whatFrame++;
						
					}
					else if (firstRound == true) {
						
						whatFrame++;
						
					}
					
					if (firstRound == false && time == 6) {
					
						repaint();
						
					}
					else if (firstRound == true) {
						
						repaint();
						
					}
					
				if (firstRound == false ) {
				
				time++;
				
				}
				
				if (firstRound == false) {
					
					int fullTime = (int) musicClass.media.getDuration().toSeconds();
					int playTime = (int) musicClass.mediaPlayer.getCurrentTime().toSeconds();
					
					if (fullTime == playTime && fullTime >= 50) {
						
						
						musicClass.nextMedia();
					}
					}
				
				}
				
				
				
			}

			@Override
			public void run() {
				
				
			}
		
	}

	
	
	
	

