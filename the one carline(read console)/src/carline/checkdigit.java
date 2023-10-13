package carline;

public class checkdigit {
	
	public static boolean check (int number) {
		int sum = 0;
		String s= Integer.toString(number);
		int length = s.length();
		for (int i = length; i>0; i--) {
				if ((length-i)%2==0)
					sum+= Integer.parseInt(s.substring(i-1,i));
				else
					sum+= 3*Integer.parseInt(s.substring(i-1,i));
		}
		
		
		return (sum%10==0);
	}
	
	public static int encode(int number) {
		int sum = 0;
		String s= Integer.toString(number);
		int length = s.length();
		for (int i = length; i>0; i--) {
				if ((length-i)%2!=0)
					sum+= Integer.parseInt(s.substring(i-1,i));
				else
					sum+= 3*Integer.parseInt(s.substring(i-1,i));
		}
		
		number*=10;
		if(sum%10!=0) {
			number+=10-sum%10;
		}
		return (number);	}
	
	public static void main (String[]args) {
	/*	for (int i = 10; i<21; i++) {
			int num  =(int)(Math.random()*1000);
			int haha = encode(num);
			System.out.println(num);
			System.out.println(check(num));
			System.out.println(haha);
			System.out.println(check(haha));
			

			System.out.println("000000000"+(i));*/
			
		/*	System.out.println("bad "+num);
			System.out.print(check(num+1));*/
		//}
		
		//System.out.println(check(59130));
		
		/*System.out.println(check(00001));

		System.out.println(check(encode(00001)));
		System.out.println(check(17));

		System.out.println(check(157));
		System.out.println(check(encode(17)));

		System.out.println(check(encode(157)));*/
		
	/*	for (int i=0; i<10; i++) {
			String output = "0000000000"+encode(i);
			System.out.println(output);
		}
*/
	/*	for (int i=10; i<100; i++) {
			String output = "000000000"+encode(i);
			System.out.println(output);
		}*/
	int x = 400;
		for (int i=x; i<x+10; i++) {
			int output = encode(i);
			System.out.println("00000000"+output);
		}

	}
	
}
