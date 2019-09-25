package week4;

import java.io.BufferedReader;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Spider2 {
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
	  	static void slove(InputReader in, PrintWriter out){ 
	  		int T=in.nextInt();
	    	for(int i=0;i<T;i++) {
	    		int n=in.nextInt();
	    		int[] a=new int[n];
	    		int[] rmin=new int[n];
	    		int[] minpos=new int[n];
	    		for(int j=0;j<n;j++) {
	    			a[j]=in.nextInt();
	    		}
	    		for(int j=0;j<n;j++) {
	    			rmin[j]=n+1;
	    		}
	    		Stack<Integer> stk=new Stack<Integer>();
	    		rmin[n-1]=a[n-1];
	    		minpos[n-1]=n-1;
	    		for(int j=n-2;j>=0;j--) {
	    			if(a[j]<rmin[j+1]) {
	    				rmin[j]=a[j];
	    				minpos[j]=j;
	    			}else {
	    				rmin[j]=rmin[j+1];
	    				minpos[j]=minpos[j+1];
	    			}
	    		}
	    		for(int f=0, j=0;j<n;j++) {
	    			if(f<=n-1) {
	    				if(stk.isEmpty()||stk.peek()>rmin[f]) {
	        				for(int k=minpos[f];f<=k;f++) {
	        					stk.push(a[f]);
	        				}
	        			}
	    			}
	    			
	    			out.printf("%d%s", stk.peek(), j<n-1?' ':'\n');
	    			stk.pop();
	    		}
	    		
	    	}
	   
	    }
}
