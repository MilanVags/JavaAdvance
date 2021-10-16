
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc14b {

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
      
     	while(rs.next())
		{
			data=data+rs.getInt(1)+","+"\n"
		+rs.getString(2)+","
		+rs.getFloat(3)+",";	
		}
     	
     	fos=new FileOutputStream("D:/html/emp1.csv");
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
