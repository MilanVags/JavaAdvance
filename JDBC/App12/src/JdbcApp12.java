import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Connection con=null;
	Statement st=null;
	
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "123");
			st=con.createStatement();
			boolean b= st.execute("select * from emp1");
			System.out.println(b);
			ResultSet rs= st.getResultSet();
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");	
				System.out.print(rs.getInt(3)+"\n");
				
			}
			
		
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
