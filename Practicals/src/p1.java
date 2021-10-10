import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;

public class p1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter text data :");
//		String fvalue=br.readLine();
//		System.out.println(fvalue);
//		System.out.println("Enter text data");
//		int Svalue=br.read();
//		System.out.println( (char)Svalue);
		
		
		
		//---------------------------------------------------------------------------------------------
		// add 2 num from buffered reader
		String a=br.readLine();
		String b=br.readLine();
		System.out.println(a+b);
		int c=Integer.parseInt(a);
		int d=Integer.parseInt(b);
		System.out.println(c+d);
		
	 
	}

}
