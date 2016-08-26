package Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface LanguageDao {

	public void save(Connection conn, Language lan) throws SQLException;

	public void update(Connection conn, Long id, Language lan) throws SQLException;

	public void insert(Connection conn, Language lan) throws SQLException;

	public void delete(Connection conn, String film_id) throws SQLException;

	public ResultSet get(Connection conn, Language lan) throws SQLException;

	public ResultSet get(Connection conn) throws SQLException;
}
