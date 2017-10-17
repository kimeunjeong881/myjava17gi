package com.saeyan.dto;

public class ProductVO2 {
	private Integer code;
	private String name;
	private Integer price;
	private String description;
	private String pictureUrl;
	
	public ProductVO2(){
		
	}
	
	public ProductVO2(Integer code, String name, Integer price,
			String description, String pictureUrl) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.pictureUrl = pictureUrl;
	}
	
	public Integer getCode() {
		return code;
	}
	public ProductVO2 setCode(Integer code) {
		this.code = code;
		return this;
	}
	public String getName() {
		return name;
	}
	public ProductVO2 setName(String name) {
		this.name = name;
		return this;
	}
	public Integer getPrice() {
		return price;
	}
	public ProductVO2 setPrice(Integer price) {
		this.price = price;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public ProductVO2 setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public ProductVO2 setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
		return this;
	}
	
}
