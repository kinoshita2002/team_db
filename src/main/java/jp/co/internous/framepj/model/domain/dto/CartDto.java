
package jp.co.internous.framepj.model.domain.dto;

import java.sql.Timestamp;

/**
 * カート画面に表示するためのDTO
 * @author インターノウス
 *
 */
public class CartDto {
	
	private int id;
	private int userId;
	private int productCount;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private String productName;
	private int price;
	private String imageFullPath;
	private int subtotal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageFullPath() {
		return imageFullPath;
	}
	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}
	
	public int getSubtotal() {
		return this.price * this.productCount;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
}
