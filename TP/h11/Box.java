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

import java.util.Collections;

public class Box extends BallContainer {
	private double finite_capacity;
	public Box(double max_capacity) {
		finite_capacity = max_capacity;
	}
	public void add(Ball object) {
		if (!cont.contains(object)) {
			if ((finite_capacity - capacity) >= object.get_capacity()) {
				cont.add(object);
				capacity+=object.get_capacity();
			}
			else {
				System.out.println("There is not enough free space in the box");
			}
		}
		else {
			System.out.println("The ball is already in the box");
		}
	}

	public Box getBallsFromSmallest() {
		Box result = new Box(finite_capacity);
		for (Ball cpy:cont) {
			result.add(cpy);
		}
		Collections.sort(result.cont);
		return result;
	}
	public void print() {
		for(Ball print_:cont) {
			System.out.println(print_.get_capacity());
		}
	}
}