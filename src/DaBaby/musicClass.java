package DaBaby;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.Timer;

import javafx.application.Platform;
import javafx.scene.media.*;
import javafx.util.Duration;

public class musicClass {

	public static JButton playButton, pauseButton, resetButton, previousButton, nextButton;
	
	public static JPanel pane;
	public static JLabel songlabel;
	public static JComboBox<String> speedBox;
	public static JSlider volumeSlider;
	public static JProgressBar songProgressBar;
	
	public static Media media;
	public static MediaPlayer mediaPlayer;
	
	public static File directory;
	public static File[] files;
	
	public static ArrayList<File> songs;
	
	public static int songNumber;
	public static int[] speeds = {25, 50 , 75 , 100 , 125 , 150 , 175 , 200};
	
	public Timer timer;
	public static TimerTask task;
	public static boolean running;
	
		
		public void initialize() {
			
			Platform.startup(() -> {
				
				
				
			});
			
			songs = new ArrayList<File>();
			
			directory = new File("Music");
			
			files = directory.listFiles();
			
			if (files != null) {
				
				for (File file : files) {
					
					songs.add(file);
					
				}
				
			}
			
			media = new Media(songs.get(songNumber).toURI().toString());
			System.out.println(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songlabel = new JLabel();
			songlabel.setText(songs.get(songNumber).getName());
			
			mediaPlayer.setAutoPlay(true);

		}
	
	public static void musicPanelBuilder() {
		
		pane = new JPanel();
		pane.setBounds(425, 250, 350, 250);
		pane.setBackground(new Color(0, 0, 0, 80));
		pane.setOpaque(false);
		
		playButton = new JButton();
		playButton.setBounds(0, 0, 80, 40);
		playButton.setFocusable(false);
		playButton.setBackground(new Color(0, 0, 0, 80));
		playButton.setOpaque(false);
		playButton.setForeground(Color.white);
		playButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		playButton.setText("Play");
		playButton.addActionListener((e) -> {
			
			playMedia();
			
		});
		
		pauseButton = new JButton();
		pauseButton.setBounds(80, 0, 80, 40);
		pauseButton.setFocusable(false);
		pauseButton.setBackground(new Color(0, 0, 0, 80));
		pauseButton.setOpaque(false);
		pauseButton.setForeground(Color.white);
		pauseButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		pauseButton.setText("Pause");
		pauseButton.addActionListener((e) -> {
			
			stopMedia();
			
		});
		
		nextButton = new JButton();
		nextButton.setBounds(160, 0, 80, 40);
		nextButton.setFocusable(false);
		nextButton.setBackground(new Color(0, 0, 0, 80));
		nextButton.setOpaque(false);
		nextButton.setForeground(Color.white);
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		nextButton.setText("Next");
		nextButton.addActionListener((e) -> {
			
			nextMedia();
			
		});
		
		resetButton = new JButton();
		resetButton.setBounds(260, 0, 80, 40);
		resetButton.setFocusable(false);
		resetButton.setBackground(new Color(0, 0, 0, 80));
		resetButton.setOpaque(false);
		resetButton.setForeground(Color.white);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		resetButton.setText("Reset");
		resetButton.addActionListener((e) -> {
			
			resetMedia();
			
		});	
		
		previousButton = new JButton();
		previousButton.setBounds(0, 100, 80, 40);
		previousButton.setFocusable(false);
		previousButton.setBackground(new Color(0, 0, 0, 80));
		previousButton.setOpaque(false);
		previousButton.setForeground(Color.white);
		previousButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		previousButton.setText("Prev");
		previousButton.addActionListener((e) -> {
			
			previousMedia();
			
		});
		
		songlabel = new JLabel();
		songlabel.setBounds(80, 100, 350, 80);
		songlabel.setFocusable(false);
		songlabel.setEnabled(false);
		songlabel.setBackground(new Color(0, 0, 0, 80));
		songlabel.setOpaque(false);
		songlabel.setForeground(Color.white);
		songlabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		songlabel.setVisible(true);
		songlabel.setText(songs.get(songNumber).getName());
		
		pane.add(songlabel);
		pane.add(previousButton);
		pane.add(playButton);
		pane.add(nextButton);
		pane.add(pauseButton);
		pane.add(resetButton);
		
		
		
	}
	
	public static void playMedia() {
		
		if (media.getDuration() == media.getDuration()) {
			
			mediaPlayer.seek(Duration.seconds(0.0));
			mediaPlayer.play();
		}
		else {
			
			mediaPlayer.play();
			
		}
		
		
		
		}
	
	public static void resetMedia() {
		
		mediaPlayer.seek(Duration.seconds(0.0));
		playMedia();
		}

	public static void stopMedia() {
	
	mediaPlayer.stop();
	
		}

	public static void nextMedia() {
	
		if (songNumber < songs.size() - 1) {
		
			songNumber++;
			
			mediaPlayer.stop();
			
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songlabel.setText(songs.get(songNumber).getName());
	
		}
		else {
			
			songNumber = 0;
			
			mediaPlayer.stop();
			
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songlabel.setText(songs.get(songNumber).getName());
			
		}
		playMedia();
	}

	public static void previousMedia() {
	

		if (songNumber > (songs.size() - (songs.size() - 1))) {
		
			songNumber--;
			
			mediaPlayer.stop();
			
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songlabel.setText(songs.get(songNumber).getName());
	
		}
		else {
			
			songNumber = songs.size()-1;
			
			mediaPlayer.stop();
			
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songlabel.setText(songs.get(songNumber).getName());
			
		}
		playMedia();
	
		}

	public static void changeSpeedMedia() {
	
	
	
		}
	
	public static void beginTimer() {
		
		
		
		}

	public static void cancelTimer() {
	
	
	
	}
	
	
}
