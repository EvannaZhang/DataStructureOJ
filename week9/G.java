package week9;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//class gnode{
//	ArrayList<Integer> next = new ArrayList<Integer>();
//	ArrayList<Integer> wei = new ArrayList<Integer>();
//	int[] distance = new int[7];
//	boolean[] ru = new boolean[7];
//}


public class G {
	static PrintWriter out;
    static Reader in;
    public static class MinComparator implements Comparator<gnode>{
		public int compare(gnode first, gnode second) {
			if (second.distance[0] < first.distance[0]) {
				return 1;
			} else {
				return -1;
			}
		}
    }
    public static class MinComparator1 implements Comparator<gnode>{
		public int compare(gnode first, gnode second) {
			if (second.distance[1] < first.distance[1]) {
				return 1;
			} else {
				return -1;
			}
		}
    }
    public static class MinComparator2 implements Comparator<gnode>{
		public int compare(gnode first, gnode second) {
			if (second.distance[2] < first.distance[2]) {
				return 1;
			} else {
				return -1;
			}
		}
    }
    public static class MinComparator3 implements Comparator<gnode>{
		public int compare(gnode first, gnode second) {
			if (second.distance[3] < first.distance[3]) {
				return 1;
			} else {
				return -1;
			}
		}
    }
    public static class MinComparator4 implements Comparator<gnode>{
		public int compare(gnode first, gnode second) {
			if (second.distance[4] < first.distance[4]) {
				return 1;
			} else {
				return -1;
			}
		}
    }
    public static class MinComparator5 implements Comparator<gnode>{ //1
		public int compare(gnode first, gnode second) {
			if (second.distance[5] < first.distance[5]) {
				return 1;
			} else {
				return -1;
			}
		}
    }
    public static class MinComparator6 implements Comparator<gnode>{ //n
		public int compare(gnode first, gnode second) {
			if (second.distance[6] < first.distance[6]) {
				return 1;
			} else {
				return -1;
			}
		}
    }
   
