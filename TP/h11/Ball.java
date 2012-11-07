/*
#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се реализират класове Ball, BallContainer, Box
Класът Ball да има притежава член-променлива капацитет
Класът BallContainer съдържа методите: 1. add(Ball) 2. remove(Ball) 3. getCapacity() 4. size() 5. clear() 6. contains(Ball)
Класът Box да наследява BallContainer. Box да има максимален капацитет. Трябва да се преправи add() и да се добави нов метод getBallsFromSmallest() 
*/
package com.wordpress.lukistar.homework11;

public class Ball implements Comparable<Ball>{
	private double capacity;
	private int id;
	
	public Ball(double set_capacity, int set_id) {
		capacity = set_capacity;
		id = set_id;
	}
	public Ball() {
		capacity = 1.0;
		id = 0;
	}
	public int get_id() {
		return id;
	}
	public void setId(int id2) {
		id = id2;	
	}
	public double get_capacity() {
		return capacity;
	}
	public void setCapacity(double cap) {
		capacity = cap;	
	}
	public int compareTo(Ball compareBall) {
		 
		double compareCapacity = ((Ball) compareBall).get_capacity(); 
 
		//ascending order
		return (int)(this.capacity - compareCapacity);
 
		//descending order
		//return (int)(compareCapacity - capacity);
	}
}
