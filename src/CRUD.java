
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUD {

	public static void main(String[] args) {

		try {
			// Step-1 Register the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "antara");
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
             System.out.println(con);
			 
			// Creating a table
			String sql1 = "create table student(id number, name varchar2(20))";
			// Inserting a record
			String sql2 = "insert into student values(1,'Venkat')";
			// Update the record
			String sql3 = "update student set name='Vijay' where id=1";
			// Delete the record
			String sql4 = "delete from student where id=1";

			// Step-3
			Statement stmt = con.createStatement();

			stmt.executeUpdate(sql1);
			 //stmt.executeUpdate(sql2);
//			 stmt.executeUpdate(sql3);
//			 stmt.executeUpdate(sql4);
			System.out.println("Successful");
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
