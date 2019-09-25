package week7;
import java.util.*;

public class A {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int nodes = input.nextInt();
			int[][] edge = new int[nodes+1][3];
			for(int j=1; j<=nodes; j++){
				int a = input.nextInt();
				int b = input.nextInt();
				edge[j][0] = a;
				edge[j][1] = b;
				edge[a][2] = j;
				edge[b][2] = -j;
			}
			boolean answer = true;
			if(nodes<1)
				answer= false;
			int only = 0;
			for(int j=1; j<=nodes; j++){
				if(edge[j][0]==0&edge[j][1]!=0){
					//左空右不空
					answer = false;
					break;
				}
				if(edge[j][1]==0&edge[j][0]!=0){
					//右空左不空
					only++;
					if(edge[edge[j][0]][0]!=0||edge[edge[j][0]][1]!=0){
						answer = false;
						break;
					}			
				}
				if(edge[j][1]!=0&edge[j][0]!=0){
					//均不为空
					int father = edge[j][2];
					if(father<0){
						if(edge[edge[-father][0]][0]==0||edge[edge[-father][0]][1]==0){
								answer = false;
								break;
						}
					}
				}
				if(only>1)
				{
					answer = false;
					break;
				}
			}
			if(answer)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
