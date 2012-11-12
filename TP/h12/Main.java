/*
#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Самолетна подредба реализирана с класове и обекти.
*/

package com.wordpress.lukistar.plain.homework12;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Plane plane = new Plane();
		RandomHuman rh = new RandomHuman();
		while (plane.freeSeats() > 0) {
			int i = new Random().nextInt(3);
			if (i == 0) {
				plane.add(rh.get());
			} else if (i == 1) {
				plane.add(rh.get());
				plane.add(rh.get());	
			} else if (i == 2) {
				plane.add(rh.get());
				plane.add(rh.get());
				plane.add(rh.get());
			}
		}
		plane.info();
		plane.infoSeat(0, 0);
	}

}
