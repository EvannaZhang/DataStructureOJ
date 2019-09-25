package week8;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class F2 {
	static PrintWriter out;
    static Reader in;
    
    static int solve(int i, int n,int[] dp,int[][] G)
    {
        if (dp[i]!=0)
        	return dp[i];
        for (int k = 1; k <= n; ++k) {
        	if (G[i][k] != 0) {
        		dp[i] = Math.max(dp[i], solve(k,n,dp,G) + G[i][k]);
        	}
        }
        return dp[i];  	
    }
    
	public static void main(String[] args)throws IOException{
		 out = new PrintWriter(System.out);
	        in = new Reader();
			int cases = in.nextInt();
			for(int i=0; i<cases; i++){
				int n = in.nextInt();
				int m = in.nextInt();
				int[] ru = new int[n+1];
				int[][] G = new int[n+1][n+1];
				int [] dp = new int[n+1];
				for (int k = 0; k < m; ++k) {
		            int x = in.nextInt();
		            int y =  in.nextInt();
		            int z = in.nextInt();
		            ru[y]++;
		            G[x][y] = z;
				}
				for (int k = 1; k <= n; ++k) {
		            if (ru[k]==0)
		               solve(k,n,dp,G);
		        }
				int max = 0;
				 for (int k = 1; k <= n; ++k) {
			            if (max < dp[k]) {
			                max= dp[k];
			            }
			        }
				 out.println(max);
			}
			out.close();
	}
				static class Reader
			    {
			        final private int BUFFER_SIZE = 1 << 16;
			        private DataInputStream din;
			        private byte[] buffer;
			        private int bufferPointer, bytesRead;
			 
			        public Reader()
			        {
			            din = new DataInputStream(System.in);
			            buffer = new byte[BUFFER_SIZE];
			            bufferPointer = bytesRead = 0;
			        }
			 
			        public Reader(String file_name) throws IOException
			        {
			            din = new DataInputStream(new FileInputStream(file_name));
			            buffer = new byte[BUFFER_SIZE];
			            bufferPointer = bytesRead = 0;
			        }
			 
			        public String readLine() throws IOException
			        {
			            byte[] buf = new byte[64]; // line length
			            int cnt = 0, c;
			            while ((c = read()) != -1)
			            {
			                if (c == '\n')
			                    break;
			                buf[cnt++] = (byte) c;
			            }
			            return new String(buf, 0, cnt);
			        }
			 
			        public int nextInt() throws IOException
			        {
			            int ret = 0;
			            byte c = read();
			            while (c <= ' ')
			                c = read();
			            boolean neg = (c == '-');
			            if (neg)
			                c = read();
			            do
			            {
			                ret = ret * 10 + c - '0';
			            }  while ((c = read()) >= '0' && c <= '9');
			 
			            if (neg)
			                return -ret;
			            return ret;
			        }
			 
			        public long nextLong() throws IOException
			        {
			            long ret = 0;
			            byte c = read();
			            while (c <= ' ')
			                c = read();
			            boolean neg = (c == '-');
			            if (neg)
			                c = read();
			            do {
			                ret = ret * 10 + c - '0';
			            }
			            while ((c = read()) >= '0' && c <= '9');
			            if (neg)
			                return -ret;
			            return ret;
			        }
			 
			        public double nextDouble() throws IOException
			        {
			            double ret = 0, div = 1;
			            byte c = read();
			            while (c <= ' ')
			                c = read();
			            boolean neg = (c == '-');
			            if (neg)
			                c = read();
			 
			            do {
			                ret = ret * 10 + c - '0';
			            }
			            while ((c = read()) >= '0' && c <= '9');
			 
			            if (c == '.')
			            {
			                while ((c = read()) >= '0' && c <= '9')
			                {
			                    ret += (c - '0') / (div *= 10);
			                }
			            }
			 
			            if (neg)
			                return -ret;
			            return ret;
			        }
			 
			        private void fillBuffer() throws IOException
			        {
			            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			            if (bytesRead == -1)
			                buffer[0] = -1;
			        }
			 
			        private byte read() throws IOException
			        {
			            if (bufferPointer == bytesRead)
			                fillBuffer();
			            return buffer[bufferPointer++];
			        }
			 
			        public void close() throws IOException
			        {
			            if (din == null)
			                return;
			            din.close();
			        }
			    }
			}
	

