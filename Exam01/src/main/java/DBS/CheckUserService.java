package DBS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Film.Film;
import Film.FilmDao;
import Film.FilmDaoImpl;

public class CheckUserService {  // 
	private UserDao userDao= new UserDaoImpl(); // ��ɾ���
	private FilmDao filmDao = new FilmDaoImpl();
	
	public boolean check(User user){ // ���user�Ƿ������ݿ���
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection(); // ��������
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
	public boolean check(Film film){ // ���user�Ƿ������ݿ���
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection(); // ��������
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
