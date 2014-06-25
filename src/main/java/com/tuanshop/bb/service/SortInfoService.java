package com.tuanshop.bb.service;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.pojo.dianping.SortDomain;
@Repository
public interface SortInfoService {

	/**
	 * 
	 * @param releinfo
	 */
	void add(SortDomain sortdomain);
	/**
	 * 
	 * @param releinfo
	 */
	void delete(Long id );
	/**
	 * 
	 * @param releinfo
	 */
	void update(SortDomain sortdomain);
	/**
	 * 
	 * @param releinfo
	 */
	SortDomain findById(Long id);
	/**
	 * 
	 * @param releinfo
	 */
	SortDomain findByName(String name);
	/**
	 * 
	 * @param query
	 * @return
	 */
	//RoleQuery<RoleInfoDomain> findRolePageList(RoleQuery<RoleInfoDomain> query);


}
