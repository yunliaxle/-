package com;
/*
 * this is grade summary 
 */
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
public class Summary extends JFrame
{
	static ArrayList<String>  Grade = new ArrayList<String>();
	static ArrayList<String> integer1 = new ArrayList<String>();
 	static ArrayList<String> IntAnswer1 = new ArrayList<String>();
 	static ArrayList<String> fraction1 = new ArrayList<String>();
 	static ArrayList<String> FraAnswer1 = new ArrayList<String>();
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;
	private JButton button1;
	private JButton button2; 
	private JLabel label1;
	private JTextArea textArea1;
	calculate cal = new calculate();
	int j=-1;
	public  Summary(int grade,final ArrayList<String> Calculate,final ArrayList<String> Answer,
			final BufferedWriter out,int[] Error,final int n,final String c11,final String c22)
	{
		Grade.add(0+"");
		Grade.add(grade+""); 
		setTitle("�÷����");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationByPlatform(true);//�����������ô���λ�� 
		label1 = new JLabel("�����" +grade+"�� �� ��ȷ������:",JLabel.LEFT);
		Font font = new Font("����",Font.PLAIN,20);
		label1.setFont(font); 
		label1.setBounds(200, 50, 300,45); 
		add(label1);
		button1 = new JButton("����һ��");
		button1.setFont(font); 
		button1.setBorder(BorderFactory.createRaisedBevelBorder()); //���ð�ť��ʽ
		button1.setBounds(800, 200, 100,40);
		add(button1);
		button2 = new JButton("�ܽ�");
		button2.setFont(font); 
		button2.setBorder(BorderFactory.createRaisedBevelBorder());
		button2.setBounds(800, 400, 100,40);
		add(button2);
		textArea1 = new JTextArea();
	    textArea1.setColumns(21);
	    textArea1.setRows(21);
	    textArea1.setBounds(200, 100, 400,400);
	    add(textArea1);
	    int i =0;
	    for(i=0;i<20;i++)
	    {
	    	if((Error[i])!=-1)
	    	{ 
	    		textArea1.append("��"+(Error[i]+1)+"���⣺"+Calculate.get(Error[i])+Answer.get(Error[i])+"\n");
	    		
	    	}
	    }
	    JPanel pan = new JPanel();
	    add(pan);
	    button1.addActionListener(new ActionListener()
		{
	    	public  void actionPerformed(ActionEvent  event)
			{
	    		ArrayList<String>  Grade = new ArrayList<String>();
				ArrayList<String> integer1 = new ArrayList<String>();
			 	ArrayList<String> IntAnswer1 = new ArrayList<String>();
			 	ArrayList<String> fraction1 = new ArrayList<String>();
			 	ArrayList<String> FraAnswer1 = new ArrayList<String>();
		    	int i,result;
		    	int value;
		        for(i=0;i<20;i++)
		        {
		        	int num1=(int)(Math.random()*100);//�������һ��0-100������
		            int num2=(int)(Math.random()*100);
		            int num3=(int)(Math.random()*100);
		            int num4=(int)(Math.random()*100);
		            int numn=1;
		            switch(numn)
		            {
		               
		               case 1:
		            	   String s=cal.fournum(num1,num2,num3,num4);
		            	   //System.out.println(s);
		           	       value = cal.jisuan(s);
		           	       if(value==-1)
		           	    	   i--;
		           	       else
		           	       {
		           	    	   try {
		           	    		   out.write(s+value+"\r\n");
		           	    	   } catch (IOException e) {
		           	    		   // TODO Auto-generated catch block
		           	    		   e.printStackTrace();
		           	    	   }   
		           	    	   integer1.add(s);
		           	    	   IntAnswer1.add(value+"");
		           	       }
		           	       break;
		              
		            }
		        }
		        int num1,num2,num3;
	            for(i=0;i<20;i++)
	            {
	            	num1=1+(int)(Math.random()*10);//�������һ��0-100������
	            	num2=1+(int)(Math.random()*10);
	            	num3=1+(int)(Math.random()*10);
	            	int M,Z;
	            	int x1,x2,x3;
	            	x1=1+(int)(Math.random()*num1);//����һ���ȷ�ĸnum1С�ķ��ӣ�ʵ�������
	            	x2=1+(int)(Math.random()*num2);
	            	x3=1+(int)(Math.random()*num3);
	            	Z=x1*num2*num3+x2*num1*num3+x3*num1*num2;
	            	M=num1*num2*num3;
	            	String d=cal.simplification(Z,M);
	            	String s=x1+"/"+num1+"+"+x2+"/"+num2+"+"+x3+"/"+num3+"=";
	            	fraction1.add(s);
	            	FraAnswer1.add(d);
	            }
	            try {
	            	out.flush();
	            } catch (IOException e) {
	            	// TODO Auto-generated catch block
	            	e.printStackTrace();
	            }
	            setVisible(false); 
	            Select frame = new Select(integer1,fraction1,IntAnswer1,FraAnswer1,out,n,c11,c22);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setVisible(true);
	            frame.setBounds(200, 200, 800, 800);
	            frame.setResizable(false);//���ڵĴ�С ���ɱ� 
	            frame.setLocationRelativeTo(null);//ʹ������ʾ ������ 
			}
	    
		});
	    button2.addActionListener(new ActionListener()
	    {
	    	public  void actionPerformed(ActionEvent  event)
	    	{
	    		if(event.getSource()==button2)
	    		{  
	    			setVisible(false);  
	    			Histogram SS = new Histogram(Grade);
	    			JFrame jf=new JFrame();
	    			jf.setTitle("��̬��״ͼ");
	    			jf.add(SS); 
	    			jf.setVisible(true);
	    			int len = Grade.size();
	    			jf.setSize( 30*len+50,700);
	    			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    			jf.setResizable(false);
	    		}
	    	}
	    });	
	}
}