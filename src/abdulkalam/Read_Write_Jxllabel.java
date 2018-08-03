package abdulkalam;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
public class Read_Write_Jxllabel {

	public static void main(String[] args) throws Exception {
		File f=new File("Number1.xls");
		//open that excel file for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);//0 means sheet1
		int nour=rsh.getRows();
		//open that excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);
		//data driven from 2nd row(index is 1)
		for(int i=1;i<nour;i++) {
			int x=Integer.parseInt(rsh.getCell(0,i).getContents());
			int y=Integer.parseInt(rsh.getCell(1,i).getContents());
			int z=x+y;
			Number n=new Number(2,i,z);//data packing 2 for coiumn i for row z for o/p
			wsh.addCell(n);
		}
		//save excel
		wwb.write();
		wwb.close();
		rwb.close();
		
	}

}
