package com.xiahe.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.xiahe.entity.Page;
import com.xiahe.entity.Product;
import com.xiahe.service.ProductService;
import com.xiahe.service.ProductServiceImp;

@SuppressWarnings("serial")
public class ProductAction extends ActionSupport {
	// ---------------------扩展业务-------------------------------
	private Map<String, Object> map;
	private Page page;

	// 初始化首页
	public String index() {
		map = service.index();
		return "main.jsp";
	}

	// 根据类别查询
	public String second() {
		map = service.second(page);
		return "list";// 跳转到二级页面
	}

	// -------------------本类业务-------------------------
	private ProductService service = new ProductServiceImp();
	private Product product;
	private List<Product> products;

	private File image;
	private String upload;
	private String imageFileName;

	// 添加
	public String insert() {
		service.insert(product, image, upload, imageFileName);
		return "show";
	}

	// 删除
	public String delete() {
		service.delete(product);
		return "show";
	}

	// 更新
	public String update() {
		service.update(product, image, upload, imageFileName);
		return "show";
	}

	// 更新前查询
	public String select() {
		String temp = product.getOther();
		product = service.select(product);
		return temp == null ? "select" : temp;
	}

	// 模糊查询
	public String selectls() {
		products = service.selectls(product);
		return "show.jsp";
	}

	// 展示所有
	public String show() {
		products = service.selects();
		return "show.jsp";
	}

	// ----------------------------------------------------------------------------------

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
