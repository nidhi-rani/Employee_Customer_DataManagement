package edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
    public static Connection connect() {
    	Properties p=new Properties();
    	Connection con;
    	try {
    		p.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
    		String driver=p.getProperty("driver");
    		String url=p.getProperty("url");
    		Class.forName(driver);
    		con=DriverManager.getConnection(url, p);
    		return con;
    				
    	}catch(Exception e) {
    		System.out.println("DBUtil-connect: "+e);
    	}
    	return null;
    }
    public static void close(Connection con,Statement st,ResultSet rs) {
    	try {
    		if(rs!=null) {
    			rs.close();
    		}
    		if(st!=null) {
    			st.close();
    		}
    		if(con!=null) {
    			con.close();
    		}
    	}catch(Exception e) {
    		System.out.println("DBUtil-close(): "+e);
    	}
    	return ;
    }
}
