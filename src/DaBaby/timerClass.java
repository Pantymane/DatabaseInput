package DaBaby;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class timerClass implements Runnable, ActionListener{

	Timer timer = new Timer(500, this);
	Random r = new Random();
	
	@Override
	public void run() {
		
		timer.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FoFrame.new1.setBorderPainted(true);
		FoFrame.new1.setBorder(new LineBorder(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)), 3, false));
		
		FoFrame.save.setBorderPainted(true);
		FoFrame.save.setBorder(new LineBorder(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)), 3, false));
		
		FoFrame.load.setBorderPainted(true);
		FoFrame.load.setBorder(new LineBorder(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)), 3, false));
		
		FoFrame.delete.setBorderPainted(true);
		FoFrame.delete.setBorder(new LineBorder(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)), 3, false));
		
		FoFrame.exit.setBorderPainted(true);
		FoFrame.exit.setBorder(new LineBorder(new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255)), 3, false));
		
	}

}
