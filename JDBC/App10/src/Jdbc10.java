import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class Jdbc10 {
	public static void main(String[] args) {
		BufferedReader br=null;
		Statement st=null;
		Connection con=null;
		ResultSet rs =null;
		
		
		try {
//			Load And register The driver
			Class.forName("oracle.jdbc.OracleDriver");
//			establish connection
		 con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
			System.out.println("------------------CONNECTION SUCCESS---------------");
//			create statement
		 st= con.createStatement();
		 rs=st.executeQuery("select * from emp1");
		 System.out.println("-----------------------------------------------------");
	while(rs.next()) {
		System.out.print(rs.getInt(1)+"\t");
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getFloat(3)+"\n");
	}
		 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				
			rs.close();
	
			st.close();
			con.close();
			
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
