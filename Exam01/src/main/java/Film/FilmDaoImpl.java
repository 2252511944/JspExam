package Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmDaoImpl implements FilmDao {

	public ResultSet get(Connection conn) throws SQLException {
	PreparedStatement ps = conn.prepareStatement("select f.*,l.name from film f,language l where f.language_id =l.language_id ");
	return ps.executeQuery();
		
	}
	public ResultSet get(Connection conn, Film film) throws SQLException {
		return null;
	}
	public int delete(Connection conn, String film_id) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("delete from film where film_id = ?");
		ps.setString(1, film_id); // 将指定参数设置为给定 Java String 值。就相当于直接传film_id
		int rs = ps.executeUpdate();
		return rs;
	}
	public void insert(Connection conn, Film film) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("insert into  film (film_id,title,description,language_id) values(?,?,?,2)");
		ps.setInt(1, film.getFilm_id());
		ps.setString(2, film.getTitle());
		ps.setString(3, film.getDescription());
		ps.executeUpdate();
	}
}
