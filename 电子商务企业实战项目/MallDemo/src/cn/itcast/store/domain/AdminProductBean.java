package cn.itcast.store.domain;

import java.util.Date;

public class AdminProductBean {
	private String pid;
	private String pname;
	private double market_price;
	private double shop_price;
	@Override
	public String toString() {
		return "AdminProductBean [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", pimage=" + pimage + ", pdate=" + pdate + ", is_hot=" + is_hot + ", pdesc=" + pdesc
				+ ", pfiag=" + pfiag + ", method=" + method + ", cid=" + cid + "]";
	}
	public AdminProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminProductBean(String pid, String pname, double market_price, double shop_price, String pimage, Date pdate,
			int is_hot, String pdesc, int pfiag, String method, String cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.pimage = pimage;
		this.pdate = pdate;
		this.is_hot = is_hot;
		this.pdesc = pdesc;
		this.pfiag = pfiag;
		this.method = method;
		this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPfiag() {
		return pfiag;
	}
	public void setPfiag(int pfiag) {
		this.pfiag = pfiag;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	private String pimage;
	private Date pdate;
	private int is_hot;
	private String pdesc;
	private int pfiag;
	private String method;
	private String cid;
}
