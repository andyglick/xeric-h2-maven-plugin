package com.example;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcIT extends TestCase {
    
    public void testJdbcConnection() throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
            getConnection("jdbc:h2:tcp://localhost:9191/test", "sa", "");
        conn.close();
    }
    
}
