package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {
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
  				int line = in.nextInt();
  				int num = in.nextInt();
  				int[][] s = new int [line][num];
  				for(int j=0; j<line; j++){
  					for(int k=0; k<num; k++){
  						s[j][k] = in.nextInt();
  					}
  				}
  				int[][] already = new int[line][num]; 
  				int count = 0;
  				for(int j=0; j<line; j++){
  					for(int k=0; k<num; k++){
  							boolean add = true;
  							int m = 0;
  							if(already[j][k]==1)
  								add = false;
  							if(j==0){
  								if(k==0){
  									if(j+1<line){
  										if(s[j+1][0] == s[j][k]){
  											if(already[j+1][k] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j+1][k] = 1;
  										}
  									}
  									if(k+1<num){
  										if(s[j][k+1] == s[j][k]){
  											if(already[j][k+1] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j][k+1] = 1;
  										}
  									}
  									if(num>2&&s[j][num-1] == s[j][k]){
  										if(already[j][num-1] == 1){
												add = false;
												m++;
  										}
											else
												already[j][num-1] = 1;
  									}
  								}
  								else if(k==num-1){
  									if(j+1<line){
  										if(s[j+1][k] == s[j][k]){
  											if(already[j+1][k] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j+1][k] =1;
  										}
  									}
  									if(k-1>-1){
  										if(s[j][k-1] == s[j][k]){
  											if(already[j][k-1] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j][k-1] = 1;
  										}
  									}
  									if(num>2 && s[j][0] == s[j][k]){
  										if(already[j][0] == 1){
  											add = false;
  											m++;
  										}
  										else
  											already[j][0] = 1;
  									}
  								}
  								else if(k!=0&&k!=num-1){
  									if(s[j][k-1]==s[j][k]){
  										if(already[j][k-1]==1){
  											add = false;
  											m++;
  										}
  										else
  											already[j][k-1] = 1;
  									}
  									if(s[j][k+1]==s[j][k]){
  										if(already[j][k+1]==1){
  											add = false;	
  											m++;
  										}
  										else
  											already[j][k+1] = 1;
  									}
  									if(j+1<line){
  										if(s[j+1][k]==s[j][k]){
  											if(already[j+1][k]==1){
  												add = false;
  												m++;
  											}
  											else
  												already[j+1][k] = 1;
  									}
  								}
  							}
  							}//j=0
  							else if(j==line-1){
  								if(k==0){
  									if(j-1>-1){
  										if(s[j-1][0] == s[j][k]){
  											if(already[j-1][0] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j-1][0] = 1;
  										}
  									}
  									if(k+1<num){
  										if(s[j][k+1] == s[j][k]){
  											if(already[j][k+1] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j][k+1] = 1;
  										}
  									}
  									if(num>2 && s[j][num-1] == s[j][k]){
  										if(already[j][num-1] == 1){
											add = false;	
											m++;
  										}
										else
											already[j][num-1] = 1;
  									}
  								}
  								else if(k==num-1){
  									if(j-1>-1){
  										if(s[j-1][k] == s[j][k]){
  											if(already[j-1][k] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j-1][k] =1;
  										}
  									}
  									if(k-1>-1){
  										if(s[j][k-1] == s[j][k]){
  											if(already[j][k-1] == 1){
  												add = false;
  												m++;
  											}
  											else
  												already[j][k-1] = 1;
  										}
  									}
  									if(num>2 &&s[j][0] == s[j][k]){
  										if(already[j][0] == 1){
  											add = false;
  											m++;
  										}
  										else
  											already[j][0] = 1;
  									}
  								}
  								else if(k!=0&&k!=num-1){
  									if(s[j][k-1]==s[j][k]){
  										if(already[j][k-1]==1){
  											add = false;
  											m++;
  										}
  										else
  											already[j][k-1] = 1;
  									}
  									if(s[j][k+1]==s[j][k]){
  										if(already[j][k+1]==1){
  											add = false;
  											m++;
  										}
  										else
  											already[j][k+1] = 1;
  									}
  									if(j-1>-1){
  										if(s[j-1][k]==s[j][k]){
  											if(already[j-1][k]==1){
  												add = false;	
  												m++;
  											}
  											else
  												already[j-1][k] = 1;
  										}
  									}
  								}
  							} //j=line-1
  							else if(j!=0 && j!=line-1){
  								if(k==0){
  									if(num>2 && s[j][num-1] == s[j][k]){
  										if(already[j][num-1] == 1){
												add = false;
												m++;
  										}
										else
												already[j][num-1] = 1;
  									}
  									if(k+1<num){
  										if(s[j][k+1]==s[j][k]){
  											if(already[j][k+1]!=1){
  												add = false;
  												m++;
  											}
  											else
  												already[j][k+1] = 1;
  										}
  									}
  									if(s[j-1][k]==s[j][k]){
  										if(already[j-1][k]==1){
  											add = false;
  											m++;	
  										}
  										else
  											already[j-1][k] = 1;
  									}
  									if(s[j+1][k]==s[j][k]){
  										if(already[j+1][k]==1){
  											add = false;
  											m++;
  										}
  										else
  											already[j+1][k] = 1;
  									}
  								}
  								else if(k==num-1){
  									if(num>2 && s[j][0] == s[j][k]){
  										if(already[j][0] == 1){
												add = false;
												m++;
  										}
											else
												already[j][0] = 1;
  									}
  									if(k-1>-1){
  										if(s[j][k-1]==s[j][k]){
  											if(already[j][k-1]!=1){
  												add = false;
  												m++;
  											}
  											else
  												already[j][k-1] = 1;
  										}
  									}
  									if(s[j-1][k]==s[j][k]){
  										if(already[j-1][k]==1){
  											add = false;
  											m++;
  										}
  										else
  											already[j-1][k] = 1;
  									}
  									if(s[j+1][k]==s[j][k]){
  										if(already[j+1][k]==1){
  											add = false;
  											m++;
  										}
  										else
  											already[j+1][k] = 1;
  										}
  									}
  								
  								else if(k!=0&&k!=num-1){
  									if(s[j][k+1] == s[j][k]){
  										if(already[j][k+1] == 1){
												add = false;
												m++;
  										}
											else
												already[j][k+1] = 1;
  									}
  									if(s[j][k-1]==s[j][k]){
  											if(already[j][k-1]==1){
  												add = false;
  												m++;
  											}
  											else
  												already[j][k-1] = 1;
  									}
  									if(s[j-1][k]==s[j][k]){
  										if(already[j-1][k]==1){
  											add = false;
  											m++;
  										}
  										else
  											already[j-1][k] = 1;
  									}
  									if(s[j+1][k]==s[j][k]){	
  										if(already[j+1][k]==1){
  											m++;
  											add = false;
  										}
  										else
  											already[j+1][k] = 1;
  									}
  								}
  							}
  							already[j][k] = 1;
  							if(add){
  								count++;
  								//out.println(j+" "+k);
  							}
  							if(m>2){
  								count--;
  								//out.println(j+" "+k);
  							}
  							}
  					}
  				out.println(count);
  			}
  		}
}