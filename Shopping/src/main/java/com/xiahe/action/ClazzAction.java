package com.xiahe.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xiahe.entity.Clazz;
import com.xiahe.service.ClazzService;
import com.xiahe.service.ClazzServiceImp;

@SuppressWarnings("serial")
public class ClazzAction extends ActionSupport {
	private ClazzService service = new ClazzServiceImp();
	private Clazz clazz;
	private List<Clazz> clazzs;

	public String add() {
		service.insert(clazz);
		return "show";
	}

	public String remove() {
		service.delete(clazz);
		return "show";
	}

	public String show() {
		clazzs = service.selectsAll();
		return "show.jsp";
	}

	public String showFirst() {
		clazzs = service.selectsLevel("1");
		return "add-second.jsp";
	}

	public String showSecond() {
		clazzs = service.selectsLevel("2");
		return "add.jsp";
	}

	public String showClazz() {
		clazzs = service.selectsLevel("2");
		return "update.jsp";
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

}
