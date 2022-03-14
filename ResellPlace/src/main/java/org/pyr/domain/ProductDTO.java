package org.pyr.domain;

public class ProductDTO {
	//상품의 브랜드 이름
	private String brand;
	//상품의 이름
	private String pName;
	//상품의 가격
	private int price;
	//이미지 파일 이름
	private String fileName;
	//이미지 파일 경로
	private String uploadPath;
	//이미지의 이름이 겹칠수가있기때문에 uuid설정
	private String uuid;
	//작성일
	private String productDate;
	//상품타입
	private String productType;
	
	
	
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
	@Override
	public String toString() {
		return "ProductDTO [brand=" + brand + ", pName=" + pName + ", price=" + price + ", fileName=" + fileName
				+ ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", productDate=" + productDate + ", productType="
				+ productType + "]";
	}
	
	
}
