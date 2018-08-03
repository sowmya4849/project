package abdulkalam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternmatching {

	public static void main(String[] args) throws Exception {
		//open 1st file for reading
	       File f1=new File("ASCII values.txt");
			FileReader fr=new FileReader(f1);
			BufferedReader br=new BufferedReader(fr);
			//open 2nd file for writing
			 File f2=new File("ASCII nopattern.txt");
			 FileWriter fw=new FileWriter(f2);
			BufferedWriter bw=new BufferedWriter(fw);
		   //prepare reg exp
			Pattern p=Pattern.compile("[A-Z]+|[0-9]+");//number with 1 or more digits
			//data driven
			String l="";
			while((l=br.readLine())!=null)//reading line by line
			{
				Matcher m=p.matcher(l);
				while(m.find()) {
					bw.write(m.group());
					bw.newLine();
				}
			}
			//close files		
			bw.close();
			fw.close();
			fr.close();
			br.close();
		
		
		
	}

}
