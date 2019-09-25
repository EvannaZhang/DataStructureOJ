package week3;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Bookstore{
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
  	while(true){
	  int book = in.nextInt();
	  if(book==0)
		  break;
	  LinkedList check = new LinkedList();
	  LinkedList delete = new LinkedList();
	  String cus = in.next();
	  int length = cus.length();
	  int leave = 0;
	  check.add(cus.charAt(0));
	  book--;
	  for(int i=1; i<length; i++){
		  char people = cus.charAt(i);
		  	if(check.contains(people)){
				 
				  book++;
				  check.remove("cus.charAt(i)");
				  
			  }
			  if(!check.contains(people)){
				if(!delete.contains(people) && book<=0){
					delete.add(people);
					leave++;
				}
			//	if(delete.contains(people))
				if(!delete.contains(people) && !check.contains(people) && book>0){
				  book--;
				  check.add(cus.charAt(i));
				}
			  }
		  
	  }
	  System.out.println(leave);
  	}
  	}
}
