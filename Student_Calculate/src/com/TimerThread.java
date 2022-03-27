package com;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//计时器
public class TimerThread extends JFrame implements Runnable
{
	 private JFrame frame;
	 private JPanel timePanel;
	 private JLabel timeLabel;
	 private JLabel displayArea;
	 private String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	 private int ONE_SECOND = 1000;
	 int time = 1;	boolean isRun = true; 
	 public TimerThread() 
	 {
		 timePanel = new JPanel();
		 timeLabel = new JLabel("您本次用时：");
		 displayArea = new JLabel();
		 timePanel.add(timeLabel);
		 timePanel.add(displayArea);
		 this.add(timePanel);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setBounds(800, 100, 200, 80);
	 }
	 public void run()
	 {
		 while(isRun)
		 {	
			 try {
				 displayArea.setText(+time+"s");
				 time++;
				 Thread.sleep(1000);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		 }
	 }
}