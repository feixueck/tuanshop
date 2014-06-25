package com.tuanship.bb.test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.tuanshop.bb.dao.RoleInfoDao;
import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.pojo.RoleInfoDomain;

@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class RoleInfoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private RoleInfoDao roleInfoDao;

	@Test
	public void insertRoleTest() {
		RoleInfoDomain role = new RoleInfoDomain();
		for (int i = 0; i < 22; i++) {
			role.setDescription("这个角色给" + i + "号苍老师用");
			role.setName( i+"号苍老师角色");
			roleInfoDao.add(role);
		}
	}
	@Test
	public void deleteRoleTest(){
		roleInfoDao.delete(Long.valueOf(10));
		System.out.println("删除成功！！");
	}
	@Test
	public void updateRoleTest(){
		RoleInfoDomain role = new RoleInfoDomain();
		role.setName("张三");
		role.setId(Long.valueOf(1));
		roleInfoDao.update(role);
		System.err.println("更新成功！！！");
	}
	@Test
	public void findById(){
		RoleInfoDomain roleinfodomain=new RoleInfoDomain();
		roleInfoDao.findById(Long.valueOf(1));
		System.out.println("<<<<<<<<<"+roleinfodomain.getName()+">>>>>>>>>>>");
	}
	@Test
	public void findByName(){
		RoleInfoDomain roleinfodomain=new RoleInfoDomain();
		roleInfoDao.findByName("张三");
		System.out.println("<<<<<<<<<"+roleinfodomain.getName()+">>>>>>>>>>>");
	}
	
	@Test
	public void findRoleDomain(){
		RoleQuery<RoleInfoDomain> roleQuery = new RoleQuery<RoleInfoDomain>();
		roleQuery.setPageSize(6);
		roleQuery.setPageIndex(6);
		//roleQuery.setRolename("张三");
	roleInfoDao.findRolePageList(roleQuery);
	System.out.println(roleQuery.getDataList().size());
		
	}

}
