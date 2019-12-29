package com.xiahe.entity;

//分页
@SuppressWarnings("serial")
public class Page extends Entity {
	private int page;// 总页数
	private int index = 1;// 当前页
	private int size = 2;// 每页条数

	private int p;// 父ID
	private int c;// 子ID
	private int q = 1;// 区分一二级

	private String order = "time desc";// 排序方式

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", index=" + index + ", size=" + size + ", p=" + p + ", c=" + c + ", q=" + q
				+ ", order=" + order + "]";
	}

}
