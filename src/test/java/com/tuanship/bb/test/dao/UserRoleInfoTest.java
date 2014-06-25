package com.tuanship.bb.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tuanshop.bb.dao.UserInfoDao;
import com.tuanshop.bb.dao.UserRoleInfoDao;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;


@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class UserRoleInfoTest  extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserRoleInfoDao userroleinfodao;

 @Test
 public void add(){
	 UserRoleInfoDomain userroleinfodomain=new UserRoleInfoDomain();
	 for(int i=0;i<20;i++){
		 userroleinfodomain.setUserId(Long.valueOf(1));
		 userroleinfodomain.setRoleId(Long.valueOf(i));
		 userroleinfodomain.setDescription("干"+i+"用的");
		 userroleinfodao.add(userroleinfodomain);
	 }
 }
	

}
