package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import week3.Bookstore.InputReader;

public class Combine {
	static class InputReader {
	      public BufferedReader reader;
	      public StringTokenizer tokenizer;

	      public InputReader(InputStream stream) {
	          reader = new BufferedReader(new InputStreamReader(stream), 32768);
	          tokenizer = null;
	      }

	      public String next() {
	          while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	              try {
	                  tokenizer = new StringTokenizer(reader.readLine());
	              } catch (IOException e) {
	                  throw new RuntimeException(e);
	              }
	          }
	          return tokenizer.nextToken();
	      }

	      public int nextInt() {
	          return Integer.parseInt(next());
	      }

	      public long nextLong() {
	          return Long.parseLong(next());
	      }

	}
	  public static void main(String []args) {
	      InputStream inputStream = System.in;
	      OutputStream outputStream = System.out;
	      InputReader in = new InputReader(inputStream);
	      PrintWriter out = new PrintWriter(outputStream);
	      slove(in,out);
	      out.close();
	  }
	  
	   public static class Node{
		   int coe;	
		   int expo;
		   Node next;
		   public Node(int c, int e){
			   this.coe = c;
			   this.expo = e;
		   }
		  
	   }
	   public static class list{
		   Node head;
		   Node tail;
		   public list(){
			   head = null;
			   tail = null;
		   }
		   public void add(int coe, int expo){
			   Node tmp = new Node(coe, expo);
			   if(head==null){
				   head = tmp;
				   tail = tmp;
				   tail.next = null;//
				//   tail.next = head;
			   }
			   else{
				   tail.next = tmp;
				   tail = tmp;
				   tail.next = null;
				//   tail.next = head;
			   }
		   }
		   
	   }
	   public static list Combine(list list1, list list2){
		   list answer = null;
		  if (list1.head == null) {
		        return list2;
		    } else if (list2.head == null) {
		        return list1;
		    }
 /*
		    if (list1.head.expo == list2.head.expo) {
		        answer.add(list1.head.coe+list2.head.coe, list1.head.expo);
		        list1.head = list1.head.next;
		        list2.head = list2.head.next;
		    }
		    else {
		        if (list1.head.expo > list2.head.expo) {
		            answer.add(list2.head.coe, list2.head.expo);
		            list2.head = list2.head.next;
		        }
		        else{
		        	answer.add(list1.head.coe, list1.head.expo);
		           list1.head = list1.head.next;
		        }
		    }*/

		    while(list1.head!=null && list2.head!=null){
		        if (list1.head.expo == list2.head.expo)
		        {
		        	answer.add(list1.head.coe+list2.head.coe, list1.head.expo);
			        list1.head = list1.head.next;
			        list2.head = list2.head.next;
		        }
		        else if(list1.head.expo < list2.head.expo)
		        {
		        	answer.add(list1.head.coe, list1.head.expo);
			        list1.head = list1.head.next;
		        }
		        else {
		        	answer.add(list2.head.coe, list2.head.expo);
		            list2.head = list2.head.next;

		        }
		    }

		    if(list2.head==null){
		    	while(list1.head!=null){
		    		answer.add(list1.head.coe, list1.head.expo);
		    		list1.head = list1.head.next;
		    	}
		    }
		    if(list1.head==null){
		    	while(list2.head!=null){
		    		answer.add(list1.head.coe, list1.head.expo);
		    		list1.head = list1.head.next;
		    	}
		    }
		    answer.tail=answer.head;
		    answer.tail.next = null;
		    return answer;
	   }
	   
	  	static void slove(InputReader in, PrintWriter out){  
	  		int cases = in.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int first = in.nextInt();
	  			list f = new list();
	  			
	  			for(int j=0; j<first; j++){
	  				f.add(in.nextInt(), in.nextInt());
	  			}
	  			int second = in.nextInt();
	  			list s = new list();
	  		
	  			for(int j=0; j<second; j++){
	  				s.add(in.nextInt(), in.nextInt());
	  			}
	  			list ans = Combine(f,s);
	  			//while(ans.head!=null){
	  			//	out.println(ans.head.coe+" "+ans.head.expo);
	  			//}
	  		
	  	}
	

}

}