package cn.itcast.store.domain;

public class CarTerm {
	@Override
	public String toString() {
		return "CarTerm [productbean=" + productbean + ", Number=" + Number + ", Subtotal=" + Subtotal + "]";
	}
	private ProductBean productbean;
	private int Number;
	private double Subtotal;
	public CarTerm() {
		super();
	}
	public ProductBean getProductbean() {
		return productbean;
	}
	public void setProductbean(ProductBean productbean) {
		this.productbean = productbean;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		this.Number = number;
	}
	public double getSubtotal() {
		return Number*productbean.getMarket_price();
	}
	public void setSubtotal(int subtotal) {
		this.Subtotal = subtotal;
	}
}
