package basics_otherbook;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularexpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList a=new ArrayList();
		//String line="I was born in xxxx july xx"; 
		String line="HI thisx, IS"; 
	    Pattern r=Pattern.compile("[A-Z]+");
	    Matcher m=r.matcher(line);
	    while(m.find())
	    {
	     	a.add(m.group());
	    }  
	    //Display values in Array
	    for(int i=0;i<a.size();i++)
	    {
	    	System.out.println(a.get(i));
	    }
	}

}
