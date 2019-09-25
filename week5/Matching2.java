package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Matching2 {
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
	  			int index = s.indexOf('*');
	  			if(index==-1){
	  				if(s.equals(t))
	  					out.println("YES");
	  				else
	  					out.println("NO");
	  			}
	  			else{ //contains
	  				if(a>b){
	  					String u = s.replace("*", "");
	  					if(u.equals(t))
	  						out.println("YES");
	  					else
	  						out.println("NO");
	  				}
	  				else{ //a<=b
	  					if(index==0){
	  						if(a==1)
	  							out.println("YES");
	  						else if(a==2){
	  							char check = s.charAt(1);
	  							if(check==t.charAt(b-1))
	  								out.println("YES");
	  							else
	  								out.println("NO");
	  						}
	  						else if(a>2){
	  							if(s.substring(1, a).equals(t.substring(b-a+1, b))) //last+1
	  								out.println("YES");
	  							else
	  								out.println("NO");
	  						}
	  					}
	  					else if(index==a-1){
	  						if(a==1)
	  							out.println("YES");
	  						else if(a==2){
	  							char check = s.charAt(0);
	  							if(check==t.charAt(0))
	  								out.println("YES");
	  							else
	  								out.println("NO");
	  						}
	  						else if(a>2){
	  							if(s.substring(0, a-1).equals(t.substring(0, a-1))) //last+1
	  								out.println("YES");
	  							else
	  								out.println("NO");
	  						}
	  					}
	  					else{ //index!=0&&index!=a-1
	  						if(index==1){
	  							if(a==3){
	  								if(s.charAt(0)==t.charAt(0)&&s.charAt(2)==t.charAt(b-1))
	  									out.println("YES");
	  								else
	  									out.println("NO");
	  							}
	  							else{
	  								if(s.charAt(0)==t.charAt(0)&&s.substring(2,a).equals(t.substring(b-a+2, b))) //+1
	  									out.println("YES");
	  								else
	  									out.println("NO");
	  							}
	  						}
	  						else if(index==a-2){ //check
	  							if(a==3){
	  								if(s.charAt(0)==t.charAt(0)&&s.charAt(2)==t.charAt(b-1))
	  									out.println("YES");
	  								else
	  									out.println("NO");
	  							}
	  							else{
	  								if(s.charAt(a-1)==t.charAt(b-1) && s.substring(0,index).equals(t.substring(0, index))) //+1
	  									out.println("YES");
	  								else
	  									out.println("NO");
	  							}
	  						}
	  						else{ //!index=1/0/a-1/a-2
	  							if(s.substring(0,index).equals(t.substring(0,index)) && s.substring(index+1, a).equals(t.substring(b+1+index-a, b))) //+1
	  								out.println("YES");
  								else
  									out.println("NO");
	  						}
	  						
	  					}
	  				}
	  			}
	  		}
	  	}
	  	
}
