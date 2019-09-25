package week1;
import java.util.*;

public class Print2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){         //each case
			int length = input.nextInt();
			int width = input.nextInt();
			int height = input.nextInt();
			
			for(int j=0; j<2*width+2*height+1; j++){  //each line
				
				if(j<=2*width){
					
					if(j<=2*height){
						
						if(j%2==0){  //j<=2*width j<=2*height j%2==0
							for(int k=0; k<2*width-j; k++){
								System.out.print(".");
							}
							for(int k=0; k<length; k++){
								System.out.print("+-");
							}
							System.out.print("+");
							for(int k=0; k<j/2; k++){
								System.out.print(".+");
							}
							System.out.println();
						}
						
						if(j%2==1){  //j<=2*width j<=2*height j%2==1
							for(int k=0; k<2*width-j; k++){
								System.out.print(".");
							}
							for(int k=0; k<length; k++){
								System.out.print("/.");
							}
							for(int k=0; k<(j+1)/2; k++){
								System.out.print("/|");
							}
							System.out.println();
						}
					}
					
					
				if(j>2*height){   
						if(j%2==0){ //j<=2*width j>2*height j%2==0
							for(int k=0; k<2*width-j; k++){
								System.out.print(".");
							}
							for(int k=0; k<length; k++){
								System.out.print("+-");
							}
							System.out.print("+");
							for(int k=0; k<height; k++){    //j/2_height
								System.out.print(".+"); 
							}
							for(int k=0; k<j-2*height; k++){ //j_j/2 j-2*height
								System.out.print(".");            //
							}
							System.out.println();
						}
						
						if(j%2==1){ //j<=2*width j>2*height j%2==1
							
							for(int k=0; k<2*width-j; k++){
								System.out.print(".");
							}
							for(int k=0; k<length; k++){
								System.out.print("/.");
							}
							for(int k=0; k<height; k++){  //(j+1)/2_height
								System.out.print("/|");
							}
							System.out.print("/");
							
							for(int k=0; k<j-2*height; k++){ //j_j/2 j-2*height
								System.out.print(".");            //
							}
							System.out.println();
						}
						}
				}//check
			
				if(j>2*width){ 
					if(j>=2*height){
						if(j%2==1){
							for(int k=0; k<length; k++){
							System.out.print("|.");
							}
							for(int k=0; k<height+width+1-(j+1)/2; k++){
								System.out.print("|/");
							}
							for(int k=0; k<j-2*height; k++){ //j_j/2 j-2*height
								System.out.print(".");            //
							}
							System.out.println();
						}
						if(j%2==0){
							for(int k=0; k<length; k++){
								System.out.print("+-");
							}
							System.out.print("+");
							for(int k=0; k<width+height-(j+1)/2; k++){     //change-1
								System.out.print(".+");
							}
							for(int k=0; k<j-2*height; k++){       //-1
								System.out.print(".");
							}
							System.out.println();
						}
					}
					if(j<2*height){
						if(j%2==1){
							for(int k=0; k<length; k++){
								System.out.print("|.");
							}
							System.out.print("|");
							for(int k=0; k<width; k++){
								System.out.print("/|");
							}
							System.out.println();
						}
						if(j%2==0){
							for(int k=0; k<length; k++){
								System.out.print("+-");
							}
							System.out.print("+");
							for(int k=0; k<width; k++){
								System.out.print(".+");
							}
							System.out.println();
						}
					}
				}
			}
		}
}
}