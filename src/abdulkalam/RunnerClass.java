package abdulkalam;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class RunnerClass {

	public static void main(String[] args) throws Exception {

		//connect to Excel file
		File f=new File("keyworddrivenfw.xls");
		//open excel file for reading
		Workbook rwb=Workbook. getWorkbook(f) ;
		Sheet rsh1=rwb.getSheet(0);//0 for sheet1(tests)
		int not=rsh1.getRows();//no of tests
		int  nouc1=rsh1.getColumns();
		Sheet rsh2=rwb.getSheet(1);//1 for sheet2(steps)
		int nos=rsh2.getRows();
		int  nouc2=rsh2.getColumns();
		//open same excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh1=wwb.getSheet(0);//0 means sheet1 for test results
		WritableSheet wsh2=wwb.getSheet(1);//1 means sheet2 for step results
		System.out.println(nouc1+""+nouc2);
		//set name to result column in sheet2
		Date dt=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String cname=df.format(dt);
		Label l1=new Label(nouc2,0,cname);
		wsh2.addCell(l1);
		//set name to result column in sheet1
		Label l2=new Label(nouc1,0,cname);
		wsh1.addCell(l2);
		//create object to methods class
		Gmailmethods gm=new Gmailmethods();
		//collect methods information using methods class object
		Method m[]=gm.getClass().getMethods();
		//calling methods one after other
		//1st row (index is 0)have names of columns in sheet1
		for(int i=1;i<not;i++) {//from 2nd row(index is 1)
			int flag=0;
			//get tid and mode from sheet1
			String tid=rsh1.getCell(0, i).getContents();
			String mode=rsh1.getCell(2, i).getContents();
			if(mode.equalsIgnoreCase("yes")) {
				//1st row(index is 0)have names of cols in sheet2
				for(int j=1;j<nos;j++) {
					String sid=rsh2.getCell(0,j).getContents();
					if(tid.equalsIgnoreCase(sid)) {
						//take step details from sheet2
						String mn=rsh2.getCell(2,j).getContents();
						String l=rsh2.getCell(3,j).getContents();
						String d=rsh2.getCell(4,j).getContents();
						String c=rsh2.getCell(5,j).getContents();
						System.out.println(mn+""+l+""+d+""+c);
						for(int k=0;k<m.length;k++) {
							if(m[k].getName().equals(mn)) {
								String r=(String)m[k].invoke(gm, l,d,c);
								if(r.contains("failed")||r.contains("interrupted")) {
									flag=1;
								}
								Label lb=new Label(nouc2,j,r);
								wsh2.addCell(lb);
							}//if closing for k
						}// for k closing
					}
				}// for j closing
				if(flag==0) {
					Label l=new Label(nouc1,i,"passed");
					wsh1.addCell(l);
				}
				else {
					Label l=new Label(nouc1,i,"failed");
					wsh1.addCell(l);
				}
			}// if condition closing for mode
		}//for i closing
		//save and close excel
		wwb.write();
		wwb.close();
		rwb.close();

	}

}
