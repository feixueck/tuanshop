package com.tuanshop.bb.dao;

import org.springframework.stereotype.Repository;

import com.tuanshop.bb.dao.query.RoleQuery;
import com.tuanshop.bb.dao.query.UserQuery;
import com.tuanshop.bb.pojo.RoleInfoDomain;
import com.tuanshop.bb.pojo.UserInfoDomain;
@Repository
public interface RoleInfoDao {
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
	/**
	 * 
	 * @param query
	 * @return
	 */
	RoleQuery<RoleInfoDomain> findRolePageList(RoleQuery<RoleInfoDomain> query);


}
