package cn.itcast.store.domain;

public class orderitemBean {
	private String itemid;
	public orderitemBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderitemBean(String itemid, int quantity, double subtotal, ProductBean productbean, ordersBean ordersbean) {
		super();
		this.itemid = itemid;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.productbean = productbean;
		this.ordersbean = ordersbean;
	}
	@Override
	public String toString() {
		return "orderitemBean [itemid=" + itemid + ", quantity=" + quantity + ", total=" + subtotal + ", productbean="
				+ productbean + ", ordersbean=" + ordersbean + "]";
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public ProductBean getProductbean() {
		return productbean;
	}
	public void setProductbean(ProductBean productbean) {
		this.productbean = productbean;
	}
	public ordersBean getOrdersbean() {
		return ordersbean;
	}
	public void setOrdersbean(ordersBean ordersbean) {
		this.ordersbean = ordersbean;
	}
	private int quantity;
	private double subtotal;
	private ProductBean productbean;
	private ordersBean ordersbean;
}
