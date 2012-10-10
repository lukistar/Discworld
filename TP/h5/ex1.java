/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се създаде програма, която да изкарва на екрана стойността на системните свойства по
зададени от командния ред имена на свойствата. Програмата трябва да приема и
невалидни имена. Ако последния подаден аргумент от командния ред е up то стойностите
показани в изхода трябва да са сортиран във възходящ ред. Ако последната стойност е
down изходът трябва да е сортиран в низходящ ред. Стойността по подразбиране, ако не е
посочено up или down, е up.
*/


import java.util.*;
import java.util.Arrays;
public class ex1 {

	public static void main(String[] argc) {
		boolean check = false;
		Vector<String> in_argc = new Vector<String>();
		int count = 0;
		for (String str : argc) {
			if (System.getProperty(str) != null) {
				in_argc.add(System.getProperty(str));
				count++;
			}
		}
		if (argc[argc.length-1].equals("down")) check = true;
		String[] out = new String[in_argc.size()];
		in_argc.toArray(out);
		if (check == false) Arrays.sort(out);
		else Arrays.sort(out, Collections.reverseOrder());
		for (String str2 : out) {
			System.out.println(str2);
		}
	}

}