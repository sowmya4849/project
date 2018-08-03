package abdulkalam;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exonmethods {

	public static void main(String[] args) throws Exception {
		
		Gmailmethods obj=new Gmailmethods();
		Method m[]=obj.getClass().getMethods();
	   for(int i=0;i<m.length;i++) {
			System.out.println(m[i].getName());
		//	String r=	(String) m[0].invoke(obj, "N/A","N/A","N/A");
		//	System.out.println(r);
		}
		
	}

}
