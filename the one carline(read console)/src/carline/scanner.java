package carline;
import java.io.*;  
import java.util.Scanner;
import java.util.ArrayList;

public class scanner {
	public static ArrayList<family> list = new ArrayList<family>();
	
	
	
	public static void begin() throws Exception {
		Scanner sc= new Scanner(new BufferedReader(new FileReader("C:\\Users\\patel\\Downloads\\demo.csv")));
		sc.useDelimiter(",");
		sc.nextLine();

		while(sc.hasNextLine()) {
			String each = sc.nextLine();
		String[] record = each.split(",");
		if (record.length == 2)
			list.add(new family(record[1]));
		
		else if (record.length == 3)
			list.add(new family(record[1], record[2]));

		else if (record.length == 4)
			list.add(new family(record[1], record[2], record[3]));

		}
		sc.close();  //closes the scanner	
		
		
		}
		
		
		}  

