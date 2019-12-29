package com.xiahe.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Product extends Entity {
	private int c_id;
	private String name;
	private String author;
	private String cover;
	private String press;
	private Date press_date;
	private String edition;
	private Date print_date;
	private String impression;
	private String isbn;
	private String word_num;
	private int page_num;
	private String size;
	private String paper;
	private String pack;
	private double price;
	private double dprice;
	private Date create_date;
	private String editor_recommend;
	private String content_abstract;
	private String author_abstract;
	private String director;
	private String media_commentary;
	private int sale;
	private int stock;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPress_date() {
		return press_date;
	}

	public void setPress_date(Date press_date) {
		this.press_date = press_date;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Date getPrint_date() {
		return print_date;
	}

	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getWord_num() {
		return word_num;
	}

	public void setWord_num(String word_num) {
		this.word_num = word_num;
	}

	public int getPage_num() {
		return page_num;
	}

	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDprice() {
		return dprice;
	}

	public void setDprice(double dprice) {
		this.dprice = dprice;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getEditor_recommend() {
		return editor_recommend;
	}

	public void setEditor_recommend(String editor_recommend) {
		this.editor_recommend = editor_recommend;
	}

	public String getContent_abstract() {
		return content_abstract;
	}

	public void setContent_abstract(String content_abstract) {
		this.content_abstract = content_abstract;
	}

	public String getAuthor_abstract() {
		return author_abstract;
	}

	public void setAuthor_abstract(String author_abstract) {
		this.author_abstract = author_abstract;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMedia_commentary() {
		return media_commentary;
	}

	public void setMedia_commentary(String media_commentary) {
		this.media_commentary = media_commentary;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [c_id=" + c_id + ", name=" + name + ", author=" + author + ", cover=" + cover + ", press="
				+ press + ", press_date=" + press_date + ", edition=" + edition + ", print_date=" + print_date
				+ ", impression=" + impression + ", isbn=" + isbn + ", word_num=" + word_num + ", page_num=" + page_num
				+ ", size=" + size + ", paper=" + paper + ", pack=" + pack + ", price=" + price + ", dprice=" + dprice
				+ ", create_date=" + create_date + ", editor_recommend=" + editor_recommend + ", content_abstract="
				+ content_abstract + ", author_abstract=" + author_abstract + ", director=" + director
				+ ", media_commentary=" + media_commentary + ", sale=" + sale + ", stock=" + stock + "]";
	}

}
