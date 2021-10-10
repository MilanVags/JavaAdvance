
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
			System.out.println("-----------CONNECTION SUCCESFULL---------------");
			st =con.createStatement();
			br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				 System.out.println("Enter employee ID     :");
				 int ID=Integer.parseInt(br.readLine());
				 System.out.println("Enter employee name   :");
				 String name=br.readLine();
				 System.out.println("Enter employee salary :");
				 float salary=Float.parseFloat(br.readLine());
				 System.out.println("insert into emp1 values("+ID+","+name+","+salary+")");
				 
				 int rowCount=st.executeUpdate("insert into emp1 values("+ID+","+"'"+name+"'"+","+salary+")");
				 if(rowCount==1)
				 {
					 System.out.println("record inserted of"+ID);
					 System.out.println("want to add more [yes/no]");
					 String option=br.readLine();
					 if(option.equalsIgnoreCase("yes"))
					 {
						 continue;
					 }
					 else
					 {
						 break;
					 }
					 
				 }
				 else
				 {
					 System.out.println(ID+"failure insertion");
					 
				 }
				 System.out.println("Do u want to add more[YES/NO]");
				 String option=br.readLine();
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
		}
	}

}
