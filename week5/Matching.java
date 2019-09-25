package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Matching {
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
	  		int cases = in.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int a = in.nextInt();
	  			int b = in.nextInt();
	  			String s = in.next();
	  			String t = in.next();
	  			if(a>b){
	  				out.println("NO");
	  			}
	  			else if(a==b){
	  				if(s.indexOf('*')==-1){
	  					if(s.equals(t))
	  						out.println("YES");
	  					else
	  						out.println("NO");
	  				}
	  				else{
	  					if(a==2){
	  						if(s.charAt(1-s.indexOf('*'))==t.charAt(1-s.indexOf('*')))
	  							out.println("YES");
	  						else 
	  							out.println("NO");
	  					}
	  					else{
	  						int index = s.indexOf('*');
	  						if(index==-1)
	  		  					out.println("NO");
	  		  				else if(index==0){
	  	  						if(a>1){
	  	  							if(a==2){
	  		  							if(s.charAt(1)==t.charAt(1))
	  		  								out.println("YES");
	  		  							else
	  		  								out.println("NO");
	  		  						}
	  	  							else{
	  	  							String k = s.substring(1, a-1);
	  	  							if(t.substring(b+1-a, b-1).equals(k))
	  	  								out.println("YES");
	  	  							else
	  	  								out.println("NO");
	  	  							}
	  	  						}
	  	  						else
	  	  							out.println("YES");
	  	  					}
	  		  				else if(index==a-1){
	  		  					if(a>1){
	  		  						if(a==2){
	  		  							if(s.charAt(0)==t.charAt(0))
	  		  								out.println("YES");
	  		  							else
	  		  								out.println("NO");
	  		  						}
	  		  						else{
	  		  							String l = s.substring(0,a-2);
	  		  							if(t.substring(0, a-2).equals(l))
	  		  								out.println("YES");
	  		  							else
	  		  								out.println("NO");
	  		  						}	
	  		  						}
	  		  					else
	  		  						out.println("NO");
	  		  				}
	  		  				
	  		  				else{
	  		  					String x = s.substring(0, index-1);
	  		  					String y = s.substring(index+1,a-1);
	  		  					String z = t.substring(0,index-1);
	  		  					String w = t.substring(a-index, b-1);
	  		  					if(x==z&&y==w){
	  		  						out.println("NO");
	  		  					}
	  		  					else
	  		  						out.println("YES");
	  		  				}
	  					}
	  				}
	  			}
	  			else{ //a<b
	  				int index = s.indexOf('*');
	  				if(index==-1)
	  					out.println("NO");
	  				else if(index==0){
  						if(a>1){
  							if(a==2){
	  							if(s.charAt(1)==t.charAt(1))
	  								out.println("YES");
	  							else
	  								out.println("NO");
	  						}
  							else{
  							String k = s.substring(1, a-1);
  							if(t.substring(b+1-a, b-1).equals(k))
  								out.println("YES");
  							else
  								out.println("NO");
  							}
  						}
  						else
  							out.println("YES");
  					}
	  				else if(index==a-1){
	  					if(a>1){
	  						if(a==2){
	  							if(s.charAt(0)==t.charAt(0))
	  								out.println("YES");
	  							else
	  								out.println("NO");
	  						}
	  						else{
	  							String l = s.substring(0,a-2);
	  							if(t.substring(0, a-2).equals(l))
	  								out.println("YES");
	  							else
	  								out.println("NO");
	  						}	
	  						}
	  					else
	  						out.println("NO");
	  				}
	  				
	  				else{
	  					String x = s.substring(0, index-1);
	  					String y = s.substring(index+1,a-1);
	  					String z = t.substring(0,index-1);
	  					String w = t.substring(a-index, b-1);
	  					if(x==z&&y==w){
	  						out.println("NO");
	  					}
	  					else
	  						out.println("YES");
	  				}
	  			}
	  	}
	  	}
}

	  	
