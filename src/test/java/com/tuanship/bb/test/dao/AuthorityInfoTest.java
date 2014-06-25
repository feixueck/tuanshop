package com.tuanship.bb.test.dao;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tuanshop.bb.dao.AuthorityInfoDao;
import com.tuanshop.bb.pojo.AuthorityInfoDomain;


@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class AuthorityInfoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private AuthorityInfoDao authDao;
	
	@Test
	public void insertAuthorityTest(){
		AuthorityInfoDomain authorityInfoDomain=new AuthorityInfoDomain();
		for(int i=0;i<20;i++){
			authorityInfoDomain.setName(i+"号首长");
			authorityInfoDomain.setDescription("这个是"+i+"号首长的");
			authDao.add(authorityInfoDomain);
			System.out.println("ds");
		}
		
	}

}
