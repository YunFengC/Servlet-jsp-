package cn.itcast.store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ordersBean {
	private String oid;
	private Date ordertime;
	private double total;
	@Override
	public String toString() {
		return "ordersBean [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", address=" + address
				+ ", name=" + name + ", telephone=" + telephone + ", userbean=" + userbean + ", list=" + list
				+ ", state=" + state + "]";
	}
	public ordersBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ordersBean(String oid, Date ordertime, double total, String address, String name, String telephone,
			UserBean userbean, List<orderitemBean> list, int state) {
		super();
		this.oid = oid;
		this.ordertime = ordertime;
		this.total = total;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.userbean = userbean;
		this.list = list;
		this.state = state;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public UserBean getUserbean() {
		return userbean;
	}
	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
	public List<orderitemBean> getList() {
		return list;
	}
	public void setList(List<orderitemBean> list) {
		this.list = list;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	private String address;
	private String name;
	private String telephone;
	private UserBean userbean;
	private List<orderitemBean> list = new ArrayList<orderitemBean>();
	private int state=1;
	
}
