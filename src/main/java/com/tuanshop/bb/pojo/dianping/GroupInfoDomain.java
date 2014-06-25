package com.tuanshop.bb.pojo.dianping;

import java.util.Date;

public class GroupInfoDomain {
	
private	Long id;
private	String tuanId;
private	Date gmtCreate;
private	Date gmtModified;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTuanId() {
	return tuanId;
}
public void setTuanId(String tuanId) {
	this.tuanId = tuanId;
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

	

}
