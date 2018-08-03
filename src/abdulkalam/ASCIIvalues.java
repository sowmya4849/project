package abdulkalam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class ASCIIvalues {

	public static void main(String[] args) throws Exception {
		//open 1st file for reading
       File f1=new File("ASCII values.txt");
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		//open 2nd file for writing
		 File f2=new File("ASCII results.txt");
		 FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw);
		//data driven
		String l="";
		int ucc=0;int lcc=0;int dc=0;int scc=0;
		while((l=br.readLine())!=null)//reading line by line
		{
			for(int i=0;i<l.length();i++) {// reading char by char in each line 
				char c=l.charAt(i);//converting each char with ASCII value
				if(c>=97&&c<=122) {
					lcc=lcc+1;
				}
				else if(c>=65 &&c<=90) {
					ucc=ucc+1;
				}
				else if(c>=48 &&c<=57) {
					dc=dc+1;
				}
				else {
					scc=scc+1;
				}
			}
		}
		//make output
		bw.write("count of lowercase letters is"+lcc);
		bw.newLine();
		bw.write("count of uppercase letters is"+ucc);
		bw.newLine();
		bw.write("count of digits  is"+dc);
		bw.newLine();
		bw.write("count of special chars is"+scc);
		bw.newLine();
		//close files
		bw.close();
		fw.close();
		fr.close();
		br.close();
	}

}
