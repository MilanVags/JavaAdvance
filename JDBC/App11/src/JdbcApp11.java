import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp11 {
public static void main(String[] args) {
	
	Connection con=null;
	Statement st=null;
	ResultSet rs =null;
	
	
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
	st=con.createStatement();
	rs=st.executeQuery("update emp1 set salary=salary-500 where salary>1000");
	int rowCount=st.getUpdateCount();
	System.out.println("records updated"+rowCount);
		
		
		
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
