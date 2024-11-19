package jdbcApp;

public class Query {
	static String insert ="INSERT INTO employee VALUES (?,?,?,?)";
	static String update ="UPDATE employee SET name = ? WHERE id=?";
	static String delete = "DELETE FROM employee WHERE id=?";
	static String select = "select * from employee";
	
}
