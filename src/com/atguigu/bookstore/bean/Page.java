package com.atguigu.bookstore.bean;

import java.util.List;

public class Page<T> {

	private List<T> list;
	private int pageNo;//当前页数
	private static final int PAGE_SIZE = 4;
	private int totalPageNo; // 总页数，通过计算得到
	private int totalRecord; // 总记录数
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNo() {
		if(pageNo<1){
			return 1;
		}else if(pageNo>getTotalPageNo()){
			return getTotalPageNo();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPageNo() {
		if(totalRecord % PAGE_SIZE == 0){
			return totalRecord/PAGE_SIZE;
		}else{
			return totalRecord/PAGE_SIZE + 1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public static int getPageSize() {
		return PAGE_SIZE;
	}
	//获取判断是否有上一页
	public boolean hasPre(){
		return pageNo>1;
	}
	//获取上一页
	public int getPrev(){
		return hasPre()?pageNo-1:1;
	}
	//获取判断是否有下一页
	public boolean hasNext(){
		return pageNo>1;
	}
	//获取下一页
	public int getNext(){
		return hasPre()?pageNo-1:1;
	}

}
