import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
			System.out.println("-----------CONNECTION SUCCESFULL---------------");
			st =con.createStatement();
			br= new BufferedReader(new InputStreamReader(System.in)) ;
		
			System.out.println("Enter Bonus Amt");
			float bonusAmt=Float.parseFloat(br.readLine());
		System.out.println("update emp1 set salary=salary+"+bonusAmt+" where salary>500 ");
	boolean rowCount =st.execute("update emp1 set salary=salary+100 where salary>500");
			System.out.println(rowCount);
				System.out.println("------------Successfull----------");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
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
