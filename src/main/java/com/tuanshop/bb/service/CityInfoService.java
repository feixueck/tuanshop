package com.tuanshop.bb.service;

import com.tuanshop.bb.pojo.dianping.CityDomain;

public interface CityInfoService {
	/**
	 * 
	 * @param releinfo
	 */
	void add(CityDomain citydomain);
	/**
	 * 
	 * @param releinfo
	 */
	void delete(Long id );
	/**
	 * 
	 * @param releinfo
	 */
	void update(CityDomain citydomain);
	/**
	 * 
	 * @param releinfo
	 */
	CityDomain findById(Long id);
	/**
	 * 
	 * @param releinfo
	 */
	CityDomain findByName(String name);
	/**
	 * 
	 * @param query
	 * @return
	 */
	//RoleQuery<RoleInfoDomain> findRolePageList(RoleQuery<RoleInfoDomain> query);



}
