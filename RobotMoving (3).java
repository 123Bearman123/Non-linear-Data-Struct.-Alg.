//DYLAN BEARMAN
//R00190268
import java.text.DecimalFormat;
import java.util.Scanner;

public class RobotMoving {
	//Initialize everything
	double T [][];
	String maze [][];
	double cost = 0;
	
	public void Shortest(int n, double x, double y, double z) {
			//Initialize everything
			double cost = 0;
			double R = x;
			double D = y;
			double DR = z;
			T = new double [n][n];
			maze = new String [n][n];
			//Here we have two matrixs, One with words and the other with numbers
			//For this for loop we fill in the info for the first row (---)
			for (int j = 1; j < n; j ++) {
				T[0][j] = T[0][j-1] + R;
				maze [0][j] = "R";
			}
			
			//We fill the rest of the information here and add the cost to a variable called cost
			for (int i = 1; i < n; i ++) {
				T[i][0] = T[i-1][0] + D;
				maze [i][0] = "D";
				
				for(int j= 1; j < n; j++) {
					//check which costs the less out of all the 3 costs
					if ((T[i][j-1] + R) < (T[i-1][j-1] + DR)) {
						maze[i][j] = "R";
						cost = (T[i][j-1] + R);
					}
					else if ((T[i-1][j] + D) < (T[i-1][j-1] + DR)) {
						maze[i][j] = "D";
						cost = (T[i-1][j] + D);
					}
					else { 
						maze[i][j] = "DR";
						cost = (T[i-1][j-1] + DR);
					}
					T[i][j] = cost;
					
				}
			}
			DecimalFormat df = new DecimalFormat("0.00");
			DecimalFormat d = new DecimalFormat("00");
			

			//We print out the total cost here and print out every move
			System.out.println("\nTotal Cost: €" + df.format(T[n-1][n-1]));
			int i = T.length - 1;
			int j = T.length - 1;
			System.out.println("MOVE     DIRECTION     COST");
			while (i != -1 && j != -1) {
				for (int q = 1; q < Integer.MAX_VALUE; q ++) {
				if (maze [i][j] == "R") {
					j--;
					System.out.println(d.format(q) + "        Right        €" + x);
					}
				else if (maze [i][j] == "D") {
					i--;
					System.out.println(d.format(q) + "        Down         €" + y);
					}
				else if (maze [i][j] == "DR") {
					i--;
					j--;
					System.out.println(d.format(q) + "        Diagnol      €" + z);
				}
				}
				
			}


	}

	public static void main(String[] args) {		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);  
		System.out.print("Enter Matrix(n x n): ");
		int matrix= sc.nextInt();
		System.out.println("");
		System.out.print(" DIRECTION     COST 1    COST 2\n Right:        1.1       1.5 \n "
				+ "Down:         1.3       1.2 \n Diagnol:      2.5       2.3\n");
		System.out.println("");
		System.out.print("Please choose your preferred cost: ");
		int cost = sc.nextInt();
		while (!(cost == 1 || cost == 2)) {
			System.out.print("Please choose your preferred cost: ");
			cost = sc.nextInt();
		}
		RobotMoving rm = new RobotMoving ();
		if (cost == 1) {
			 double x = 1.1;
			 double y = 1.3;
			 double z = 2.5;
			rm.Shortest(matrix,x,y,z);
		}
		if (cost == 2) {
			double x = 1.5;
			double y = 1.2;
			double z = 2.3;
			rm.Shortest(matrix,x,y,z);
		}
		

	}

}