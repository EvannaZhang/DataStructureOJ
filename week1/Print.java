package week1;
import java.util.*;

public class Print {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){         //each case
			int length = input.nextInt();
			int width = input.nextInt();
			int height = input.nextInt();
			for(int j=0; j<=(width+height)*2+1; j++){
				if(j==1)
				{                       //第一行
					for(int k=0; k<2*width; k++){
						System.out.print(".");
					}
					for(int k=0; k<length; k++){
						System.out.print("+-");
					}
					System.out.println("+");
				}
				
				if(j<=2*width && j%2==0 && j>1){ 
					 //偶数 大于1 小于等于二倍宽
					for(int k=0; k<2*width+1-j; k++){
						System.out.print(".");
					}
					for(int k=0; k<length; k++){
						System.out.print("/.");
					}
					for(int k=0; k<j/2; k++){
						System.out.print("/|");
					}System.out.println();
				}
				
				if(j<=2*width && j%2==1 && j>1){      //奇数 大于一 小于等于二倍宽
					for(int k=0; k<2*width+1-j; k++){
						System.out.print(".");
					}
					for(int k=0; k<length; k++){
						System.out.print("+-");
					}
					for(int k=0; k<(j-1)/2; k++){
						System.out.print("+.");
					}System.out.println("+");
				}                                           //上部分结束
			
				if(height>=width &&j>2*width && j<=height*2+1 && j%2==1){
					for(int k=0; k<length; k++){
						System.out.print("+-");
					}
					System.out.print("+");
					for(int k=0; k<width; k++){
						System.out.print(".+");
					}
					System.out.println();
				}                                              //奇数 中间
				if(height>=width && j>2*width && j<=height*2+1 && j%2==0){
			
					for(int k=0; k<length; k++){
						System.out.print("|.");
					}
					System.out.print("|");
					for(int k=0; k<width; k++){
						System.out.print("/|");
					}
					System.out.println();
				}                                           //偶数 中间
				
				if(j>height*2+1 && j%2==0 && j<=(width+height)*2+1){
				
					for(int k=0; k<length; k++){
						System.out.print("|.");
					}
					for(int k=0; k<width+height+1-j/2; k++){
						System.out.print("|/");
					}
					for(int k=0; k<j-2*height-1; k++){
						System.out.print(".");
					}
						System.out.println();
					}
				
					if(j>height*2+1 && j%2==1 && j<=(width+height)*2+1){
					 
						for(int k=0; k<length; k++){
							System.out.print("+-");
						}
						System.out.print("+");
						for(int k=0; k<width+height-(j-1)/2; k++){
							System.out.print(".+");
						}
						for(int k=0; k<j-2*height-1; k++){
							System.out.print(".");
						}
					System.out.println();
				}
			
			}
	}
	}
}
