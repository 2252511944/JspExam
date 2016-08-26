package DBS;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
	/*
	 * �����û���Ϣ
	 * 
	 * */
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareCall("insert into tbl_user (id, name, email)values (?, ?, ?)");
		ps.setLong(1, user.getId());
		ps.setString(2, user.getName());
//		ps.setString(3, user.getEmail());
//		ps.execute();
		boolean result = ps.execute();
		System.out.println(result);
	}
	/*����ָ����id��������*/
	public void update(Connection conn, int id, User user) throws SQLException {
		String updateSql = "update tbl_user set name = ?, email = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setLong(1, user.getId());
		ps.setString(2, user.getName());
		ps.execute();
		
	}
	/*
	 * ɾ��ָ��������
	 * */
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from film where id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
	}
	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from customer where first_name=?");//and password=?
		ps.setString(1, user.getName());
		return ps.executeQuery();
	}
	public ResultSet getAll(Connection conn) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("select * from film where name= ?");
		
		return ps.executeQuery();
	}

}
