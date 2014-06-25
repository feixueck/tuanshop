package com.tuanshop.bb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;



import com.tuanshop.bb.dao.query.UserRoleQuery;
import com.tuanshop.bb.pojo.UserRoleInfoDomain;


@Repository
public interface UserRoleInfoDao {
	
   void	add(UserRoleInfoDomain  userroleinfodomain);
	UserRoleQuery<UserRoleInfoDomain> findUserRolePageList(UserRoleQuery<UserRoleInfoDomain> query);
    List<UserRoleInfoDomain>  findUserRole(Long id);
    List<UserRoleInfoDomain>  findUserRoleList();
   void dltUserRole(Long userId);
	

}
