package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Merge3 {
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
        int u=121;
        slove(in,out);
        out.close();
    }
    static void slove(InputReader in, PrintWriter out){   
    	 int cases = in.nextInt();
	     for(int i=0; i<cases; i++){
			int n = in.nextInt();
			int m = in.nextInt();
			int[] first = new int[n];
			int[] second = new int[m];
			for(int j=0; j<n; j++){
				first[j]=in.nextInt();
			}
			for(int j=0; j<m; j++){
				second[j]=in.nextInt();
			}
			int[]merge = new int[m+n];
			for(int j=0; j<m+n; j++){
				if(j<n)
				merge[j]=first[j];
				else 
				merge[j]=second[j-n];
			}
			Arrays.sort(merge);
			for(int j=0; j<m+n; j++){
				out.print(merge[j]+" ");
			}
			
			out.close();
		}
	     
}
}