package Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface FilmDao {
	public ResultSet get(Connection conn) throws SQLException;
	public ResultSet get(Connection conn, Film cust) throws SQLException;
	public int delete(Connection conn, String film_id) throws SQLException;
	public void insert(Connection conn, Film cust) throws SQLException;
}
