package com.xiahe.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class ImageAction {
	private String name;
	private String floder;

	public String image() {
		try {
			File file = new File(floder, name);
			FileUtils.copyFile(file, ServletActionContext.getResponse().getOutputStream());
		} catch (Exception e) {
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFloder() {
		return floder;
	}

	public void setFloder(String floder) {
		this.floder = floder;
	}

}
