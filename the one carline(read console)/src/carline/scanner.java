package carline;
import java.io.*;  
import java.util.Scanner;
import java.util.ArrayList;

public class scanner {
	public static ArrayList<family> list = new ArrayList<family>();
	
	
	
	public static void begin() throws Exception {
		Scanner sc= new Scanner(new BufferedReader(new FileReader("C:\\Users\\patel\\Downloads\\Firstnamelist.csv")));
		sc.nextLine();

		while(sc.hasNextLine()) {
			String each = sc.nextLine();
		
			list.add(new family(each));

		}
		sc.close();  //closes the scanner	
		
		
		}
		
		
		}  

