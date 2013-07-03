/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 *
 */
package com.techbirds.ms.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author techbirds
 * @date 2013-7-3
 * @time 下午4:23:22
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-dao.xml")
public class BaseTest extends TestCase {
	@Autowired
	protected DruidDataSource dataSource;
	
	public void executeSQL(String sql) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	conn = dataSource.getPooledConnection().getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	public void clearTable(String tableName) {
    	String sql = "DELETE FROM " + tableName;
    	executeSQL(sql);
    }
}
