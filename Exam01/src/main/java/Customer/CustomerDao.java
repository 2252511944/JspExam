package Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface CustomerDao {

	public void save(Connection conn, Customer cust) throws SQLException;

	public void update(Connection conn, Long id, Customer cust) throws SQLException;

	public void delete(Connection conn, Customer cust) throws SQLException;

	public ResultSet get(Connection conn, Customer cust) throws SQLException;
	
	public ResultSet get(Connection conn) throws SQLException;
}
