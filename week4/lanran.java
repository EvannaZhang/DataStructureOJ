package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class lanran {
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
	  		int number = in.nextInt();
	  		for(int i=0; i<number; i++){
	  			boolean print = false;
	  			String check = in.next();
	  			int length = check.length();
	  			int l = check.indexOf('l');
	  			if(l>-1){
	  				String first = check.substring(l);
	  				int a1 = first.indexOf('a');
	  				if(a1>-1){
	  					String second = first.substring(a1);
	  					int n1 = second.indexOf('n');
	  					if(n1>-1){
	  						String third = second.substring(n1);
	  						int r = third.indexOf('r');
	  						if(r>-1){
	  							String fourth = third.substring(r);
	  							int a2 = fourth.indexOf('a');
	  							if(a2>-1){
	  								String fifth = fourth.substring(a2);
	  								int n2 = fifth.indexOf('n');
	  								if(n2>-1){
	  									print = true;
	  								}
	  							}
	  						}
	  					}
	  				}
	  			}
	  			
	  			if(print==true)
	  				out.println("YES");
	  			else 
	  				out.println("NO");
	  		
}
	  	}
}