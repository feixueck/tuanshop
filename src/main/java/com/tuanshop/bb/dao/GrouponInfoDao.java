package com.tuanshop.bb.dao;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.pojo.dianping.GrouponInfoDomain;

@Repository
public interface GrouponInfoDao {

	void add(GrouponInfoDomain grouponinfo);
	/**
	 * 
	 * @param releinfo
	 */
	void delete(Long id );
	/**
	 * 
	 * @param releinfo
	 */
	void update(GrouponInfoDomain grouponinfo);
	/**
	 * 
	 * @param releinfo
	 */
	GrouponInfoDomain findById(Long id);
	/**
	 * 
	 * @param releinfo
	 */
	GrouponInfoDomain findByName(String name);
	/**
	 * 
	 * @param query
	 * @return
	 */
	//RoleQuery<RoleInfoDomain> findRolePageList(RoleQuery<RoleInfoDomain> query);



}
