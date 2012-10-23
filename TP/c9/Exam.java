/*
#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програмата взима име на csv файл от подадените й аргументи и събира числата от втората колонка от него. Извежда се сумата.
*/
import java.io.*;
public class Exam {
	public static void main(String[] args){
		String fileName=null;
		if (args.length > 0) {
			fileName=args[0];
		} else {
			System.out.println("Wrong filename");
		}
		int sum = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = reader.readLine())!=null) {
				sum+=Integer.parseInt(line.split(",")[1]);
			}
			System.out.println(sum);
		} catch(Exception e) {
		}
	}
}


