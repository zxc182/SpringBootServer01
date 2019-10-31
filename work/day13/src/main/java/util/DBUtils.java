package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource dataSource;
	static {
		//创建属性对象
		Properties prop = new Properties();
		//得到文件输入流
		InputStream ips = DBUtils.class.getClassLoader()
					.getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
			//读取数据库连接信息
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//创建数据源对象
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(3);
			dataSource.setMaxActive(3);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	//获取连接
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}
	//关闭资源
	public static void close(Connection conn,Statement stat,
			ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stat!=null) {
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				//打开自动提交
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





