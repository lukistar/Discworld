package com.wordpress.lukistar.plain.homework12;

import java.util.Random;
//stupid class for "generating" "random" humans...
public class RandomHuman {
	private int age;
	private String name;
	private String gender;
	public Human get() {
		age = new Random().nextInt(100);
		int randomGender = new Random().nextInt(2);
		if (randomGender == 0) {
			gender = "man";
			int RandomName = new Random().nextInt(8);
			name = names1[RandomName];
		} else {
			gender = "woman";
			int RandomName = new Random().nextInt(8);
			name = names2[RandomName];
		}
		
		return new Human(name, age, gender);
	}
	private String[] names1 = {
		"Rand al'Thor",
		"Mazrim Taim",
		"Logain Ablar",
		"Elan Morin Tedronai",
		"Joar Addam Nessosin",
		"Jon Snow",
		"Jaime Lannister",
		"Tyrion Lannister",
	};
	private String[] names2 = {
		"Moiraine Damodred",
		"Nynaeve al'Meara",
		"Mierin Eronaile",
		"Kamarile Maradim Nindar",
		"Lilen Moiral",
		"Nemene Damendar Boann",
		"Verin Mathwin",
		"Saine Tarasind"
	};
}
