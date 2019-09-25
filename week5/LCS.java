package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LCS {
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
	  		public static void makeNext(int m, String P,int next[]) {
	  		    int k=0;
	  		    next[0] = 0;
	  		    for (int q = 1; q < m; q++){
	  		        while(k > 0 && P.charAt(q) != P.charAt(k))        //
	  		            k = next[k-1];
	  		        if (P.charAt(q) == P.charAt(k))
	  		        {
	  		            k++;
	  		        }
	  		        next[q] = k;
	  		    }
	  		}
	  		public static boolean kmp(int a, int b, String T, String P,int next[]){
	  		    int q = 0;
	  		    for (int i = 0; i < a; ++i){
	  		        while(q > 0 && P.charAt(q) != T.charAt(i))
	  		            q = next[q-1];
	  		        if (P.charAt(q) == T.charAt(i)){
	  		            q++;
	  		        }
	  		        if (q == b)
	  		        {
	  		            return true;
	  		        }
	  		    }
	  		    return false;
	  		}
	  		
	  	static void slove(InputReader in, PrintWriter out){ 
	  		int cases = in.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int number = in.nextInt();
	  	        String[] check = new String[number];
	  	        String first = in.next();
	  	        check[0] = first;
	  	        int l = first.length();
	  	        for (int j = 1; j < number; j++){
	  	            String T = in.next();
	  	            check[j] = T;
	  	            if (T.length() < l) {
	  	                l = T.length();
	  	                first = T;
	  	            }
	  	        }            //correct
	  	        boolean nextk = true;
	  	        boolean find = true;
	  	        int finallength = 0;
	  	        if (l > 1) {             //最短字符串长度大于1
	  	            String []finalans = new String[l];
	  	            int finalansnum = 0;
	  	            for (int j = l; j > 0; j--) {         //字串长度为j
	  	                if (!find)
	  	                    break;
	  	                int ansnum = 0;
	  	                String[] ans = new String[l];
	  	                for (int k = 0; k <= l - j; k++) {    //开始index
	  	                    nextk = true;
	  	                    int[] next = new int[j];
	  	                    String zyf = first.substring(k, k+j);
	  	                    makeNext(j, zyf, next);               //
	  	                    for (int m = 0; m < number; m++) {     //所有字串
	  	                        if (!nextk)
	  	                            break;
	  	                        if (!kmp(check[m].length(), j, check[m], zyf, next)) {
	  	                            nextk = false;
	  	                        }
	  	                    }
	  	                    if(nextk){
	  	                        ans[ansnum] = zyf;
	  	                        ansnum++;
	  	                        finallength = j;
	  	                        find = false;
	  	                    }
	  	                }
	  	                finalansnum = ansnum;
	  	                for (int n = 0; n < finalansnum; n++) {
	  	                    finalans[n] = ans[n];
	  	                }
	  	            }
	  	                if (finalansnum == 0)
	  	                    out.printf("Hong\n");
	  	                else if (finalansnum == 1) {
	  	                	out.printf("%s\n", finalans[0]);
	  	                }
	  	                else{                             //有多个同长度公共串
	  	                    int[] answer = new int[finalansnum];
	  	                    int output = 0;
	  	                    for (int k = 0; k < finalansnum; k++) {
	  	                        for (int m = 0; m < finallength; m++) {
	  	                            answer[k] = answer[k] + (int) finalans[k].charAt(m) * (int) Math.pow(10, finallength - m - 1);
	  	                        }
	  	                    }
	  	                    int compare = answer[0];
	  	                    for (int k = 1; k < finalansnum; k++) {
	  	                        if (answer[k] < compare) {
	  	                            output = k;
	  	                            compare = answer[k];
	  	                        }

	  	                    }
	  	                    out.printf("%s\n", finalans[output]);
	  	                }
	  	        }
	  	        else if(l==1){             //最短字符串长度等于11
	  	            boolean cha = true;
	  	            int count =0;
	  	            for(int j=0; j<number; j++){           //所有字符串
	  	                cha = true;
	  	                for(int k=0; k<check[j].length(); k++){
	  	                    if(!cha)
	  	                        break;
	  	                    if(check[j].charAt(k)==first.charAt(0)){
	  	                        count++;
	  	                        cha = false;
	  	                    }
	  	                }
	  	            }
	  	            if(count == number){
	  	            	out.printf("%s\n", first);
	  	             
	  	            }
	  	            else
	  	                out.printf("Hong\n");
	  	        }
	  	        else{
	  	            out.printf("Hong\n");
	  	        }
	  		}
	  	}
}

