package basics_otherbook;

public class test1 {
	public static void main(String[] args)
	{
		Integer x=new Integer(10);
		Float y=new Float(20.89);
		Double z=new Double(x.intValue()*y.floatValue());
		System.out.println(z.doubleValue());
	}
}
