package week9;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class enode{
	ArrayList<Integer> next = new ArrayList<Integer>();
	int ru;
}
public class E {
	static PrintWriter out;
    static Reader in;
   
	public static void main(String[] args)throws IOException{
		  out = new PrintWriter(System.out);
	        in = new Reader();
		int cases = in.nextInt();
		for(int i=0; i<cases; ++i){
			int course = in.nextInt();
			int line = in.nextInt();
			enode[] tree= new enode[course+1];
			for(int j=0; j<course+1; j++)
				tree[j] = new enode();
			for(int j=0; j<line; j++){
				int x = in.nextInt();
				int y = in.nextInt();
				tree[x].next.add(y);
				tree[y].ru++;
			}
			int count = 0;
			PriorityQueue<Integer> it = new PriorityQueue<Integer>();
			Queue<Integer> answer = new LinkedList<Integer>();
			for(int j=1; j<course+1; ++j){
				if(tree[j].ru==0){
					it.add(j);
				}
			}
			while(!it.isEmpty()){
				while(!it.isEmpty()){
					int top = it.poll();
					answer.add(top);
					count++;
					for(int j=0 ;j<tree[top].next.size(); ++j){
						tree[tree[top].next.get(j)].ru--;
						if(tree[tree[top].next.get(j)].ru==0)
							it.add(tree[top].next.get(j));
					}
				}
			
			}
			if(count<course)
				out.println("impossible");
			else{
				out.print(answer.poll());
				while(!answer.isEmpty())
					out.print(" "+answer.poll());
			}
			
			out.println();
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
