package com.wordpress.lukistar.plain.homework12;

public class Human {
	
	private String name;
	private int age;
	private String gender;
	
	public Human(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public void print() {
		System.out.print("Name: ");
		System.out.println(name);
		System.out.print("Age: ");
		System.out.println(age);
		System.out.print("Gender: ");
		System.out.println(gender);
	}
}
