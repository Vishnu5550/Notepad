package ita;

import javax.swing.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SaveData {
	public void dispDB(int a) {
		String dis="Date  Time           UserName       PassWord         Mail_Id            Action\n";
		int count=0,countu=0;
		
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			stmt=con.createStatement();
			if(a==1) {
			ResultSet rsc=stmt.executeQuery("SELECT count(*) FROM `trying_to_log` WHERE 1");
			while(rsc.next()) 
				 count=Integer.parseInt(rsc.getString(1));
			
			
			if(count>0) {
				String data[][]=new String[count][5];
				String col[]= {"UserName","Password","Gmail ID"," Action"," Time"};
				
			int row=0;
			ResultSet rs=stmt.executeQuery("SELECT * FROM `trying_to_log` WHERE 1");
			while(rs.next()) {
				//dis+="\'"+rs.getString(2)+"\' has Password= "+rs.getString(3)+" and gmail_id= "+rs.getString(5)+" has "+rs.getString(6)+" at "+rs.getString(1)+"\n ";
			data[row][0]=rs.getString(2);
			data[row][1]=rs.getString(3);
			data[row][2]=rs.getString(5);
			data[row][3]=rs.getString(6);
			data[row][4]=rs.getString(1);
			
			row++;
			}
			JFrame f=new JFrame();
			JTable jt=new JTable(data,col);
			JScrollPane sp=new JScrollPane(jt);
			jt.setBounds(100, 100, 800, 400);
			//f.add(jt);
			f.add(sp);
			f.setSize(1000, 1000);
			f.setVisible(true);
			}
			}
			else if(a==2) {
				ResultSet rscu=stmt.executeQuery("SELECT count(*) FROM `log_in` WHERE 1");
				while(rscu.next()) 
					 countu=Integer.parseInt(rscu.getString(1));
				
				if(countu>0) {
					String data[][]=new String[countu][3];
					String col[]= {"UserName","Password","Gmail ID"};
					
				int row=0;
				ResultSet rs=stmt.executeQuery("SELECT * FROM `log_in` WHERE 1");
				while(rs.next()) {
					//dis+="\'"+rs.getString(2)+"\' has Password= "+rs.getString(3)+" and gmail_id= "+rs.getString(5)+" has "+rs.getString(6)+" at "+rs.getString(1)+"\n ";
				data[row][0]=rs.getString(1);
				data[row][1]=rs.getString(2);
				data[row][2]=rs.getString(3);
				
				row++;
				}
				JFrame f=new JFrame();
				JTable jt=new JTable(data,col);
				JScrollPane sp=new JScrollPane(jt);
				jt.setBounds(100, 100, 800, 400);
				f.add(sp);
				f.setSize(1000, 1000);
				f.setVisible(true);
				
			}
			}
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
}
	public void signup(String usna, String pasw, String log) {
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
			DateTimeFormatter dft1=DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
			LocalDateTime now=LocalDateTime.now();
			stmt=con.createStatement();
			String email123 = "";
			ResultSet rs=stmt.executeQuery("SELECT `gmail` FROM `log_in` WHERE username='"+usna+"' ");
			while(rs.next()) 
				email123=rs.getString(1);

			stmt.executeUpdate("INSERT INTO `trying_to_log`(`DateTime`, `date`, `UserName`, `PassWord`,  `gmail_id`, `Trytolog`) VALUES ('"+dft.format(now)+"','"+dft1.format(now)+"','"+usna+"','"+pasw+"','"+email123+"','"+log+"')");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void log(String email,String usna, String pasw) {
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			stmt=con.createStatement();
			
			stmt.executeUpdate("INSERT INTO `log_in`(`UserName`, `PassWord`,  `gmail`) VALUES ('"+usna+"','"+pasw+"','"+email+"')");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}	}
	public void trytolog(String email,String usna, String pasw) {
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
			DateTimeFormatter dft1=DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
			LocalDateTime now=LocalDateTime.now();
			stmt=con.createStatement();
			
			stmt.executeUpdate("INSERT INTO `trying_to_log`(`DateTime`, `date`, `UserName`, `PassWord`,  `gmail_id`, `Trytolog`) VALUES ('"+dft.format(now)+"','"+dft1.format(now)+"','"+usna+"','"+pasw+"','"+email+"','tried')");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public int checkemail(String email,String User) {
		int c=0,n=0,d=0;
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			
			LocalDateTime now=LocalDateTime.now();
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT `gmail`,`username` FROM `log_in` WHERE 1 ");
			while(rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(email))
					c++;
				if(rs.getString(2).equalsIgnoreCase(User))
					n++;
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		if(c>0 || n>0) {
			if(c>n)
		return c;
			else
				return n;
		}
		else
		return 0;
	}
	public int checkus(String us) {
		int c=0;
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			
			LocalDateTime now=LocalDateTime.now();
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT `username` FROM `log_in` WHERE username='"+us+"'");
			while(rs.next()) {
				if(rs.getString(1).compareTo(us)==0)
					c++;
					
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}
	public void createdb(String us) {
		int c=0;
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			stmt=con.createStatement();
			stmt.executeUpdate("CREATE TABLE `trying`.`"+us+"` ( `file` BLOB NOT NULL ) ENGINE = InnoDB; ");
			con.close();
			System.out.println("database created succesfully\n");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public void insertfile(String us,String fp) {
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			stmt=con.createStatement();
			String sql = "INSERT INTO `"+us+"`(`file`) VALUES (?)";
			InputStream is = new FileInputStream(new File(fp));
			 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBlob(1, is);
           // ps.set
            int row = ps.executeUpdate();
            if (row > 0) {
            	JFrame mes=new JFrame("Inserted");
				JOptionPane.showMessageDialog(mes,"The selected file is inserted in database sucessfully","UpdatedSuccessfully",JOptionPane.PLAIN_MESSAGE);  
	        }
            else {
            	JFrame mes=new JFrame("Alert");
				JOptionPane.showMessageDialog(mes,"The selected file is not inserted in database sucessfully","Alert",JOptionPane.WARNING_MESSAGE);     
            }
            	con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public int checkuspas(String us,String pas) {
		int c=0;
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			
			Statement stmt;
			LocalDateTime now=LocalDateTime.now();
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT `username`,`PassWord` FROM `log_in` WHERE username='"+us+"'");
			while(rs.next()) {
				if((rs.getString(1).compareTo(us)==0)&&(rs.getString(2).compareTo(pas)==0))
					c++;
				}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}
	/*public static void main(String[] args) {
		Connection con=null;
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trying","root","");
			if(!con.isClosed());
			System.out.println("Connected");
			Statement stmt;
			DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
			DateTimeFormatter dft1=DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
			LocalDateTime now=LocalDateTime.now();
			stmt=con.createStatement();
			
			stmt.executeUpdate("INSERT INTO `trying_to_log`(`date`, `DateTime`, `UserName`, `PassWord`) VALUES ('"+dft1.format(now) +"',' " +dft.format(now)+"','"+us+"','"+pw+"')");
			ResultSet rs=stmt.executeQuery("Select * from trying_to_log where date = '"+dft1.format(now)+"' ");
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4) );
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}*/

}
