import java.io.*;
import java.util.Arrays;
public class csv {
	
	public static void main(String[] arg) throws Exception {
	BufferedReader CSVFile = new BufferedReader(new FileReader("Example.csv"));	
	String dataRow = CSVFile.readLine();
	if (dataRow != null) dataRow = CSVFile.readLine();
	int suma = 0;
	while (dataRow != null) {
   		String[] dataArray = dataRow.split(",");
		suma = suma + Integer.parseInt(dataArray[4].toString());
		dataRow = CSVFile.readLine();
		
	}
	CSVFile.close();
	System.out.println(suma);
	
	
	}

}

