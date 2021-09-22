//Dylan Bearman
//R00190268
import java.text.DecimalFormat;
import java.util.Scanner;
public class PaperRollCuttingBottomUp {
	
	public static void Cheapest(int length) {
		//initialize everything
		int s[] = new int[length+1];
		double r[] = new double[length+1];
		double p[] = new double[6];
		p[0] = 0;
		p[1] = (double) 1.20;
		p[2] = 3;
		p[3] = (double) 5.80;
		p[4] = 0;
		p[5] = (double) 10.10;
		
		//check to see if the length is an invalid int
		if (length <= 0) {
			System.out.println("The rod must be greater then 0 and can only be whole numbers");
		}

		//compute the highest revenue for a rod of n and where cuts were made
		else {
			for(int j = 1; j < length+1; j++) {
			    double q = Integer.MIN_VALUE;
				for (int i = 1; i < p.length; i++) {
					if (j-i >= 0) {
						if (q < p[i] +r[j-i]) {
							q = p[i] + r[j-i];
							s[j] = i;
						}
					}
					r[j] = q;
				}
			}
			
			//print out results to the screen
			System.out.println("");
			DecimalFormat df = new DecimalFormat("0.00");
			System.out.println("Revenue for rod length " + length + ": " + df.format(r[r.length-1]));
			System.out.println("");
			System.out.println("CUT        LENGTH        PRICE");
			for(int x = 1; length > 0; x++) {
				System.out.println("Cut" + x + ":      " + s[length] + "             " + p[s[length]]);
				length = length - s[length];
			}
		}  
	}

	public static void main(String[] args) {
		//receive the length as an input and pass it into the function
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);   
		System.out.print("Enter Length(whole numbers): ");  
		int length= sc.nextInt(); 
		Cheapest(length);
	}
}
