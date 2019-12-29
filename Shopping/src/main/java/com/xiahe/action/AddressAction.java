package com.xiahe.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xiahe.dao.AddressDao;
import com.xiahe.entity.Address;
import com.xiahe.entity.User;
import com.xiahe.service.Service;
import com.xiahe.service.ServiceImp;

@SuppressWarnings("serial")
public class AddressAction extends ActionSupport {

	private Service<Address> service = new ServiceImp<Address>(AddressDao.class);
	private Address address;
	private List<Address> addresses;

	// 展示所有地址
	public String show() {
		addresses = service.selects();
		return "address_form.jsp";
	}

	// 查询地址详情
	public String select() {
		address = service.select(address);
		addresses = service.selects();
		return "address_form.jsp";
	}

	// 更新或创建地址
	public String update() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		String email = address.getEmail();
		if (email == null || email == "") {
			address.setName(address.getLocal().substring(0, 2));
			System.out.println("local:" + address.getLocal());
			System.out.println("name:" + address.getName());
			address.setEmail(user.getEmail());
			service.insert(address);
		} else {
			service.update(address);
		}
		return "order_ok.jsp";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
