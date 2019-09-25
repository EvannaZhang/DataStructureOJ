package week8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n{
	int color;
	ArrayList<n> link = new ArrayList<n>();
	boolean c = false;
}
public class E3 {
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
  		static n findup(int j, int k, int line, int num, n[][] s){
  			if(j==0)
  				return  null;
  			else{
  				return s[j-1][k];
  			}
  		}
  		static n findlow(int j, int k, int line, int num, n[][] s){
  			if(j==line-1)
  				return null;
  			else
  				return s[j+1][k];
  		}
  		static n findleft(int j, int k, int line, int num, n[][] s){
  			if(k>0)
  				return s[j][k-1];
  			else{
  				if(num>2)
  					return s[j][num-1];
  				else
  					return null;
  			}
  		}
  		static n findright(int j, int k, int line, int num, n[][] s){
  			if(k<num-1)
  				return s[j][k+1];
  			else{
  				if(num>2)
  					return s[j][0];
  				else
  					return null;
  			}
  		}
  		static void slove(InputReader in, PrintWriter out){
  			int cases = in.nextInt();
  			for(int i=0; i<cases; i++){
  				int line = in.nextInt();
  				int num = in.nextInt();
  				n[][] s = new n [line][num];
  				for(int j=0; j<line; j++){
  					for(int k=0; k<num; k++){
  						s[j][k] = new n();
  						s[j][k].color = in.nextInt();
  					}
  				}
  				for(int j=0; j<line; j++){
  					for(int k=0; k<num; k++){
  						n up = findup(j, k, line, num,s);
  						if(up!=null){
  							if(up.color == s[j][k].color)
  								s[j][k].link.add(up);
  						}
  						n low = findlow(j, k, line, num,s);
  						if(low!=null){
  							if(low.color == s[j][k].color)
  								s[j][k].link.add(low);
  						}
  						n left = findleft(j, k, line, num,s);
  						if(left!=null){
  							if(left.color == s[j][k].color)
  								s[j][k].link.add(left);
  						}
  						n right = findright(j, k, line, num,s);
  						if(right!=null){
  							if(right.color == s[j][k].color)
  								s[j][k].link.add(right);
  						}
  					}
  				}
  				
  				Queue<n> near = new LinkedList<n>();
  				int count = 0;
  				for(int j=0; j<line; j++){
  					for(int k=0; k<num; k++){
  						if(s[j][k].c==false){
  							s[j][k].c = true;
  							count++;
  							near.add(s[j][k]);
  							while(!near.isEmpty()){
  								n t = near.poll();
  								for(n son: t.link){
  									if(son.c == false){
  										son.c = true;
  										near.add(son);
  									}
  								}
  							}
  						}
  					}
  				}
  				out.println(count);
  				
  				
  				
  			} //case结束
  		}
}