package basics_otherbook;

import java.util.HashMap;
import java.util.Map.Entry;

public class hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> hp=
				new HashMap<Integer,String>();
		//Storing data to hash map
		hp.put(101,"kalam");
		hp.put(102,"Steve jobs");
		hp.put(103,"Sachin");
		//Getting data from hash map
		for(Entry<Integer,String> m:hp.entrySet())              
		{  
			 System.out.println(m.getValue());  
		} 
	}

}
