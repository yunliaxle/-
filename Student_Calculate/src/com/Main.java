package com;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.zip.*;
import java.util.ArrayList;
import javax.swing.*;
public class Main 
{ 
	static int n=1;
	final static ArrayList<String> integer = new ArrayList<String>();
	final static ArrayList<String> IntAnswer = new ArrayList<String>();
	final static ArrayList<String> fraction = new ArrayList<String>();
	final static ArrayList<String> FraAnswer = new ArrayList<String>();
	public static void main(String[] args)throws IOException
	{
		int i,result; 
		File writename = new File("result.txt"); // 相对路径，如果没有则要建立一个新的result.txt文件
		writename.createNewFile(); // 创建新文件
		calculate cal = new calculate();
        final BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        int value;
        for(i=0;i<20;i++) 
        {
            int num1=(int)(Math.random()*100);//随机生成一个0-100的整数
            int num2=(int)(Math.random()*100);
            int num3=(int)(Math.random()*100);
            int num4=(int)(Math.random()*100);
            int numn=1;
            switch(numn)
            {
               
               case 1:
            	   String s=cal.fournum(num1,num2,num3,num4);
            	   value = cal.jisuan(s);
            	   if(value==-1)
            		   i--;
            	   else
            	   {
            		   out.write(s+value+"\r\n");  
            		   integer.add(s);
            		   IntAnswer.add(value+"");
            	   }
            	   break;
              
            }
        }
        int num1,num2,num3;
        for(i=0;i<20;i++)
        {
        	num1=1+(int)(Math.random()*10);//随机生成一个0-100的整数
            num2=1+(int)(Math.random()*10);
            num3=1+(int)(Math.random()*10);
            int M,Z;
            int x1,x2,x3;
            x1=1+(int)(Math.random()*num1);//生成一个比分母num1小的分子，实现真分数
            x2=1+(int)(Math.random()*num2);
            x3=1+(int)(Math.random()*num3);
            Z=x1*num2*num3+x2*num1*num3+x3*num1*num2;
            M=num1*num2*num3;
            String d=cal.simplification(Z,M);
            String s=x1+"/"+num1+"+"+x2+"/"+num2+"+"+x3+"/"+num3+"=";
            fraction.add(s);
            FraAnswer.add(d);
        }
        out.flush();
        
        EventQueue.invokeLater(new Runnable()
        {
        	String c1;
        	String c2;
        	public void run()
        	{
        		Select frame = new Select(integer,fraction,IntAnswer,FraAnswer,out,n,c1,c2);
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.getContentPane().setBackground(Color.pink);
        		frame.setTitle("欢迎使用四则运算练习");
        		frame.setVisible(true);
        		frame.setResizable(true);
        		frame.setBounds(200, 200, 800, 800);
        		frame.setLocationRelativeTo(null);//使窗口显示 在中央 
        	}
        });
	}
}