package com.tuanshop.bb.service;

import java.util.List;

import com.tuanshop.bb.dao.query.UserRoleQuery;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;

public interface UserRoleInfoService {
	void add(UserRoleInfoDomain  userroleinfodomain);
	UserRoleQuery<UserRoleInfoDomain> findUserRolePageList(UserRoleQuery<UserRoleInfoDomain> query);
	  List<UserRoleInfoDomain>  findUserRole(Long id);
	  List<UserRoleInfoDomain>  findUserRoleList();
	  void dltUserRole(Long userId);
}
