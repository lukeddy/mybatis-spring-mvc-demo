/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 *
 */
package com.techbirds.ms.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.techbirds.ms.util.BaseTest;

/**
 * @author techbirds
 * @date 2013-7-3
 * @time 下午4:23:22
 * @version 1.0
 */
public class UserDaoTest extends BaseTest{
	@Autowired
	private UserMapper userDao;
	
	@Test
	public void testQueryUserById(){
		try {
			System.out.println(userDao.QueryUserById(11).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


