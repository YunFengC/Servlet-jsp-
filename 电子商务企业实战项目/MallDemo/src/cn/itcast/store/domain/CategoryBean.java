package cn.itcast.store.domain;

public class CategoryBean {
	private String cid;
	private String cname;
	public CategoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryBean(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public String getCid() {
		return cid;
	}
	@Override
	public String toString() {
		return "CategoryBean [cid=" + cid + ", cname=" + cname + "]";
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
