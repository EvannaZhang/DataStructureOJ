package week8;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class graph{
	ArrayList<Integer> son = new ArrayList<Integer>();
	int depth = -1;                        //用depth标记是否被判断过
}
public class C2 {
		static void count(int a, graph[] edge, Queue<Integer> check){
			check.add(a);
			edge[a].depth = 0;
			while(!check.isEmpty()){                 
			    int t = check.poll();     
			    for(int i=0; i<edge[t].son.size(); i++){
			    	int son = edge[t].son.get(i);
			    	if(edge[son].depth==-1){
			    		edge[son].depth = edge[t].depth+1;     //每pop一个 标记它的儿子
			    		check.add(son);
			    	}
			    }
			}
		}
	public static void main(String[] args)throws IOException{
		Reader in = new Reader();
		Queue<Integer> check = new LinkedList<Integer>();
		int cases = in.nextInt();
			for(int i=0; i<cases; i++){
				int nodes = in.nextInt();
				int line = in.nextInt();
				int s = in.nextInt();
				graph[] edge = new graph[nodes+1];
				for(int j=0; j<nodes+1; j++){
					edge[j] = new graph();
				}
				for(int j=0;j<line; j++){
					int a = in.nextInt();
					int b = in.nextInt();
					edge[a].son.add(b);
					edge[b].son.add(a);
				}                                      //建图
				count(s, edge,check);
				for(int j=1; j<=nodes; j++){
					System.out.print(edge[j].depth);
					if(j!=nodes)
						System.out.print(" ");
				}
				System.out.println();
		}
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
