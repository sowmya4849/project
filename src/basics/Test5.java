package basics;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5 {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		String line="I was born in xxxx july xx";               
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
