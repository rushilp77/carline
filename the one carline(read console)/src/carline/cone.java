package carline;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class cone extends scanner {
   // public int [] cararray = new int[30];
	public  static ArrayList<Integer> cars = new ArrayList<Integer>(Arrays.asList());


	/*public void carsarrive() {
		for(int i = 0; i<30; i++) {
			cararray[i] = i;
		}
		shuffleArray(cararray);
		for(int i = 0; i<30; i++) {
		cars.add(cararray[i]);
		}
	}
	
	public void assign() throws InterruptedException {
		for(int i = 0; i<cars.size()-4; i+=5) {
			for(int b=0; b<5; b++) {
				list.get(cars.get(i+b)).cone = cones[b];
				System.out.println(list.get(cars.get(i+b)).student1+ " and " + list.get(cars.get(i+b)).student2 + " must go to " + cones[b]);
			}
			Thread.sleep(2000);
			
		}
	}*/
	
	public ArrayList<String> inline() {
		ArrayList<String> toprint = new ArrayList<String>();
		int i = 0;

		while (i<6&&i<cars.size()) {
			if(cars.get(i)==898) {
				toprint.add("Placeholder barcode scanned");
				i++;
			}
			else if(cars.get(i)<0) {
				toprint.add("Scanning problem");
			}else {
				toprint.add((list.get(cars.get(i)).students));
						i++;
			}
		}

		return toprint;
	}
	
	public void remove()  {
		int i=0;
while(i<6&&cars.size()>0) {
	cars.remove(0);
	i++;
	//System.out.println(list.get(cars.get(i)).student1 + " has been removed");
}
		}
		
	
	public ArrayList<String> queue() {
		ArrayList<String> toprint = new ArrayList<String>();
		int i = 6;
		while (i<12&&i<cars.size()) {
			if(cars.get(i)==898) {
				toprint.add("Placeholder barcode scanned");
				i++;
			}
			else if(cars.get(i)<0) {
				toprint.add("Scanning problem");
			}else {
				toprint.add((list.get(cars.get(i)).students));	
				i++;
			}
		}
		return toprint;

		}
	
	
	public String returnLast() {
		if (cars.get(cars.size()-1)==898) {
			return ("Placeholder barcode scanned");
		}
		return((list.get(cars.get(cars.size()-1)).students));
	}

	
	


	
	
	


 /*static void shuffleArray(int[] ar)
{
  // If running on Java 6 or older, use `new Random()` on RHS here
  Random rnd = new Random();
  for (int i = ar.length - 1; i > 0; i--)
  {
    int index = rnd.nextInt(i + 1);
    // Simple swap
    int a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
  }
}*/
}
