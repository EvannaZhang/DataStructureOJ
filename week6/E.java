package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

import week6.E2.InputReader;
import week6.E2.MinComparator;

class node{
	int value;
	double num;
}

public class E {
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
  		
  		public static class MinComparator implements Comparator<node>{
  			public int compare(node first, node second) {
  				if (second.num < first.num) {
  					return -1;
  				} else {
  					return 1;
  				}
  			}
  		}
  		
  	 	static void slove(InputReader in, PrintWriter out){
  	 		int cases = in.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int capacity = in.nextInt();
	  			int shop = in.nextInt();
	  			int erase = 0;
	  			int gift = 0;
	  			int op = 0;
				PriorityQueue<node> min = new PriorityQueue<node>(new MinComparator());
	  			for(int j=0; j<shop; j++){
	  				int now = in.nextInt();
	  				boolean have = false;
	  				Stack<node> temp = new Stack<node>();
	  				while(!min.isEmpty()){
	  					if(min.peek().value==now){
	  						node t = new node();
		  					t.value = now;
		  					t.num = min.peek().num+1;
	  						min.poll();
	  						min.add(t);
	  						have = true;
	  						break;
	  					}
	  					else{
	  						temp.push(min.poll());
	  					}
	  				}
	  				while(!temp.isEmpty()){
	  					min.add(temp.pop());
	  				}
	  			if(!have){
	  				op++;
	  				node t = new node();
  					t.value = now;
  					t.num = 1-op*0.1;
	  				if(gift<capacity){
	  					gift++;
	  					min.add(t);
	  				}
	  				else{
	  					erase++;
	  					min.poll();
	  					min.add(t);
	  					
	  				}
	  			}
	  			}
		  		out.println(erase);
	  		}
  	 	} 		
}

