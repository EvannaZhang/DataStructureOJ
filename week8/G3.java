package week8;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


class gnode{
	int value;
	int first, second;
	ArrayList<gnode> son = new ArrayList<gnode>();
	boolean check = false;
	gnode(int i){
		this.value = i;
	}
}
public class G3 {
	static PrintWriter out;
    static Reader in;
	public static void main(String[] args)throws IOException{
		   out = new PrintWriter(System.out);
	        in = new Reader();
			int cases = in.nextInt();
			for(int i=0; i<cases; i++){
				int n = in.nextInt();
				int m = in.nextInt();
				gnode[] tree = new gnode[n+1];
				for(int j=0; j<n+1; j++){
					tree[j] = new gnode(j);
				}
				int r = 1;
				int [] root = new int[n+1];
				for(int j=0; j<n-1; j++){
					int a = in.nextInt();
					int b = in.nextInt();
					root[a] = 1;
					tree[b].son.add(tree[a]);
				}
				for(int j=1; j<n+1; j++){
					if(root[j]!=1){
						r = j;
						break;
					}
				}
				Stack<gnode> check = new Stack<gnode>();
				check.add(tree[r]);
				int count = 0;
				while(!check.isEmpty()){
					count++;
					gnode top = check.peek();
					if(top.check==true){
						top.second = count;
						check.pop();
					}else{
						top.first = count;
						top.check = true;
						for(gnode son:top.son){
							check.push(son);
						}
					}
				}
				for(int j =0; j<m; j++){
					int b = in.nextInt();
					int a = in.nextInt();
					
					if(a==b)
						out.println("Yes");
					else{
						if((tree[a].first<tree[b].first)&(tree[b].first<tree[b].second)&(tree[b].second<tree[a].second))
							out.println("Yes");
						else
							out.println("No");
					}
				}
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
