package DBS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Film.Film;
import Film.FilmDao;
import Film.FilmDaoImpl;

public class CheckUserService {  // 
	private UserDao userDao= new UserDaoImpl(); // 增删查改
	private FilmDao filmDao = new FilmDaoImpl();
	
	public boolean check(User user){ // 检查user是否在数据库中
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection(); // 加载驱动
			conn.setAutoCommit(false);
			ResultSet rs = userDao.get(conn, user);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false; 
		
	}
	
	// check film
	public boolean check(Film film){ // 检查user是否在数据库中
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection(); // 加载驱动
			conn.setAutoCommit(false);
			ResultSet rs = filmDao.get(conn, film);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false; 
		
	}
}
