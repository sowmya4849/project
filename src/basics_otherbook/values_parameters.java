package basics_otherbook;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class values_parameters {
	@Parameters({"input1","input2"})
	@Test(priority=1)
	public void method(String x,String y)
	{
		int z=Integer.parseInt(x)+Integer.parseInt(y);
		System.out.println(z);
	}
}
