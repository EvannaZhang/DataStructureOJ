package week2;
import java.util.*;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Demon2 {
	public static void main(String[] args){
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        // Task solver = new Task();
        //  solver.solve(1, in, out);
       // out.close();
		int cases = in.nextInt();
		for(int i=0; i<cases; i++){
			int number = in.nextInt();
			int demon = in.nextInt();
			int men[] = new int[number];
			for(int k=0; k<number; k++){
				men[k] = in.nextInt();
			}
			if(binSearch(men,0,number-1,demon)==0){
				out.print("YES");
			}
			else
				out.println("NO");
		}
	}
	 public static int binSearch(int a[], int start, int end, int key) {   
		  
	        int mid = (end + start) / 2;   
	        if (a[mid] == key) {   
	            return 0;   
	        }   
	        if (start >= end) {   
	            return -1;   
	        } else if (key>a[mid]) {   
	            return binSearch(a, mid + 1, end, key);   
	        } else if (key<a[mid]) {   
	            return binSearch(a, start, mid - 1, key);   
	        }   
	        return -1;   
	  
	    }   
	
	 static class Task {
	        public void solve(int testNumber, InputReader in, PrintWriter out) {
	            
	        }

	    }

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

	    }
	}
