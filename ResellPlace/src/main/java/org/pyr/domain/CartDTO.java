package org.pyr.domain;

public class CartDTO extends ProductDTO{
	
	//장바구니상품의 번호
	private int cno;
	//uuid
	private String uuid;
	//상품의 이름
	private String pName;
	//상품의 가격
	private int price;
	//상품의 개수
	private int quantity;
	//아이디
	private String id;
	//total
	private int total;
	
	
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "CartDTO [cno=" + cno + ", uuid=" + uuid + ", pName=" + pName + ", price=" + price + ", quantity="
				+ quantity + ", id=" + id + ", total=" + total + "]";
	}
}
