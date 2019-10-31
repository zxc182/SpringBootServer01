package test;

import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class TestCase {

	public static void main(String[] args) 
			throws SQLException {
//		System.out.println(DBUtils.getConn());
		
		UserDAO dao = new UserDAO();
//		List<User> users = dao.findAll();
//		System.out.println(users);
		
//		User user = new User();
//		user.setUsername("Eric");
//		user.setPwd("test");
//		user.setEmail("eric@126.com");
//		dao.save(user);
		
//		dao.delete(1);
		
		User user = dao.find("ะกิย");
		System.out.println(user);
		
	}

}





