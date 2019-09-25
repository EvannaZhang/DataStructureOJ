package week3;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Casino{
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
			 int total = in.nextInt();
				 int[] w = new int[total];
			 for(int j=0; j<total; j++){
				w[j] =in.nextInt();
			 }
			 for(int j=1; j<total+1; j=j+2){
				 int[]test = new int[j];
				 for(int k=0; k<j; k++){
					 test[k]=w[k];
				 }
				 Arrays.sort(test);
				 out.print(test[j/2]+" ");
			 }
			 out.println();
		 }
  	}
}


		
		
			
	

