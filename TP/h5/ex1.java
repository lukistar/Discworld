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
public class ex1 {

	public static void main(String[] argc) {
		int size = argc.length;
		String[] in_argc = new String[size];
		in_argc = argc;
		String[] out_argc = new String[size];
		int count = 0;
		for (String str:in_argc) {
			if (System.getProperty(str) != null) {
				out_argc[count] = System.getProperty(str);
				count++;
			}
		}
		if (in_argc[size-1].equals("down")) {
			for (int count2 = count-1; count2 >= 0; count2--) {
				System.out.println(out_argc[count2]);
			}
		}
		else {
			for (int count2 = 0; count2 < count; count2++) {
                                System.out.println(out_argc[count2]);
			}
		}
	}





}
