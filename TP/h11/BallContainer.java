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
import java.util.ArrayList;

public class BallContainer {
	protected double capacity;
	protected ArrayList<Ball> cont = new ArrayList<Ball>();
	public BallContainer() {
		capacity = 0;
	}
	public void add(Ball object) {
		if (!cont.contains(object)) {
			cont.add(object);
			capacity+=object.get_capacity();
		}
	}
	public void remove(Ball object) {
		if (cont.contains(object)) {
			cont.remove(object);
			capacity-=object.get_capacity();
		}
		else {
			System.out.println("This ball is not in the container!");
		}
	}
	public double getCapacity() {
		return capacity;
	}
	public int size() {
		return cont.size();
	}
	public void clear() {
		cont.clear();
	}
	public Boolean contains(Ball object) {
		if (cont.contains(object)) {
			return true;
		}
		else {
			return false;
		}
	}
}	
