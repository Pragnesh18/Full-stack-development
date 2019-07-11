package ca.sheridancollege.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import ca.sheridancollege.beans.Student;


public class DAO {
	
	public static void addStudent(Student s) {
	 try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = null;
           conn = DriverManager.getConnection
           		("jdbc:mysql://localhost/editdelete", "root", "root");
        
           String Query = "insert into students (name ) values(?)";
           
           PreparedStatement ps = conn.prepareStatement(Query);
           ps.setString(1,s.getName());
        
           ps.executeUpdate();
           
           conn.close();
       } catch (Exception e) {
           System.out.println("Connection Failed");
           System.out.println(e);
       }
}
	
	
	
	public static ArrayList<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/editdelete", "root", "root");
	            
	            String Query = "Select * from students";
	           
	            Statement st = conn.createStatement();
	          	           
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int id = rs.getInt(1);	//id
	            	String name = rs.getString(2);  //name
	            	
	            	
	            	Student s = new Student(id, name);
	            	students.add(s);
		            }
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 return students;
	}

	
	
	public static void deleteStudent(int id) {
		 try {
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection conn = null;
	           conn = DriverManager.getConnection
	           		("jdbc:mysql://localhost/editdelete", "root", "root");
	        
	           String Query = "DELETE FROM students WHERE id="+id;
	           Statement st= conn.createStatement();
	           st.executeUpdate(Query);
	         
	           
	           conn.close();
	       } catch (Exception e) {
	           System.out.println("Connection Failed");
	           System.out.println(e);
	       }
	}
	
	
	
	public static Student getStudentByID(int id) {
		ArrayList<Student> students = new ArrayList<Student>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/editdelete", "root", "root");
	            
	            String Query = "SELECT * FROM students WHERE id="+id;
	           
	            Statement st = conn.createStatement();
	          	           
	            ResultSet rs = st.executeQuery(Query);
	            ResultSetMetaData rsmd  = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            
	            while(rs.next()) {
	            	int s_id = rs.getInt(1);	//id
	            	String name = rs.getString(2);  //name
	            	
	            	
	            	Student s = new Student(s_id, name);
	            	students.add(s);
		            }
	            
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
		
		 
		 if (students.size()>0)
		 {
			 return students.get(0);
		 }
		 return null;
	}
	
		
	public static void modifyStudent(Student s) {
		 try {
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection conn = null;
	           conn = DriverManager.getConnection
	           		("jdbc:mysql://localhost/editdelete", "root", "root");
	        
	           String Query = "update students SET name=? WHERE id=?";
	           
	           PreparedStatement ps = conn.prepareStatement(Query);
	           ps.setString(1,s.getName());
	           ps.setInt(2,s.getId());
	           ps.executeUpdate();
	           
	           conn.close();
	       } catch (Exception e) {
	           System.out.println("Connection Failed");
	           System.out.println(e);
	       }
	}
	
	
}
