package com.xiahe.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

//提供实体基础属性
@SuppressWarnings("serial")
public class Entity implements Serializable {
	private int id;
	private Timestamp time;
	private String other;
	private List<?> list;

	public Entity() {
		this.time = new Timestamp(System.currentTimeMillis());
	}

	public Entity(int id, Timestamp time) {
		super();
		this.id = id;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", time=" + time + ", other=" + other + ", list=" + list + "]";
	}

}
