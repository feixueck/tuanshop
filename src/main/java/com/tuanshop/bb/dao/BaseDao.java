package com.tuanshop.bb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.tuanshop.bb.dao.base.PageQuery;

public class BaseDao extends SqlMapClientDaoSupport {
	@Resource(name = "sqlMapClient")
	private SqlMapClient sqlMapClient;

	@PostConstruct
	public void initSqlMapClient() {
		super.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	protected <T> PageQuery<T> listByQuery(String statementName,
			PageQuery<T> query) {
		// 获取总记录数
		query.setTotalRecord(countByQuery(statementName + "_count", query));
		// 如果有记录
		if (query.getTotalRecord() > 0) {
			List<T> result = (List<T>) getSqlMapClientTemplate().queryForList(
					statementName, query);
			if (result == null) {
				result = new ArrayList<T>();
			}
			query.setDataList(result);
		}
		return query;
	};

	/**
	 * 获取总数
	 * 
	 * @param statementName
	 * @param query
	 * @return
	 */
	public <T> Integer countByQuery(String statementName, PageQuery<T> query) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				statementName, query);
	}
}
