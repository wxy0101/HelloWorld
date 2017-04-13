package com.atguigu.bookstore.bean;

import java.util.List;

public class Page<T> {

	private List<T> list;
	private int pageNo;//��ǰҳ��
	private static final int PAGE_SIZE = 4;
	private int totalPageNo; // ��ҳ����ͨ������õ�
	private int totalRecord; // �ܼ�¼��
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
	//��ȡ�ж��Ƿ�����һҳ
	public boolean hasPre(){
		return pageNo>1;
	}
	//��ȡ��һҳ
	public int getPrev(){
		return hasPre()?pageNo-1:1;
	}
	//��ȡ�ж��Ƿ�����һҳ
	public boolean hasNext(){
		return pageNo>1;
	}
	//��ȡ��һҳ
	public int getNext(){
		return hasPre()?pageNo-1:1;
	}

}
