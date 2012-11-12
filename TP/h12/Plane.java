package com.wordpress.lukistar.plain.homework12;

public class Plane {
	
	private int capacity = 162;
	private int sum = 0;
	private Human[][] seats = new Human[27][6];
	private int men = 0;
	private int women = 0;

	public int freeSeats() {
		return capacity-sum;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getMen() {
		return men;
	}
	public int getWomen() {
		return women;
	}
	public void info() {
		print();
		System.out.println("Free seats: " + freeSeats());
		System.out.println("Capacity: " + getCapacity());
		System.out.println("Men: " + getMen());
		System.out.println("Women: " + getWomen());
	}
	public void remove(Human human) {
		boolean found = false;
		for (int i = 0; i < 27; i++) {
			for (int i2 = 0; i2 < 6; i2++) {
				if (seats[i][i2] == human) {
					found = true;
					seats[i][i2] = null;
				}
			}
		}
		if (found == true) {
			System.out.println("The human has been removed");
		} else System.out.println("The human that you are looking for is not in the plane"); 
	}
	public void infoSeat(int i, int i2) {
		if (i <= 26 && i >= 0 && i2 <=5 && i2 >= 0) {
			if (seats[i][i2] == null) System.out.println("The seat is free");
			else {
				System.out.println("The seat is taken by: ");
				System.out.println("Name: " + seats[i][i2].getName());
				System.out.println("Age: " + seats[i][i2].getAge());
				System.out.println("Gender: " + seats[i][i2].getGender());
			}
		} else System.out.println("The is not such a seat");
		
	}
	public void print() { //print the seats of the plane in 6 columns(1 = tаken, 0 = free)
		for(Human seats1[]:seats) {
			int count = 0;
			for(Human seat:seats1) {
				//seat.print();
				if (seat == null) {
					System.out.print("0");
					count++;
				}
				else {
					System.out.print("1");
					count++;
				}
				if (count == 3){
					System.out.print(" ");
					count = 0;
				}
			}
			System.out.println();
		}
	}
	public void add(Human human1) {
		loops:
		for(int pos1 = 0; pos1 < 27; pos1++) {
			for (int pos2 = 0; pos2 < 6; pos2++) {
				if (seats[pos1][pos2] == null) {
					seats[pos1][pos2] = human1;
					sum+=1;
					gender(human1);
					break loops;
				}
			}
		}
	}
	public void add(Human human1, Human human2) {
		loops:
		for(int pos1 = 0; pos1 < 27; pos1++) {
			for (int pos2 = 0; pos2 < 6; pos2++) {
				if (pos2 != 2 && pos2 < 5 && seats[pos1][pos2] == null && seats[pos1][pos2+1] == null) {
					seats[pos1][pos2] = human1;
					seats[pos1][pos2+1] = human2;
					sum+=2;
					gender(human1);
					gender(human2);
					break loops;
				}
			}
		}
	}
	public void add(Human human1, Human human2, Human human3) {
		loops:
		for(int pos1 = 0; pos1 < 27; pos1++) {
			for (int pos2 = 0; pos2 < 6; pos2++) {
				if ((pos2 == 0 || pos2 == 3) && seats[pos1][pos2] == null && seats[pos1][pos2+1] == null && seats[pos1][pos2+1] == null) {
					seats[pos1][pos2] = human1;
					seats[pos1][pos2+1] = human2;
					seats[pos1][pos2+2] = human3;
					sum+=3;
					gender(human1);
					gender(human2);
					gender(human3);
					break loops;
				}
			}
		}
	}
	public void gender(Human human) {
		if (human.getGender() == "man") {
			men+=1;
		} else {
			women+=1;
		}
	}
}
