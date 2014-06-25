package com.tuanship.bb.test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tuanshop.bb.dao.RoleAuthorityDao;
import com.tuanshop.bb.dao.UserInfoDao;
import com.tuanshop.bb.dao.UserRoleInfoDao;
import com.tuanshop.bb.pojo.RoleAuthorityInfoDomain;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;

@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class RoleauthorityTestTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private RoleAuthorityDao roleAuthorityDao;

	@Test
	public void add() {
		RoleAuthorityInfoDomain rauthdo = new RoleAuthorityInfoDomain();
		for (int i = 0; i < 20; i++) {
			rauthdo.setAuthorityId(Long.valueOf(i));
			rauthdo.setRoleId(22l);
			rauthdo.setDescription("干" + i + "用的");
			roleAuthorityDao.add(rauthdo);
		}
	}

	@Test
	public void getRoleList() {
		RoleAuthorityInfoDomain rauthdo = new RoleAuthorityInfoDomain();
		List<RoleAuthorityInfoDomain> roleList = roleAuthorityDao.getRoleAuthorityList(rauthdo);
		System.out.println(roleList.size());
	}

	@Test
	public void deleteTest() {
		roleAuthorityDao.deleteByRole(1l);
		
	}
}
