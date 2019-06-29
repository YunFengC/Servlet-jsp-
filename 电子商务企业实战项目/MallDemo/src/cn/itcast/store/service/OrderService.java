package cn.itcast.store.service;

import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.UserBean;
import cn.itcast.store.domain.ordersBean;

public interface OrderService {

	void saveOrder(ordersBean ordersBean)throws Exception;

	PageModel findOrdersByUidWithPage(int num, UserBean userbean)throws Exception;

	ordersBean findoid(String oid)throws Exception;

}
