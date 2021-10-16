import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement st=null;
		FileOutputStream fos=null;
		ResultSet rs=null;
		try {
		Class.forName("oracle.jdbc.OracleDriver")	;
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
        st=con.createStatement();
		rs=st.executeQuery("select * from emp1");
         String data="";
         data=data+"<html><body><table align='center' border='1'>";
         data=data+"<tr>  <th>Id</th>\r\n"
         		+ "    <th>Name</th>\r\n"
         		+ "    <th>Salary</th>"+"</tr>";
     	while(rs.next())
		{
			data=data+"<tr>"+
		"<th>"+rs.getInt(1)+"</th>"
		+"<th>"+rs.getString(2)+"</th>"
		+"<th>"+rs.getFloat(3)+"</th>"
		+"</tr>";
			
		}
     	
     	fos=new FileOutputStream("D:/html/emp1.html");
     	byte[] b=data.getBytes();
     	fos.write(b);
     	System.out.println("data transfered");
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
