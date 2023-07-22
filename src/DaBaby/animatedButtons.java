package DaBaby;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class animatedButtons extends JButton{

	private static Animator animator;
	private static int targetSize;
	private static float animatSize;
	private static Point pressedPoint;
	private static float alpha;
	private static int borderSize = 6;;
	
	 int pos1;
	 int pos2;
	 int x;
	 int y;
	String name;
	
	public animatedButtons(String name, int pos1, int pos2, int x, int y) {

		this.name = name;
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.x = x;
		this.y = y;
		
		this.setBounds(pos1, pos2, x, y);
		this.setFont(new Font("Tahoma", Font.BOLD, 25));
		this.setText(name);
		this.setBackground(new Color(0, 0, 0, 80));
		this.setForeground(Color.white);
		this.setFocusable(false);
		this.setOpaque(false);
		this.setBorder(null);
		this.setVisible(true);
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent me) {
				
				targetSize = Math.max(x, y)*2;
				pressedPoint = me.getPoint();
				alpha = 0.5f;
				
				if (animator.isRunning()) {
					
					animator.stop();
					
				}
				animator.start();
			}
			
			@Override
			public void mouseReleased(MouseEvent me) {
				
			
				
				
			}
			
		});
		
		TimingTarget target = new TimingTargetAdapter() {
			
			@Override
			public void timingEvent(float fraction) {
				
				if (fraction > 0.5f) {
					
					alpha = 1 - fraction;
					
				}
				animatSize = fraction * targetSize;
				repaint();
			}
			
		};
		
				
		animator = new Animator(800, target);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		BufferedImage img = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = img.createGraphics();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		float f[] = new float[] {0f, 0.5f, 1f};
		Color colors[] = new Color[] {new Color(0, 154, 254), new Color(254, 50, 0), new Color(84, 38, 255)};
		LinearGradientPaint gra = new LinearGradientPaint(0, 0, x, y, f, colors, MultipleGradientPaint.CycleMethod.REFLECT);
		
		
		Shape out = new Rectangle(0, 0, x, y);
		Shape in = new Rectangle(borderSize, borderSize, x - borderSize*2, y - borderSize*2);
		Area area = new Area(out);
		area.subtract(new Area(in));
		g2D.setPaint(gra);
		g2D.fill(area);
		g2D.setFont(new Font("Tahoma", Font.BOLD, 25));
		g2D.drawString(name, x-(x-borderSize*2), (int) (y/2+(borderSize*1.5)));
		
		if (pressedPoint != null) {
			
			g2D.setColor(Color.white);
			g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g2D.fillOval((int)(pressedPoint.x-animatSize/2), (int)(pressedPoint.y-animatSize/2), (int)animatSize, (int)animatSize);
			
			
		}
		
		g2D.dispose();
		g.drawImage(img, 0, 0, null);
	
	}
	
}
