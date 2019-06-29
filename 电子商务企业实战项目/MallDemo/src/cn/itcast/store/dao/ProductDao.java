package cn.itcast.store.dao;

import java.util.List;

import cn.itcast.store.domain.ProductBean;

public interface ProductDao {

	List<ProductBean> findhotproduct()throws Exception;

	List<ProductBean> findnewproduct()throws Exception;

	List<ProductBean> findProductBypid(String pid)throws Exception;

	int findTotalNum(String cid)throws  Exception;

	List findProductsWithCidAndPage(String cid, int startIndex, int pageSize)throws Exception;


}
