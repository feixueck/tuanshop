package com.tuanshop.bb;

public class TestTime {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public void running(){
		System.out.println(">>>>定时器 执行了 >>>hello, world!");
	}
}
