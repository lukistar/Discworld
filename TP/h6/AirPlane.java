/*
#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програма за автоматично разпределяне на пътници по места в самолет 
*/
import java.util.Random;
public class AirPlane {
		private int[][] seats= new int[6][27];
		private int sum = 0;
		private boolean Break = false;
		
		public int freeSeats() {
				return 162-sum;
		}
		
		public void printArray() {		
		
			for(int br1 = 0; br1 < 27; br1++) {
				for (int br2 = 0; br2 < 6; br2++) {
					if (br2 == 3) System.out.print(" ");
					System.out.print(seats[br2][br1]);
				}
				System.out.println();
			}
		}


		public void add(int rvalue) {
			for(int j = 0; j < 27; j++) {
				for (int k = 0; k < 6; k++) {
					if (seats[k][j] == 0) { 
						if (rvalue == 1) {
							seats[k][j] = 1;						
							sum+=1;
							Break = true;
							break;					
						}
						if (rvalue == 2 && k<5 && k!=2 && seats[k+1][j] == 0) {
							seats[k][j] = 1;
							seats[k+1][j] = 1;	
							sum+=2;
							Break = true;
							break;
						}
						if (rvalue == 3 && (k == 0 || k == 3) && seats[k+1][j] == 0 && seats[k+2][j] == 0) {
							seats[k][j] = 1;
							seats[k+1][j] = 1;
							seats[k+2][j] = 1;
							sum+=3;
							Break = true;
							break;
						} 
					}
				}
				if (Break == true) {
					Break = false;
					break;
				}				
			}
	
		}
		
		public static void main(String args[]) {
			AirPlane plane = new AirPlane();

			while(plane.freeSeats() != 0) {
				int rvalue = new Random().nextInt(3)+1;
				if (plane.freeSeats() >= rvalue) {
					plane.add(rvalue);
				} else System.out.println("No seats for you!");
			}
			plane.printArray();
		} 
}


