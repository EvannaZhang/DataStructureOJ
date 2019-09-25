package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.*;

public class Dash {
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
	  			int cha = in.nextInt();
	  			int x,y,begin,end;
	  			x=y=begin=end=0;
	  			int count =0;
	  			int[][] map = new int [line][cha];
	  			for(int j=0; j<line; j++){
	  				String a = in.next();
	  				for(int k=0; k<cha; k++){
	  					if(a.charAt(k)=='.'){
	  						map[j][k] = 0;
	  					}
	  					else if(a.charAt(k)=='#'){
	  						map[j][k] = -1;
	  					}
	  					else if(a.charAt(k)=='S'){
	  						begin=x=j;
	  						end=y=k;
	  					}
	  					else if(a.charAt(k)=='E'){
	  						map[j][k] = 2;
	  					}
	  					
	  				}
	  			}                //input the map

	  			String move = in.next();
	  			
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y--;
	  				}
	  				
	  				if(x>=cha||x<0||y>=line||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //1:0123syxz
	  			
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x++;
	  				}
	  				
	  				if(x>line-1||x<0||y>cha-1||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  						break; //girl
	  					}
	  				else if(map[x][y]==2){
	  						count++;
	  						break; //finish
	  					}
	  				
	  			}              //2:0123syzx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //3:0123sxzy
	  			
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //4: 0123sxyz
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //5: 0123szyx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //6: 0123szxy
	  			
	  			//
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x++;
	  				}
	  				
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //1:1230syxz
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //2:1230syzx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //3:1230sxzy
	  			
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //4: 1230sxyz
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //5: 1230szyx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //6: 1230szxy
	  			
	  			 //
	  			
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				
	  			}              //1:2301syxz
	  			
	  			x=begin;
	  			y=end;
	  			
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y++;
	  				}
	  				
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //2:2301syzx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //3:2301sxzy
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //4: 2301sxyz
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //5: 2301szyx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //6: 2301szxy
	  			
	  			//
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x++;
	  				}
	  				
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //1:3012syxz
	  			
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x--;
	  				}
	  			
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //2:3012syzx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x++;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //3:3012sxzy
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //4: 3012sxyz
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					y--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					x--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //5: 3012szyx
	  			x=begin;
	  			y=end;
	  			for(int j=0; j<move.length();j++){
	  				if((int)move.charAt(j)==48){
	  					y++;
	  				}
	  				else if((int)move.charAt(j)==49){
	  					x++;
	  				}
	  				else if((int)move.charAt(j)==50){
	  					x--;
	  				}
	  				else if((int)move.charAt(j)==51){
	  					y--;
	  				}
	  				if(x>=line||x<0||y>=cha||y<0){
	  					break;
	  				}
	  				else if(map[x][y]==-1){
	  					break; //girl
	  				}
	  				else if(map[x][y]==2){
	  					count++;
	  					break; //finish
	  				}
	  			}              //6: 3012szxy
	  			out.println(count);
	  		}
	  		
	  	}
	  	
}