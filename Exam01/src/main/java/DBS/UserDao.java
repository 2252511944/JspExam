package DBS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {
	public void save(Connection conn, User user) throws SQLException;
	public void update(Connection conn, int id, User user) throws SQLException;
	public void delete(Connection conn, User user) throws SQLException;
	public ResultSet get(Connection conn, User user) throws SQLException;
	public ResultSet getAll(Connection conn) throws SQLException;
}
 