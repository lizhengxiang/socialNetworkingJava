package com.g7love.beans.dynamic;


public class getdynamicArgs {
	private int tag;
	private int pageNo;
	private int pageSize;
	private String userid;
	private int id;
	
	public getdynamicArgs() {
		super();
	}
	public getdynamicArgs(Integer tag,Integer pageNo,Integer pageSize,String userid,Integer id){
		this.tag = tag;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.userid = userid;
		this.id = id;
		System.out.println(this.pageSize);
	}
	
	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getPageNo() {
		return  pageNo== 0 ? 0 : pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return  pageSize== 0 ? 15 : pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
