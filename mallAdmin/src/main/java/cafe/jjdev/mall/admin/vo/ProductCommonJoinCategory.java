package cafe.jjdev.mall.admin.vo;

public class ProductCommonJoinCategory {
	private int productCommonNo;
	private int categoryNo;
	private String categoryName;
	private String productCommonName;
	private int productCommonPrice;
	private String productCommonDescription;
	private String productCommonDate;
	
	@Override
	public String toString() {
		return "ProductCommonJoinCategory [productCommonNo=" + productCommonNo + ", categoryNo=" + categoryNo
				+ ", categoryName=" + categoryName + ", productCommonName=" + productCommonName
				+ ", productCommonPrice=" + productCommonPrice + ", productCommonDescription="
				+ productCommonDescription + ", productCommonDate=" + productCommonDate + "]";
	}
	public int getProductCommonNo() {
		return productCommonNo;
	}
	public void setProductCommonNo(int productCommonNo) {
		this.productCommonNo = productCommonNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductCommonName() {
		return productCommonName;
	}
	public void setProductCommonName(String productCommonName) {
		this.productCommonName = productCommonName;
	}
	public int getProductCommonPrice() {
		return productCommonPrice;
	}
	public void setProductCommonPrice(int productCommonPrice) {
		this.productCommonPrice = productCommonPrice;
	}
	public String getProductCommonDescription() {
		return productCommonDescription;
	}
	public void setProductCommonDescription(String productCommonDescription) {
		this.productCommonDescription = productCommonDescription;
	}
	public String getProductCommonDate() {
		return productCommonDate;
	}
	public void setProductCommonDate(String productCommonDate) {
		this.productCommonDate = productCommonDate;
	}
	
}
