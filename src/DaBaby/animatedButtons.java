package DaBaby;

import java.awt.AlphaComposite;
import java.awt.Color;
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
	
	public animatedButtons() {

		this.setBounds(550, 400, 100, 50);
		this.setFocusable(false);
		this.setOpaque(false);
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent me) {
				
				targetSize = Math.max(67, 39)*2;
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
					
					alpha = 1- fraction;
					
				}
				animatSize = fraction * targetSize;
				repaint();
			}
			
		};
		
				
		animator = new Animator(800, target);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		int width = 67;
		int height = 39;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = img.createGraphics();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		float f[] = new float[] {0f, 0.5f, 1f};
		Color colors[] = new Color[] {new Color(0, 154, 254), new Color(254, 50, 0), new Color(84, 38, 255)};
		LinearGradientPaint gra = new LinearGradientPaint(0, 0, width, height, f, colors, MultipleGradientPaint.CycleMethod.REFLECT);
		
		
		Shape out = new Rectangle(0, 0, width, height);
		Shape in = new Rectangle(2, 2, height - 2*2, width - 2*2);
		Area area = new Area(out);
		area.subtract(new Area(in));
		g2D.setPaint(gra);
		g2D.fill(area);
		
		if (pressedPoint != null) {
			
			g2D.setColor(Color.white);
			g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g2D.fillOval((int)(pressedPoint.x-animatSize/2), (int)(pressedPoint.y-animatSize/2), (int)animatSize, (int)animatSize);
			
			
		}
		
		g2D.dispose();
		g.drawImage(img, 0, 0, null);
	
	}
	
}
