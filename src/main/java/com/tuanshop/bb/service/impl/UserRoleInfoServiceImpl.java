package com.tuanshop.bb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanshop.bb.dao.UserRoleInfoDao;
import com.tuanshop.bb.dao.query.UserRoleQuery;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;
import com.tuanshop.bb.service.UserRoleInfoService;
@Service
public class UserRoleInfoServiceImpl implements UserRoleInfoService{
	@Autowired
	 private UserRoleInfoDao userroleinfodao;
	@Override
	public UserRoleQuery<UserRoleInfoDomain> findUserRolePageList(
			UserRoleQuery<UserRoleInfoDomain> query) {
		// TODO Auto-generated method stub
		return userroleinfodao.findUserRolePageList(query);
	}
	@Override
	public void add(UserRoleInfoDomain userroleinfodomain) {
		// TODO Auto-generated method stub
		userroleinfodao.add(userroleinfodomain);
	}
	@Override
	public List<UserRoleInfoDomain> findUserRole(Long id) {
		// TODO Auto-generated method stub
		return userroleinfodao.findUserRole(id);
	}
	@Override
	public List<UserRoleInfoDomain> findUserRoleList() {
		// TODO Auto-generated method stub
		return userroleinfodao.findUserRoleList();
	}
	@Override
	public void dltUserRole(Long userId) {
		// TODO Auto-generated method stub
		userroleinfodao.dltUserRole(userId);
	}
	
  
}
