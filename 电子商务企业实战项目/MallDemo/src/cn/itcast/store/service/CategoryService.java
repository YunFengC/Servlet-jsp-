package cn.itcast.store.service;

import java.util.List;

import cn.itcast.store.domain.CategoryBean;
import cn.itcast.store.domain.ProductBean;

public interface CategoryService {

	List<CategoryBean> findAllCats() throws Exception;

	List<ProductBean> findhotproduct() throws Exception;

	List<ProductBean> findnewproduct() throws Exception;

}
