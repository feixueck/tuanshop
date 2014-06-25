package com.tuanshop.bb.service;

import org.springframework.stereotype.Repository;
import com.tuanshop.bb.pojo.dianping.GrouponInfoDomain;

@Repository
public interface GrouponInfoService {
	
	/**
	 * 
	 * @param releinfo
	 */
	void add(GrouponInfoDomain grouponInfoDomain);
	/**
	 * 
	 * @param releinfo
	 */
	void delete(Long id );
	/**
	 * 
	 * @param releinfo
	 */
	void update(GrouponInfoDomain grouponInfoDomain);
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
