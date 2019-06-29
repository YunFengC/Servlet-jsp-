package cn.itcast.store.web.servlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Car;
import cn.itcast.store.domain.CarTerm;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.domain.UserBean;
import cn.itcast.store.domain.orderitemBean;
import cn.itcast.store.domain.ordersBean;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.service.serviceimpl.OrderServiceImpl;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
	public String saveOrder(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Car cart = (Car) request.getSession().getAttribute("cart");
		Collection<CarTerm> collection = cart.getCollection();
		List<orderitemBean> list = new ArrayList<orderitemBean>();
		request.getSession().getAttribute("userbean");
		String oid = UUIDUtils.getId();
		double total =cart.getTotal();
		Date ordertime = new Date();
		int state = 1;
		String address = null;
		String name = null;
		String telephone = null;
		UserBean userbean = (UserBean) request.getSession().getAttribute("userbean");
		ordersBean ordersBean = new ordersBean(oid,ordertime,total,address,name,telephone,userbean,list,state);
		for (CarTerm carTerm : collection) {
			String itemid = UUIDUtils.getId();
			int quantity = carTerm.getNumber();
			double subtotal = carTerm.getSubtotal();
			ProductBean productbean = carTerm.getProductbean();
			orderitemBean orderitemBean = new orderitemBean();
			orderitemBean.setItemid(itemid);
			orderitemBean.setOrdersbean(ordersBean);
			orderitemBean.setProductbean(productbean);
			orderitemBean.setQuantity(quantity);
			orderitemBean.setSubtotal(subtotal);
			list.add(orderitemBean);
		}
		
		OrderService orderService = new OrderServiceImpl();
		orderService.saveOrder(ordersBean);
		cart.EmptyCat();
		request.setAttribute("ordersBean", ordersBean);
		
		return "/jsp/order_info.jsp";
	}
	public String findOrdersByUidWithPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int  num = Integer.parseInt(request.getParameter("num"));
		OrderService service = new OrderServiceImpl();
		UserBean userbean = (UserBean) request.getSession().getAttribute("userbean");
		PageModel pm = service.findOrdersByUidWithPage(num,userbean);
		request.setAttribute("page", pm);
		return "/jsp/order_list.jsp";
	}
	public String findTotalRecordsByUid(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String oid = request.getParameter("oid");
		System.out.println(oid);
		OrderService service = new OrderServiceImpl();
		ordersBean ob = service.findoid(oid);
		List<orderitemBean> list = ob.getList();
		double total = ob.getTotal();
		for (orderitemBean orderitemBean : list) {
			double subtotal = orderitemBean.getSubtotal();
			total+=subtotal;
		}
		ob.setTotal(total);
		request.setAttribute("ordersBean", ob);
		return "/jsp/order_info.jsp";
		
	}
}
