package com.tuanshop.bb.dao;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.pojo.dianping.GroupInfoDomain;
@Repository
public interface GroupInfoDao {

	/**
	 * 
	 * @param releinfo
	 */
	void add(GroupInfoDomain groupinfo);
	/**
	 * 
	 * @param releinfo
	 */
	void delete(Long id );
	/**
	 * 
	 * @param releinfo
	 */
	void update(GroupInfoDomain groupinfo);
	/**
	 * 
	 * @param releinfo
	 */
	GroupInfoDomain  findById(Long id);
	/**
	 * 
	 * @param releinfo
	 */
	GroupInfoDomain  findByName(String name);
	/**
	 * 
	 * @param query
	 * @return
	 */
	//RoleQuery<RoleInfoDomain> findRolePageList(RoleQuery<RoleInfoDomain> query);



}
