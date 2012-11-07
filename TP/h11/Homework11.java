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

public class Homework11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box1 = new Box(10);
		Ball b1 = new Ball (5.0, 1);
		System.out.println("Test add() 1: ");
		box1.add(b1);
		System.out.println("Test add() 2: ");
		box1.add(b1);
		Ball b2 = new Ball (5, 2);
		Ball b3 = new Ball (1, 3);
		System.out.println("Test add() 3: ");
		box1.add(b2);
		System.out.println("Test add() 4: ");
		box1.add(b3);
		System.out.println("Test remove() 1: ");
		box1.remove(b1);
		System.out.println("Test remove() 2: ");
		box1.remove(b1);
		
		System.out.println("Test getBallsFromSmallest() 1: ");
		Box box2 = new Box(30);
		Ball b4 = new Ball(10, 4);
		Ball b5 = new Ball(5, 5);
		Ball b6 = new Ball(7, 6);
		box2.add(b4);
		box2.add(b5);
		box2.add(b6);
		Box box3 = box2.getBallsFromSmallest();
		box3.print();
		
	}
}
