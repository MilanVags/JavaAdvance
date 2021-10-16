import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		Statement st=null;
		Connection con=null;
		
		try {
//			Load And register The driver
			Class.forName("oracle.jdbc.OracleDriver");
//			establish connection
		 con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
			System.out.println("------------------CONNECTION SUCCESS---------------");
//			create statement
		 st= con.createStatement();
		 int r=st.executeUpdate("delete from emp1 where salary<1500");
		 System.out.println(r);
//		System.out.println(rowCount);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		
		}

	}

}
