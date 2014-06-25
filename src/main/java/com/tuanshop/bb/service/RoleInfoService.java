package com.tuanshop.bb.service;

import com.tuanshop.bb.dao.query.RoleQuery;

import com.tuanshop.bb.pojo.RoleInfoDomain;


public interface RoleInfoService {
	
	/**
	 * 
	 * @param releinfo
	 */
	void add(RoleInfoDomain releinfo);
	/**
	 * 
	 * @param releinfo
	 */
	void delete(Long id );
	/**
	 * 
	 * @param releinfo
	 */
	void update(RoleInfoDomain roleinfo);
	/**
	 * 
	 * @param releinfo
	 */
	RoleInfoDomain findById(Long id);
	/**
	 * 
	 * @param releinfo
	 */
	RoleInfoDomain findByName(String name);
	
	RoleQuery<RoleInfoDomain> queryRoleInfoPageList(RoleQuery<RoleInfoDomain> query);
}
