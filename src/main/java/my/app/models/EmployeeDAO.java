package my.app.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements Serializable {
	private String driver = "com.mysql.jdbc.Driver";

	private String dburl = "jdbc:mysql://localhost:3306/activity05";
	private String dbuser = "testuser";
	private String dbpassword = "testuser";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public EmployeeDAO() {

	}

	private void creatConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean saveEmployee(Employee emp) {
		String query = "INSERT INTO employee (empid, firstname, lastname) VALUES(?, ?, ?)";
		creatConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getEmpid());
			pstmt.setString(2, emp.getFirstname());
			pstmt.setString(3, emp.getLastname());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmployee(Employee emp) {
		String query = "UPDATE employee SET firstname = ?, lastname = ? WHERE empid = ?";
		creatConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getFirstname());
			pstmt.setString(2, emp.getLastname());
			pstmt.setString(3, emp.getEmpid());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEmployee(Employee emp) {
		String query = "DELETE FROM employee WHERE empid = ?";
		creatConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getEmpid());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Employee getEmployee(String empid) {
		Employee emp = new Employee();
		String query = "SELECT * FROM employee WHERE empid = ?";
		creatConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp.setEmpid(empid);
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employee> getEmployeeList() {
		List<Employee> emplist = new ArrayList<Employee>();
		String query = "SELECT * FROM employee";
		creatConnection();

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpid(rs.getString("empid"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emplist;

	}
}
