package promotionengine;

public class Product {
	String sku;
	int price;

	public Product() {
		super();
	}

	public Product(String sku, int price) {
		super();
		this.sku = sku;
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
