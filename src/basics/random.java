package basics;

import java.util.Random;

public class random {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();

		int Low = 1;
		int High = 100;
		int Result = r.nextInt(High-Low) + Low;
System.out.println(Result);
	}

}
