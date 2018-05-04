/**
 * 
 */
package kk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


/**
 * @ClassName: SymbolChange
 * @Function:中缀表达式转换后缀
 * @author:Java青铜战士
 * @Time:2018年4月11日下午11:47:28
 */
public class ss {	
	Map beforemap =
            new HashMap();
	Map<String, Integer> lastmap =
            new HashMap<String, Integer>();
	
	String str1="{";
	Stack s=new Stack();
	Scanner in=new Scanner(System.in);
	String str=in.next();
	for(int i=0;i<str.length();i++){
		if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
			System.out.println(str.charAt(i));
			 continue;
		}
		if(s.isEmpty()){
			s.push(str.charAt(i));
		}else if(str.charAt(i)=='('){
			s.push('(');
		}else if(str.charAt(i)==')'){
			if(){
			
			}
		}
			
	}
	
	static class Stack1{
		char[] sta;
		 int theTop;
		public Stack1(){
			sta=new char[20];
			this.theTop=0;
		}
		
	public char getTop(){
		return sta[theTop];
	}
		public void input(char c){
			sta[theTop]=c;
			theTop++;
		}
		
		public char out(){
			return sta[theTop--];
		}
		
	}
}}


