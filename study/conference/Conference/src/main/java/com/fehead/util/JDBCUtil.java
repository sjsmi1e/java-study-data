package com.fehead.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC连接工具类，统一管理Connection对象
 * 提供Connection对象
 * @author lmwis on 2019-01-23 9:26
 */
public class JDBCUtil {
    /**
     * 提供统一的Connection对象
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        Properties jdbcProperties = new Properties();
//        jdbcProperties.load(new FileReader(new File("jdbc.properties")));
        Connection con=null;
        con=DriverManager.getConnection("jdbc:mysql://47.92.194.26:3306/fehead?characterEncoding=UTF-8"
                ,"root","Qq1234!@#$");
//        Class.forName(jdbcProperties.getProperty("jdbc.driver"));
//        con= DriverManager.getConnection(jdbcProperties.getProperty("jdbc.url"),
//                jdbcProperties.getProperty("jdbc.username"),jdbcProperties.getProperty("jdbc.password"));
        return con;
    }
}
