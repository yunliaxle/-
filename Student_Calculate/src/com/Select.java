package com;
import java.awt.event.*;

//���ѡ��
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import javax.swing.*;
public class Select extends JFrame 
{
	public static final int DEFAULT_WIDTH = 700;
	public static final int DEFAULT_HEIGHT = 300;
	private JButton button1;
	private JButton button2;
	private JTextField field1;
	private JLabel label1;
	private JTextField field2;
	private JLabel label2;
	private JTextArea textArea1;
	private JLabel label3;
	String c2 ;
	String c1; 
	public Select(
			final ArrayList<String> integer,
			final ArrayList<String> fraction, final ArrayList<String> intAnswer,
			final ArrayList<String> fraAnswer, final BufferedWriter out,
			final int n,final String c1,final String c2)
	{ 
		setTitle("�����������"); 
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationByPlatform(true);//�����������ô���λ��
		label1 = new JLabel("ID:",JLabel.LEFT);
		Font font =new Font("����",Font.PLAIN,25);
		label1.setFont(font);
		label1.setBounds(200, 100, 150,45);
		add(label1);  
		field1 = new JTextField();
		field1.setColumns(20);
		field1.setBounds(275, 100, 200,45);
		add(field1);
		label2 = new JLabel("����:",JLabel.LEFT);
		label2.setFont(font);
		label2.setBounds(200, 200, 150,45);
		add(label2);
		field2 = new JTextField();
		field2.setColumns(20);
		field2.setBounds(275, 200, 200,40);
		add(field2);    
		button1 = new JButton("����");
		Font font1 = new Font("����",Font.PLAIN,25);
		button1.setFont(font1); 
		button1.setBorder(BorderFactory.createRaisedBevelBorder());
		button1.setBounds(150, 400, 100,40);
		add(button1);
		button2 = new JButton("����");
		button2.setFont(font1);
		button2.setBorder(BorderFactory.createRaisedBevelBorder());
		button2.setBounds(500, 400, 100,40);
		add(button2); 
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(null);
		button1.addActionListener(new ActionListener()
		{
			String id;
			String name;
			public  void actionPerformed(ActionEvent  event)
			{
				id= field1.getText();
				name = field2.getText();
				if(event.getSource()==button1)
				{
					setVisible(false); 
					int x=1;
					Test hh= new Test(integer,intAnswer,out,id,name,n);
					setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
				    hh.setVisible(true);
				    setLocationRelativeTo(null); 
				}
			}
		});	
		button2.addActionListener(new ActionListener()
		{
			public  String id;
			public String name;
			public  void actionPerformed(ActionEvent  event)
			{   
				id = field1.getText();
				name = field2.getText();
				if(event.getSource()==button2)
				{
					setVisible(false); 
					Test ss	= new Test(fraction,fraAnswer,out,id,name,n);
					setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
					ss.setVisible(true);
					setLocationRelativeTo(null);
				}
			}
		});	
	}
}