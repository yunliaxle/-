package com;
import java.io.BufferedWriter;
//���������Ŀ
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class calculate 
{
	public static String s= new String();
	public static int n;
	//��ʽ����
    public static String simplification(int a,int b)
    {
        int y = 1;
        for(int i=a;i>=1;i--)
        {
            if(a%i==0&&b%i==0)
            {
                y = i;
                break;
            }
        } 
        int z = a/y; 
        int m = b/y;
        if(z==0)  
            return "0";
        if(m==1)
        	return ""+z;
        return z+"/"+m;
    }     
    //��������Ӽ��˳����ַ�
    public static String Operator(int a)
    {
    	if(a==0)
    		return "+";
    	if(a==1)
    		return "-";
    	if(a==2)
    		return "*";
    	if(a==3)
    		return "/";
    	return "";
    }
  
    
    //����������ʽ�Ĳ���������
    public static String fournum(int num1,int num2,int num3,int num4)
    {
    	String s1= new String();
    	int operator1=(int)(Math.random()*4);//�������һ��0-3��������0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
        int operator2=(int)(Math.random()*4);
        int operator3=(int)(Math.random()*4);
        if(operator1==operator2)
        	operator2=(operator1+1)%3;//��֤�������������ͬ��
        if(operator2==operator3)
        	operator3=(operator2+1)%3;
        //����Ĺ���Ϊ�ų����������ģ����з�ĸΪ0��
        if(operator1==3)
        {
        	if(num2==0)
        		num2=1+(int)(Math.random()*100);
        	while(num1%num2!=0)
        	{
        		num1=(int)(Math.random()*100);
        	}
        }
        if(operator2==3)
        {
        	if(num3==0)
        		num3=1+(int)(Math.random()*100);
        	while(num2%num3!=0)
        	{
        		num2=(int)(Math.random()*100);
        	}
        }
        if(operator3==3)
        {
        	if(num4==0)
        		num4=1+(int)(Math.random()*100);
        	while(num3%num4!=0)
        	{
        		num3=(int)(Math.random()*100);
        	}
        }
        s1= num1+Operator(operator1)+num2+Operator(operator2)+num3+Operator(operator3)+num4+"=";
        return s1;
    }
   
   

//�����沨���ķ����ų�����ʽ��Ϊ������������������ʽ�Ľ��
    public static int jisuan(String s)
    {	
    	Stack<Integer> stack1 = new Stack<Integer>();//����
    	Stack<String> stack2 = new Stack<String>();//������
    	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();//�����������ȼ�
    	hashmap.put("(", 0);
    	hashmap.put("+", 1);
    	hashmap.put("-", 1);
    	hashmap.put("*", 2);
    	hashmap.put("/", 2);
    	for (int i = 0; i < s.length();) 
    	{
    		StringBuffer digit = new StringBuffer();  //StringBuffer���еķ�����Ҫƫ���ڶ����ַ����ı仯��
    		
    		//����׷�ӡ������ɾ���ȣ����Ҳ��StringBuffer��String�����Ҫ����
    		char c = s.charAt(i);//��ʽ���ַ����и�Ϊc�ַ�
    		while (Character.isDigit(c)) 
    		{
    			//�ж��ַ��Ƿ�Ϊ10��������,��һ��������digit
    			digit.append(c);
    			i++;
    			c = s.charAt(i);
    		}
    		if (digit.length() == 0) 
    		{  
    			//��ǰdigit�����Ѿ������֣�����ǰ��������
    			switch (c)
    			{
    			case '(': 
    			{
    				stack2.push(String.valueOf(c));//����ǣ�   ת��Ϊ�ַ���ѹ���ַ�ջ
    				break;
    			}
    			case ')': 
    			{
    				//�����������˼��㣬��Ϊ�������ȼ����
    				String stmp = stack2.pop();  //����ǣ���������ջջ��Ԫ��ȡ��
    				while (!stack2.isEmpty() && !stmp.equals("(")) 
    				{ 
    					//��ǰ����ջ���滹��+ - * /
    					int a = stack1.pop(); 
    					int b = stack1.pop();
    					int sresulat = calculate(b, a, stmp);//����
    					if(sresulat<0)
    						return  -1;
    					stack1.push(sresulat);//�����ѹ��ջ
    					stmp = stack2.pop();//����ָ����һ���������
    				}
    				break;
    			}
    			case '=': 
    			{
    				//�����Ⱥ��˼��㣬
    				String stmp;
    				while (!stack2.isEmpty()) 
    				{
    					//��ǰ����ջ���滹��+ - * /,����û������
    					stmp = stack2.pop();
    					int a = stack1.pop();
    					int b = stack1.pop();
    					int sresulat = calculate(b, a, stmp);
    					if(sresulat<0)
    						return  -1;
    					stack1.push(sresulat);
    				}
    				break;
    			}
    			default: 
    			{  
    				String stmp;
    				while (!stack2.isEmpty()) 
    				{ 
    					//�������ջ�з���
    					stmp = stack2.pop(); //��ǰ����ջ��ջ��Ԫ��
    					if (hashmap.get(stmp) >= hashmap.get(String.valueOf(c))) {
    						//�Ƚ����ȼ�
    						int a = stack1.pop();
    						int b = stack1.pop();
    						int sresulat =calculate (b, a, stmp);
    						if(sresulat<0)
    							return  -1;
    						stack1.push(sresulat);
    					} 
    					else 
    					{
    						stack2.push(stmp);
    						break;
    					}
    				}
    				stack2.push(String.valueOf(c));  //������ѹ�����ջ
    				break;
    			}
    			}
    		} 
    		else 
    		{
    			//�������֣�ֱ��ѹջ
    			stack1.push(Integer.valueOf(digit.toString()));
    			continue;
    		}
    		i++;
    	}
    	return stack1.peek();  //����ջ�����ּ���ʽ�Ĵ𰸡�
    }
    public static int calculate(int a, int b, String stmp) 
    {
    	int res = 0;//����
    	char s = stmp.charAt(0);
    	switch (s)
    	{
    	case '+': 
    	{
    		res = a + b;
    		break;
    	}
    	case '-': 
    	{
    		res = a - b;
    		break;
    	}
    	case '*':
    	{
    		res = a * b;
    		break;
    	}
    	case '/': 
    	{
    		if(b==0)
    			return -1;
    		else
    			res = a / b;
    		break;
    	}
    	}
    	return res;
    }
}