package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Spider {
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
			  int length = in.nextInt();
			  int value[] = new int[length];
			  int min[] = new int[length];
			  int position[] = new int[length];
			  for(int j=0; j<length; j++){
				  value[j]=in.nextInt();
			  }
			  for(int j=0; j<length; j++){    
				  int mini = value[0];
				  int last = -1;
				  if(j<=last){
					  min[j]=mini;
					  position[j] = last;
				  }
				  else{
					  mini = value[j];
					  last = j;
					  for(int k=j; k<length; k++){
						  if(value[k]<mini){
							  mini = value[k];
							  last = k;
						  }
					  }
					  min[j] = mini;
					  position[j] = last;
				  }
			  }
			  
			 for(int j=0; j<length; j++){
				  out.println(value[j]);
				  out.println(min[j]);
				  out.println(position[j]);
			  }//test
			 
			  int[] ans = new int[length];
			  int pointans = 0;    //for output
			  int pointvalue = 0;   //to check
			  int already = 0;     //to count
			  
			  while(already<=length){
				  if(pointvalue==0){
					  for(int j=0; j<=position[0]; j++){
						  ans[pointans] = value[j];
						  pointans++;
						  pointvalue++;
					  }
				  }	 
				  else if(pointvalue>length){
					  for(int j=pointans; j>-1; j--){
						  out.print(ans[j]+" ");
					  }
				  }
				  else if(value[pointvalue]>min[pointvalue]){
					  for(int j=pointvalue; j<position[pointvalue]; j++){
						  ans[pointans] = value[j];
						  pointans++;
						  pointvalue++;
					  }
				  }	
				  else if(value[pointvalue]==min[pointvalue]){
					  out.print(value[pointvalue]+" ");
					  already++;
					  pointvalue++;
				  }
			
				  if(pointvalue<length && pointans>0 && pointvalue>-1){
					  while(ans[pointans-1]<min[pointvalue] && pointans>0){
						  out.print(ans[pointans-1]+" ");
						  already++;
						  pointans--;
					  }
				  }
			  }	
	
		  }
	  }
}
