import java.io.FileInputStream;
import java.io.FileOutputStream;

public class p2 {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
//		FileOutputStream fos=new FileOutputStream("D:/thop tv/a.txt");
//		String s="im text file";
//		byte[]b=s.getBytes();
//		fos.write(b);
//		fos.close();
//		System.out.println("DONE.....");
//		
		FileInputStream fis= new FileInputStream("D:/thop tv/a.txt");
		int size =fis.available();
		byte[]a=new byte[size];
		a=fis.readAllBytes();
		String s=new String(a);
		System.out.println(s);
		fis.close();
		
	}

}
