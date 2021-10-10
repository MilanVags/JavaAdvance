
public class ExceptionHadling {
		public static void main(String[] args) {
			Student s1=new Student("MIlan", "india", "mumbai", 150);
			s1.getData();
		}
		
}

class Student 
{
	String name;
	String add;
	String loc;
	int marks;
	
	public Student(String name,String add,String loc,int marks) {
		// TODO Auto-generated constructor stub
		this.marks=marks;
		this.name=name;
		this.loc=loc;
		this.add=add;	
	}
	public void getData ()
	{
		System.out.println("---------------data-----------");
		System.out.println("Student Name        :"+name);
		System.out.println("Student Add        :"+add);
		System.out.println("Student location        :"+loc);
		System.out.println("Student marks        :"+marks);
		if(marks>=90&&marks<=0)
			System.out.println("Excellent");
		else
			throw new RuntimeException("Enter valid input");
		
	}
	
}