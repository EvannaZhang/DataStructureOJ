package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.*;

public class Brackets {
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
	  
	  static boolean check(String check,int number){
		  if(number%2==1)
			  return false;
		  int a[] = new int [number];
		  int position = 0;
		  for(int j=0; j<number; j++){
				char c = check.charAt(j);
				if(c=='('){
					a[position] = 1;
					position++;
				}
				if(c=='{'){
					a[position] = 2;
					position++;
				}
				if(c=='['){
					a[position] = 3;
					position++;
				}
				if(c==')'){
					if(position==0)
						return false;
					else if(a[position-1]!=1)
							return false;
					else if(a[position-1]==1){
						position--;
					}
				
				}
				if(c=='}'){
					if(position==0)
						return false;
					else if(a[position-1]!=2)
						return false;
					else if(a[position-1]==2){
						position--;
					}
				}
				if(c==']'){
					if(position==0)
						return false;
					else if(a[position-1]!=3)
						return false;
					else if(a[position-1]==3){
						position--;
					}
				}
			}
		  if(position==0)
			  return true;
		  else 
			  return false;
	  }
	  	static void slove(InputReader in, PrintWriter out){ 
	  		int cases = in.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int number = in.nextInt();
	  			String c = in.next();
	  			boolean ans = check(c,number);
	  			if(ans==true)
	  				out.println("YES");
	  			else
	  				out.println("NO");
	  			}
	  		}
	  	}

