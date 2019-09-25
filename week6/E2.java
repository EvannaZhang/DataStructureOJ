package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class node{
		int value;
		double num;
	}

public class E2 {
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
	  		
	  		static void insert(node[] tree, node t, int num){
	  			tree[num] = t;
	  			int temp = num;
	  			if(num%2==0){
	  			while(t.num>tree[temp/2-1].num && temp/2-1>1){
	  				swap(tree,temp,temp/2-1);
	  				t = tree[temp/2-1];
	  				temp = temp/2-1;
	  			}			
	  			}
	  			else{   //num%2==1 even 
	  				while(t.num>tree[(temp-1)/2].num && (temp-1)/2>0){
	  					swap(tree,temp,(temp-1)/2);
	  					t = tree[(temp-1)/2];
	  					temp = (temp-1)/2;
	  				}
	  				
	  			}
	  		}
	  		
	  		static void swap(node[] tree, int first, int second){
	  			int i = tree[first].value;
	  			double j = tree[first].num;
	  			tree[first].value = tree[second].value;
	  			tree[first].num = tree[second].num;
	  			tree[second].value = i;
	  			tree[second].num = j;
	  		}
	  		static void delete(node[] tree, int num){
	  			tree[0] = tree[num];
	  		}
	  		
	  		static boolean whether(int[] already,int now,int num){
	  			for(int i=0; i<num; i++)
	  			{
	  				if(already[i]==now)
	  					return true;
	  			}
	  			return false;
	  		}
	  	 	static void slove(InputReader in, PrintWriter out){
	  	 		int cases = in.nextInt();
		  		for(int i=0; i<cases; i++){
		  			int capacity = in.nextInt();
		  			int shop = in.nextInt();
		  			int erase = 0;
		  			int gift = 0;
		  			int op = 0;
		  			node[] heap = new node[capacity];
				//	PriorityQueue<node> min = new PriorityQueue<node>(new MinComparator());
					int[] already = new int[capacity];
					int num = 0;
		  			for(int j=0; j<shop; j++){
		  				int now = in.nextInt();
		  				boolean have = whether(already,now,num);
		  				if(have){
		  					Stack<node> temp = new Stack<node>();
			  				while(!min.isEmpty()){
			  					if(min.peek().value==now){
			  						node t = new node();
				  					t.value = now;
				  					t.num = min.peek().num+1;
			  						min.poll();
			  						min.add(t);
			  						break;
			  					}
			  					else{
			  						temp.push(min.poll());
			  					}
			  				}
			  				while(!temp.isEmpty()){
			  					min.add(temp.pop());
			  				}
		  				}
		  				if(!have){
		  					op++;
		  					node t = new node();
		  					t.value = now;
		  					t.num = 1-op*0.1;
		  					if(gift<capacity){
		  						gift++;
		  						already[num] = now;
		  						num++;
		  						min.add(t);
		  					}
		  					else{
		  						erase++;
		  						int delete = min.peek().value;
		  						for(int k=0; k<num; k++){
		  							if(already[k]==delete){
		  								already[k] = now;
		  								break;
		  							}
		  						}
		  						min.poll();
		  						min.add(t);
		  					}
		  				}
		  			}
			  		out.println(erase);
		  		}
	  	 		} 		
	}

