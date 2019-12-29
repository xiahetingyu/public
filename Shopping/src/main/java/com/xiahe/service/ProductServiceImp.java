package com.xiahe.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.xiahe.dao.ProductDao;
import com.xiahe.entity.Clazz;
import com.xiahe.entity.Page;
import com.xiahe.entity.Product;
import com.xiahe.tool.MybatisTools;

public class ProductServiceImp extends ServiceImp<Product> implements ProductService {

	public ProductServiceImp() {
		super(ProductDao.class);
	}

	@Override
	public Map<String, Object> index() {
		Map<String, Object> map = new HashMap<>();
		// 类别
		ClazzService clazzService = new ClazzServiceImp();
		map.put("clazzs", clazzService.selectsAll());

		// 编辑推荐
		Random random = new Random();
		List<Product> products = selects();
		List<Product> recommend = new ArrayList<Product>();
		if (products.size() > 0) {
			for (int i = 0; i < 2 && i < products.size(); i++) {
				Product product = products.get(random.nextInt(products.size()));
				while (recommend.contains(product)) {
					product = products.get(random.nextInt(products.size()));
				}
				recommend.add(product);
			}
		}
		map.put("recommend", recommend);

		// 热销图书
		ProductDao mapper = MybatisTools.getMapper(ProductDao.class);
		map.put("hot", mapper.selects("order by sale desc limit 8"));
		System.out.println("hot:" + map.get("hot"));

		// 最新上架
		map.put("new1", mapper.selects("order by create_date desc limit 8"));
		System.out.println("new:" + map.get("new1"));

		// 新书热卖
		map.put("hotBoard", mapper.selects("order by create_date,sale desc limit 8"));
		System.out.println("hotBoard:" + map.get("hotBoard"));
		return map;
	}

	@Override
	public boolean insert(Product product, Object... objects) {
		try {
			product.setCreate_date(new Date());
			File image = (File) objects[0];
			String upload = objects[1].toString();
			String imageFileName = objects[2].toString();
			String name = System.currentTimeMillis()
					+ imageFileName.substring(imageFileName.lastIndexOf("."), imageFileName.length());
			FileUtils.copyFile(image, new File(upload + name));
			product.setCover(ServletActionContext.getRequest().getContextPath() + "/image/image?name=" + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert(product);
	}

	@Override
	public boolean update(Product product, Object... objects) {
		try {
			product.setCreate_date(new Date());
			File image = (File) objects[0];
			String upload = objects[1].toString();
			String imageFileName = objects[2].toString();
			String name = System.currentTimeMillis()
					+ imageFileName.substring(imageFileName.lastIndexOf("."), imageFileName.length());
			FileUtils.copyFile(image, new File(upload + name));
			product.setCover(ServletActionContext.getRequest().getContextPath() + "/image/image?name=" + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update(product);
	}

	@Override
	public List<Product> selectls(Product product) {
		return selects("where " + product.getOther() + " like '%" + product.getName() + "%'");
	}

	// 根据类别查询
	@Override
	public Map<String, Object> second(Page page) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);// 链接的分类

		// 类别
		ClazzService clazzService = new ClazzServiceImp();
		List<Clazz> all = clazzService.selectsAll();

		for (Clazz clazz : all) {
			if (clazz.getId() == page.getP()) {
				map.put("clazz", clazz);
			}
		}

		// 类别下的图书
		List<Product> products = new ArrayList<Product>();
		map.put("products", products);

		ProductDao mapper = MybatisTools.getMapper(ProductDao.class);

		int start = (page.getIndex() - 1) * page.getSize();// 分页起始位置

		// 一级
		if (page.getQ() == 1) {
			int size = mapper.selectps("where p.id= " + page.getP(), "", "").size();
			page.setPage(size / page.getSize() + (size % page.getSize() == 0 ? 0 : 1));
			products.addAll(mapper.selectps("where p.id= " + page.getP(), "limit " + start + "," + page.getSize(),
					"order by " + page.getOrder()));
		}

		// 二级
		if (page.getQ() == 2) {
			int size = mapper.selectps("where c.id= " + page.getC(), "", "").size();
			page.setPage(size / page.getSize() + (size % page.getSize() == 0 ? 0 : 1));
			products.addAll(mapper.selectps("where c.id= " + page.getC(), "limit " + start + "," + page.getSize(),
					"order by " + page.getOrder()));
		}

		return map;
	}

}
