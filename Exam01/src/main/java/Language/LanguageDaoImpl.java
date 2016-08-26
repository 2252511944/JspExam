package Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LanguageDaoImpl implements LanguageDao {

	public void save(Connection conn, Language lan) throws SQLException {

	}

	public void update(Connection conn, Long id, Language lan) throws SQLException {

	}

	public void insert(Connection conn, Language lan) throws SQLException {
//		PreparedStatement ps = conn.prepareStatement("insert into  language values(?,?)");
//		ps.setInt(1, lan.getFilm_id());
//		ps.setString(2, lan.getLanguage());
//		ps.executeUpdate();
	}

	public void delete(Connection conn, String film_id) throws SQLException {
//		PreparedStatement ps = conn.prepareStatement("delete from language where film_id = ?");
//		ps.setString(1, film_id);
//		ps.executeUpdate();
	}

	public ResultSet get(Connection conn, Language lan) throws SQLException {
		return null;
	}

	public ResultSet get(Connection conn) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select f.*,l.language_id from film f,language l where f.language_id =l.language_id ");
		return ps.executeQuery();
	}
}
