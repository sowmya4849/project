package basics_otherbook;

public class split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="Chack De India";
		String[] y=x.split(" ");
		System.out.println("No: of words is "+y.length);       
		for(int i=0;i<y.length;i++)
		{
			System.out.println(y[i]);
		}
	}

}
