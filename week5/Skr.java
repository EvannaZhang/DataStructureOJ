package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Skr {
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
	  			int number = in.nextInt();
	  			int answer = 1;
	  			int count=0;
	  			String e = in.next();
	  			char a = e.charAt(e.length()-1);
	  			for(int j=1; j<number; j++){
	  				String check = in.next();
	  				char test = check.charAt(check.length()-1);
	  				if(test==a){
	  					answer++;
	  					if(answer>count)
	  						count = answer;
	  				}
	  				else{
	  					answer=1;
	  					a = test;
	  				}
	  			}
	  			out.println(count);
	  		}
	  		
	  	}
}
