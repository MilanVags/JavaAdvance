import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement st=null;
		
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
		st=con.createStatement();
		boolean b=st.execute("update emp1 set salary=salary-100 where salary>1000");
		System.out.println(b);
		int RowCount=st.getUpdateCount();
		System.out.println(RowCount);
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			e2.printStackTrace();
			}
		}
	}

}
