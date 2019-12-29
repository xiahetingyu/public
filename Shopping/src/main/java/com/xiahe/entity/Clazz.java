package com.xiahe.entity;

import java.util.List;

@SuppressWarnings("serial")
public class Clazz extends Entity {
	private String p;// 父ID
	private int level;// 类别等级
	private String name;// 类别名
	private Clazz clazz;
	private List<Clazz> clazzs;

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public List<Clazz> getClazzs() {
		return clazzs;
	}

	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}

	@Override
	public String toString() {
		return "Clazz [p=" + p + ", level=" + level + ", name=" + name + "]";
	}

}
