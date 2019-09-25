package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Greatest {
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
	  		int cases =in.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int time = in.nextInt();
	  			int value[][] = new int [time][3]; //0 value 1max 2min
	  			int position=0;
	  			int max=0;
	  			int min=0;
	  			for(int j=0; j<time; j++){
	  				String d = in.next();
	  				if(d.contains("pop")){
	  					position = position-2;
	  					if(position<0){
	  						out.println(0);
	  						position = 0;
	  						max = min = 0;
	  					}
	  					else{
	  						max = value[position][1];
	  						min = value[position][2];
	  						out.println(value[position][1]-value[position][2]);
	  						position++;
	  					}
	  				}
	  				else{
	  					int check = in.nextInt();
	  					value[position][0] = check;
	  					if(check>max){
	  						max = check;
	  					}
	  					if(position==0){
	  						min = check;
	  					}
	  					if(check<min){
	  						min = check;
	  					}
	  					value[position][1] = max;
	  					value[position][2] = min;
	  					position++;
	  				}
	  			}
	  		}
	  	}
}
