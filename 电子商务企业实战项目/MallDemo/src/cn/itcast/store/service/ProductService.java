package cn.itcast.store.service;

import java.util.List;

import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.ProductBean;

public interface ProductService {

	List<ProductBean> findhotproduct() throws Exception;

	List<ProductBean> findnewproduct() throws Exception;

	List<ProductBean> findProductBypid(String pid)throws Exception;

	PageModel findProductsWithCidAndPage(String cid, int num)throws Exception;

}
