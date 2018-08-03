package sql;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) throws Exception {
		
		//emp1 table    user sowmya/sowmya
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sowmya", "sowmya");
		Statement stmt=con.createStatement();
		stmt.executeUpdate("insert into emp1 values (3,'pratap',28,60000,'02-08-90',12)");
		ResultSet rs=stmt.executeQuery("Select * from emp1");
		while(rs.next()) {
		
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6));
			
		}
		con.close();
	}

}
/*SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
SimpleDateFormat out = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

Date date = in.parse("2012-03-04 11:09:00.123");
String result = out.format(date);
System.out.println(result);*/