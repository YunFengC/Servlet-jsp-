package cn.itcast.store.service.serviceimpl;

import java.util.List;

import cn.itcast.store.dao.CategoryDao;
import cn.itcast.store.dao.daoimpl.CategoryDaoImpl;
import cn.itcast.store.domain.CategoryBean;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<CategoryBean> findAllCats() throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		return dao.findAllCats();
	}

	@Override
	public List<ProductBean> findhotproduct() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBean> findnewproduct() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
