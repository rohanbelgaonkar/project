package jdbcApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDao {

	public static void createEmployee(Employee emp) throws SQLException {
		Connection con = DB.connect();
		String query = Query.insert;
				
		PreparedStatement psmt = con.prepareStatement(query);
		psmt.setInt(1,emp.getid());
		psmt.setString(2,emp.getname());
		psmt.setString(3,emp.getemail());
		psmt.setInt(4, emp.getsalary());
		
		System.out.println("\n ps = "+psmt+"\n"+emp);
		psmt.executeUpdate();
		psmt.close();
	}
	public static void updateEmployee(int id , String name) throws SQLException{
		Connection con = DB.connect();
		String query = Query.update;
		
		PreparedStatement psmt = con.prepareStatement(query);
		
		psmt.setString(1,name);
		psmt.setInt(2,id);
		
		System.out.println("\n ps = "+psmt);
		psmt.executeUpdate();
		psmt.close();
		
		
		
	}
	public static ArrayList<Employee> readAllEmployee() throws SQLException{
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		Connection con = DB.connect();
		String query = Query.select;
		
		Statement stm = con.prepareStatement(query);
		System.out.println("\n st =	"+stm);
		 
		ResultSet rs = stm.executeQuery(query);
		while(rs.next()) {
			Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(2), rs.getInt(1));
			emplist.add(employee);
		}
		stm.close();
		return emplist;
		
		
		
	}
	public static void deletEmployee(int id) throws SQLException{
		Connection con = DB.connect();
		String query = Query.delete;
		
		PreparedStatement psmt = con.prepareStatement(query);
		
		
		psmt.setInt(1,id);
		
		System.out.println("\n ps = "+psmt);
		psmt.executeUpdate();
		psmt.close();
	}

}

