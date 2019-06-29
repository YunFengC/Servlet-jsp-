package cn.itcast.store.service.serviceimpl;

import java.sql.Connection;
import java.util.List;

import cn.itcast.store.dao.OrderDao;
import cn.itcast.store.dao.daoimpl.OrderDaoImpl;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.domain.UserBean;
import cn.itcast.store.domain.orderitemBean;
import cn.itcast.store.domain.ordersBean;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.utils.JDBCUtils;

public class OrderServiceImpl implements OrderService{

	@Override
	public void saveOrder(ordersBean ordersBean) throws Exception {
		Connection conn =null;
		try {
			 conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			OrderDao dao = new OrderDaoImpl();
			dao.saveOrder(conn,ordersBean);
			for (orderitemBean ob : ordersBean.getList()) {
				dao.saveOrderitem(conn,ob);
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		}finally {
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}

		
	}

	@Override
	public PageModel findOrdersByUidWithPage(int num, UserBean userbean) throws Exception {
		OrderDao dao = new OrderDaoImpl();
		int total = dao.findTotalRecordsByUid(userbean);
		PageModel pageModel = new PageModel(num,total,3);
		int startIndex = pageModel.getStartIndex();
		List<ordersBean> list = dao.findOrdersByUidWithPage(userbean,startIndex,pageModel.getPageSize());
		pageModel.setList(list);
		pageModel.setUrl("OrderServlet?method=findOrdersByUidWithPage");
		
		return pageModel;
	}

	@Override
	public ordersBean findoid(String oid) throws Exception {
		OrderDao dao = new OrderDaoImpl();
		ordersBean findoid = dao.findoid(oid);
		return findoid;
	}

}
