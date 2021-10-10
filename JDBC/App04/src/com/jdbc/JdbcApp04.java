package com.jdbc;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
//create table emp1(ENO number (3), ENAME varchar2(10), ESAL float (5), EADDR varchar2(19), primary key (ENO, ENAME))

public class JdbcApp04 {

	public static void main(String[]  args)throws Exception {
		// TODO Auto-generated method stub
//		Load And register The driver
		Class.forName("oracle.jdbc.OracleDriver");
//		establish connection
		Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
		System.out.println("------------------CONNECTION SUCCESS---------------");
//		create statement
		Statement st= con.createStatement();

		
		BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
		String query ="create table ";
		System.out.print("ENTER TABLE NAME                     :");
		String TableName=br.readLine();
		query=query+TableName+"(";
		
		String PrimaryKeyColumn="";
		int PrimaryKeyColumnCount=0;
		
		while(true)
		{
			System.out.print("ColumnName       :");
			String ColumnName=br.readLine();
			System.out.print("ColumnDataType  :");
			String ColumnDataType=br.readLine();
			System.out.print(" ColumnSize     ");
			int ColumnSize=Integer.parseInt(br.readLine());
			System.out.print("IS THERE A PRIMARY KEY [YES?NO]");
			String PrimaryKeyOption=br.readLine();
	
			if(PrimaryKeyOption.equalsIgnoreCase("yes"))
			{
				
				if( PrimaryKeyColumnCount==0)
				{
					PrimaryKeyColumn=PrimaryKeyColumn+ColumnName;
					PrimaryKeyColumnCount=PrimaryKeyColumnCount+1;
				}else
				{
					PrimaryKeyColumn=PrimaryKeyColumn+","+ColumnName;
				}
			}
			query+=ColumnName+" "+ColumnDataType+"("+ColumnSize+"),";
			System.out.print("OneMoreColumn [Yes/no]");
			String ColumnOption=br.readLine();
			if(ColumnOption.equalsIgnoreCase("yes"))
			{
				continue;
			}
			else
			{
				query=query+"primary key("+PrimaryKeyColumn+"))";
				break;
			}
		}
		System.out.println(query);
		
		st.executeUpdate(query);
		con.close();
		st.close();
		br.close();
		

	}


}