	public static void main(String[] args)throws IOException{
		  	out = new PrintWriter(System.out);
	        in = new Reader();	
	        int cases = in.nextInt();
	        for(int i=0; i<cases; i++){
	        	int nodes = in.nextInt();
	        	int line = in.nextInt();
	        	int go = in.nextInt();
	        	gnode[] tree = new gnode[nodes+1];
	        	for(int j=0; j<nodes+1; j++)
	        		tree[j] = new gnode();
	        	for(int j=0; j<line; j++){
	        		int x = in.nextInt();
	        		int y = in.nextInt();
	        		int z = in.nextInt();
	        		tree[x].next.add(y);
	        		tree[x].wei.add(z);
	        		tree[y].next.add(x);
	        		tree[y].wei.add(z);
	        	}
	        	int[] must = new int[go];
	        	for(int j=0; j<go; j++){
	        		must[j] =in.nextInt();
	        	}	
	        	for(int j=0; j<nodes+1; j++)
        			tree[j].distance[5] = java.lang.Integer.MAX_VALUE;
        		tree[1].distance[5] = 0;
        		PriorityQueue<gnode> check5 = new PriorityQueue<gnode>(new MinComparator5());
        		check5.add(tree[1]);
        		while(!check5.isEmpty()){
        			gnode top = check5.poll();
        			if(top.ru[5]==false){
	        			top.ru[5] = true;
	        			for(int j=0; j<top.next.size(); ++j){
	        				int son = top.next.get(j);
	        				if(tree[son].ru[5]==false){
	        					if(top.distance[5]+top.wei.get(j)<tree[son].distance[5])
	        						tree[son].distance[5] = top.distance[5]+top.wei.get(j);
	        					check5.add(tree[son]);
	        				}
	        			} 
	        		}
	        }
	        for(int j=0; j<nodes+1; j++)
    			tree[j].distance[6] = java.lang.Integer.MAX_VALUE;
    		tree[nodes].distance[6] = 0;
	        PriorityQueue<gnode> check6 = new PriorityQueue<gnode>(new MinComparator6());
	        check6.add(tree[nodes]);
	        while(!check6.isEmpty()){
	        	gnode top = check6.poll();
	        	if(top.ru[6]==false){
	        			top.ru[6] = true;
	        			for(int j=0; j<top.next.size(); ++j){
	        				int son = top.next.get(j);
	        				if(tree[son].ru[6]==false){
	        					if(top.distance[6]+top.wei.get(j)<tree[son].distance[6])
	        						tree[son].distance[6] = top.distance[6]+top.wei.get(j);
	        					check6.add(tree[son]);
	        				}
	        			} 
	        		}
	        }
	        	if(go>0){  //至少1
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[0] = java.lang.Integer.MAX_VALUE;
	        		tree[must[0]].distance[0] = 0;
	        	PriorityQueue<gnode> check = new PriorityQueue<gnode>(new MinComparator());
		        check.add(tree[must[0]]);
		        while(!check.isEmpty()){
		        	gnode top = check.poll();
		        	if(top.ru[0]==false){
		        		top.ru[0] = true;
		        		for(int j=0; j<top.next.size(); ++j){
		        			int son = top.next.get(j);
		        			if(tree[son].ru[0]==false){
		        				if(top.distance[0]+top.wei.get(j)<tree[son].distance[0])
		        					tree[son].distance[0] = top.distance[0]+top.wei.get(j);
		        				check.add(tree[son]);
		        				}
		        			} 
		        		}
		        }
	        	}
	        	if(go>1){ //至少2
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[1] = java.lang.Integer.MAX_VALUE;
	        		tree[must[1]].distance[1] = 0;
	        		PriorityQueue<gnode> check = new PriorityQueue<gnode>(new MinComparator1());
			        check.add(tree[must[1]]);
			        while(!check.isEmpty()){
			        	gnode top = check.poll();
			        	if(top.ru[1]==false){
			        			top.ru[1] = true;
			        			for(int j=0; j<top.next.size(); ++j){
			        				int son = top.next.get(j);
			        				if(tree[son].ru[1]==false){
			        					if(top.distance[1]+top.wei.get(j)<tree[son].distance[1])
			        						tree[son].distance[1] = top.distance[1]+top.wei.get(j);
			        					check.add(tree[son]);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	if(go>2){  //至少3
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[2] = java.lang.Integer.MAX_VALUE;
	        		tree[must[2]].distance[2] = 0;
	        		PriorityQueue<gnode> check = new PriorityQueue<gnode>(new MinComparator2());
			        check.add(tree[must[2]]);
			        while(!check.isEmpty()){
			        	gnode top = check.poll();
			        	if(top.ru[2]==false){
			        			top.ru[2] = true;
			        			for(int j=0; j<top.next.size(); ++j){
			        				int son = top.next.get(j);
			        				if(tree[son].ru[2]==false){
			        					if(top.distance[2]+top.wei.get(j)<tree[son].distance[2])
			        						tree[son].distance[2] = top.distance[2]+top.wei.get(j);
			        					check.add(tree[son]);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	if(go>3){
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[3] = java.lang.Integer.MAX_VALUE;
	        		tree[must[3]].distance[3] = 0;
	        		PriorityQueue<gnode> check = new PriorityQueue<gnode>(new MinComparator3());
			        check.add(tree[must[3]]);
			        while(!check.isEmpty()){
			        	gnode top = check.poll();
			        	if(top.ru[3]==false){
			        			top.ru[3] = true;
			        			for(int j=0; j<top.next.size(); ++j){
			        				int son = top.next.get(j);
			        				if(tree[son].ru[3]==false){
			        					if(top.distance[3]+top.wei.get(j)<tree[son].distance[3])
			        						tree[son].distance[3] = top.distance[3]+top.wei.get(j);
			        					check.add(tree[son]);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	if(go>4){
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[4] = java.lang.Integer.MAX_VALUE;
	        		tree[must[4]].distance[4] = 0;
	        		PriorityQueue<gnode> check = new PriorityQueue<gnode>(new MinComparator4());
			        check.add(tree[must[4]]);
			        while(!check.isEmpty()){
			        	gnode top = check.poll();
			        	if(top.ru[4]==false){
			        			top.ru[4] = true;
			        			for(int j=0; j<top.next.size(); ++j){
			        				int son = top.next.get(j);
			        				if(tree[son].ru[4]==false){
			        					if(top.distance[4]+top.wei.get(j)<tree[son].distance[4])
			        						tree[son].distance[4] = top.distance[4]+top.wei.get(j);
			        					check.add(tree[son]);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	int min = java.lang.Integer.MAX_VALUE;
	        	for(int j=0; j<5; j++){
	        		for(int k=0; k<5; k++){
	        			if(k!=j){
	        				for(int l=0; l<5; l++){
	        					if(l!=j&&l!=k){
	        						for(int m=0; m<5; m++){
	        							if(m!=l&&m!=k&&m!=j){
	        								for(int n=0; n<5; n++){
	        									if(n!=m&&n!=l&&n!=k&&n!=j){
	        										int[] order = new int[go];
	        										int posi = 0;
	        										if(j<go){
	        											order[posi] = j;
	        											posi++;
	        										}
	        										if(k<go){
	        											order[posi] = k;
	        											posi++;
	        										}
	        										if(l<go){
	        											order[posi] = l;
	        											posi++;
	        										}
	        										if(m<go){
	        											order[posi] = m;
	        											posi++;
	        										}
	        										if(n<go){
	        											order[posi] = n;
	        											posi++;
	        										}
	        										int count =  tree[must[order[0]]].distance[5];
	        										for(int p =0; p<go-1; p++){
	        											count = count + tree[must[order[p+1]]].distance[order[p]];
	        										}
	        										count = count + tree[must[order[go-1]]].distance[6];
	        										
	        										if(count < min)
	        											min = count;
	        									}
	        								}
	        							}
	        						}
	        					}
	        				}
	        			}
	        		}
	        	}
	        	out.println(min);
	        }
	        out.close();
	      	}
	      	static class Reader{
	      		
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


