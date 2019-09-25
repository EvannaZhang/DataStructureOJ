package week5;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class KMP {
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
	  		static void makeNext(String P , int b, int next[])
	  		{
	  		    int q,k;//q:模版字符串下标；k:最大前后缀长度
	  		    next[0] = 0;//模版字符串的第一个字符的最大前后缀长度为0
	  		    for (q = 1,k = 0; q < b; ++q)//for循环，从第二个字符开始，依次计算每一个字符对应的next值
	  		    {
	  		        while(k > 0 && P.charAt(q) != P.charAt(k))//递归的求出P[0]···P[q]的最大的相同的前后缀长度k
	  		            k = next[k-1];          //不理解没关系看下面的分析，这个while循环是整段代码的精髓所在，确实不好理解
	  		        if (P.charAt(q) == P.charAt(k))//如果相等，那么最大相同前后缀长度加1
	  		        {
	  		            k++;
	  		        }
	  		        next[q] = k;
	  		    }
	  		}
	  		static void slove(InputReader in, PrintWriter out){ 
	  			int cases = in.nextInt();
	  			for(int i=0; i<cases; i++){
	  				int a = in.nextInt();
	  				String x = in.next();
	  				int b = in.nextInt();
	  				String y = in.next();
	  				if(a==0||b==0||a<b){
	  					out.println(0);
	  				}
	  				else{
		  			/*	int next[] = new int [b];
		  				next[0] = 0;
		  				for(int j=1; j<b; j++){                              //pattern的sub（0，j+1）
		  					int count = 0;
		  					outterloop: for(int k=j-1; k>-1; k--){           //k=character
		  						boolean yes = true;
		  						for(int q = 0; q<k+1; q++){                  //检查character来代替equals
		  							if((int)y.charAt(q)!=(int)y.charAt(q+j-k)){
		  								yes = false;
		  								break;
		  							}	
		  						}
		  						if(yes==true){
		  							count = k+1;
		  							break outterloop;
		  						}
		  						else if(k==0)
		  							count=0;
		  					}
		  					next[j] = count;
		  				}      */                             //计算next数组 找最长相同前后缀的长度
	  					int next[] = new int [b];
	  					makeNext(y,b,next);
		  				int j =0;
		  				int ans = 0;
		  				while(j<=a-b){
		  					int n = 1;
		  					boolean check = true;
		  					outterloop: for(int k=0; k<b; k++){
		  						if(k!=0&&x.charAt(j+k)!=y.charAt(k)){
		  							n = k-1-next[k-1];
		  							check = false;
		  							if(n<1)
		  								n=1;
		  							break outterloop;
		  						}                              //pattern非第一位不匹配
		  						if(k==0&&x.charAt(j+k)!=y.charAt(k)){
		  							n=1;
		  							check = false;
		  							break outterloop;
		  						}                            //pattern第一位不匹配
		  						
		  					}
		  					if(check==true){
		  						ans++;
	  							n = b-next[b-1];
		  					}                                //equals
		  					j = j+n;
		  				}
		  				out.println(ans);
		  			}
		  		}
		  	}
		  	
	}
	
/*if(k==b-1&&x.charAt(j+k)==y.charAt(k)){
		  							ans++;
		  							n = b-next[b-1];
		  						}*/