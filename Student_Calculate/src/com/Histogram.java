package com;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
public class Histogram extends JPanel 
{
	private int x;
	private static int length ; 
	int i=0;
	public int[] count;
	ArrayList<JLabel> label = new ArrayList<JLabel>();
	public Histogram(final ArrayList<String> summer) 
	{
		length = summer.size();
		count = new int[length];
		System.out.print(length);
		this.setLayout(null); 
		for(int i=0;i<summer.size();i++) 
		{
			count[i] = Integer.parseInt(summer.get(i));	
		}
		for(int i=1;i<summer.size();i=i+2) 
		{ 
			JLabel  Label = new JLabel("µÚ"+((i+1)/2)+"ÂÖ",JLabel.LEFT);
			Font font1=new Font("ËÎÌå", Font.BOLD + Font.ITALIC, 18);
			Label.setFont(font1);
			Label.setBounds(30+(i-1)*30, 610, 60,50);
			JLabel  Label2 = new JLabel(count[i]+"",JLabel.CENTER);
			Label2.setFont(font1);
			Label2.setBounds(25+(i-1)*30, 555-6*count[i], 60,50);
			label.add(Label);
			label.add(Label2);
			this.add(label.get(i-1));
			this.add(label.get(i));  
		}
	} 
 	protected void paintComponent(Graphics g) 
 	{
 		int x=10;
	 	g.setColor(Color.red);
	 	for (int i = 0; i < count.length; i++) 
	 	{   
	 		g.fillRect(x, 600-6*count[i], 30,6*count[i] );
	 		x += 30; 
	 	}
 	}
}