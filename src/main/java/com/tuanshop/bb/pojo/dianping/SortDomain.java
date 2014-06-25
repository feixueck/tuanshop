package com.tuanshop.bb.pojo.dianping;

import java.util.Date;

public class SortDomain {
	
	private Long id;
	private String maxName;
	private String mainName;
	private Date gmtCreate;    //创建时间
    private Date gmtModified;  //修改时间
    private String description; //备注说明 as defined
   
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMaxName() {
		return maxName;
	}
	public void setMaxName(String maxName) {
		this.maxName = maxName;
	}
	public String getMainName() {
		return mainName;
	}
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
