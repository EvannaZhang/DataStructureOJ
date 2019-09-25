package week8;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class E2 {
	
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
static void findup(int j, int k, int line, int num, int[][] s, int[][][] link){
		if(j!=0&&s[j-1][k]==s[j][k])
			link[j][k][0]=1;
	}
static void findlow(int j, int k, int line, int num, int[][] s, int[][][] link){
		if(j!=line-1&&s[j+1][k]==s[j][k])
			link[j][k][1]=1;
	}
	static void findleft(int j, int k, int line, int num, int[][] s, int[][][] link){
		if(k>0&&s[j][k-1]==s[j][k])
			link[j][k][2]=1;
		if(k==0&&num>2&&s[j][num-1]==s[j][k])
			link[j][k][2]=2;
	}
	static void findright(int j, int k, int line, int num, int[][] s, int[][][] link){
		if(k<num-1&&s[j][k+1]==s[j][k])
			link[j][k][3]=1;
		if(k==num-1&&s[j][0]==s[j][k])
			link[j][k][3]=2;
	}
	public static void main(String[] args)throws IOException{
		Reader in = new Reader();
		int cases = in.nextInt();
		for(int i=0; i<cases; i++){
				int line = in.nextInt();
				int num = in.nextInt();
				int[][] s = new int [line][num];
				for(int j=0; j<line; j++){
					for(int k=0; k<num; k++){
						s[j][k]= in.nextInt();
					}
				}
				int[][][] link = new int[line][num][5];
				for(int j=0; j<line; j++){
					for(int k=0; k<num; k++){
						findup(j, k, line,num,s,link);
						findlow(j, k, line,num,s,link);
						findleft(j, k, line,num,s,link);
						findright(j, k, line,num,s,link);
					}
				}
				
				Queue<Integer> near = new LinkedList<Integer>();
				int count = 0;
				for(int j=0; j<line; j++){
					for(int k=0; k<num; k++){
						if(link[j][k][4]==0){
							count++;
							near.add(j);
							near.add(k);
							while(!near.isEmpty()){
								int t = near.poll();
								int r = near.poll();
								if(link[t][r][0]==1){
									if(link[t-1][r][4]==0){
											near.add(t-1);
											near.add(r);
											link[t-1][r][4]=1;
										}
									}
									if(link[t][r][1]==1){
										if(link[t+1][r][4]==0){
											near.add(t+1);
											near.add(r);
											link[t+1][r][4]=1;
										}
									}
								
									if(link[t][r][2]==1){
										if(link[t][r-1][4]==0){
											near.add(t);
											near.add(r-1);
											link[t][r-1][4]=1;
										}
									}
									if(link[t][r][2]==2){
										if(link[t][num-1][4]==0){
											near.add(t);
											near.add(num-1);
											link[t][num-1][4]=1;
										}
									}
								
							
									if(link[t][r][3]==1){
										if(link[t][r+1][4]==0){
											near.add(t);
											near.add(r+1);
											link[t][r+1][4]=1;
										}
									}
									if(link[t][r][3]==2){
										if(link[t][0][4]==0){
											near.add(t);
											near.add(0);
											link[t][0][4]=1;
										}
									}
								
							
							} //while
						//each uncheck element
						}
						link[j][k][4] = 1;		
						}
				}
				
				System.out.println(count);
				
		}
	}
}