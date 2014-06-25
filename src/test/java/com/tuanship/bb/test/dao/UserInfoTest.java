package com.tuanship.bb.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tuanshop.bb.dao.UserInfoDao;
import com.tuanshop.bb.pojo.UserInfoDomain;

@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class UserInfoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserInfoDao userInfoDao;

	@Test
	public void insertUserTest() {
		UserInfoDomain user = new UserInfoDomain();
		for (int i = 0; i < 22; i++) {
			user.setAddress("北京第" + i + "胡同");
			user.setUsername("苍老师" + i + "号");
			user.setUserpwd("canglaoshi" + i);
			userInfoDao.addUser(user);
		}
	}

	@Test
	public void findbyId() {
		UserInfoDomain user = userInfoDao.findId(10l);
		System.out.println(user.getUsername() + ">>" + user.getAddress());
	}
	@Test
	public void updateTest(){
		UserInfoDomain user=new UserInfoDomain();
		user.setId(10l);
		user.setAddress("天壤");
		userInfoDao.update(user);
	}

}
