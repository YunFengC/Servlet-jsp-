package cn.itcast.store.service.serviceimpl;

import java.util.List;

import org.junit.Test;

import cn.itcast.store.dao.CategoryDao;
import cn.itcast.store.dao.adminDao;
import cn.itcast.store.dao.daoimpl.CategoryDaoImpl;
import cn.itcast.store.dao.daoimpl.adminDaoImpl;
import cn.itcast.store.domain.CategoryBean;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.service.adminSerice;

public class adminSericeImpl implements adminSerice {

	@Override
	public PageModel findProduct(int num) throws Exception {
		adminDao dao = new adminDaoImpl();
		int count = dao.findcount();
		PageModel pm = new PageModel(num,count,7);
		int startIndex = pm.getStartIndex();
		int pageSize = pm.getPageSize();
		List list = dao.findPage(startIndex,pageSize);
		pm.setList(list);
		pm.setUrl("adminServlet?method=findProduct");
		
		return pm;
	}

	@Override
	public List FindCategory() throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		List<CategoryBean> findAllCats = dao.findAllCats();
		return findAllCats;
	}

	@Override
	public void AddCategory(String value) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.AddCategory(value);
	}

	@Override
	public void updateCategory(String value,String cid) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.updateCategory(value,cid);
		
	}
	@Override
	public boolean delectCategory(String cid) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		ProductBean ccid = dao.findP(cid);
		System.out.println("ccid="+ccid);
		if(ccid!=null){
			return false;
		}else{
			dao.delectCategory(cid);
		}
		return true;
		
		
	}

	@Override
	public void updateProduct(ProductBean productBean) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.updateProduct(productBean);
	}

	@Override
	public ProductBean findProduct01(String pid) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		return dao.findProduct01(pid);
	}

	@Override
	public void addProduct(ProductBean productBean) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.addProduct(productBean);
	}

	@Override
	public void updatePflag(String pid) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.updatePflag(pid);
		
	}

	@Override
	public PageModel findProductDiscard(int num) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		int count = dao.counts();
		PageModel pageModel = new PageModel(num,count,7);
		List findProductDiscard = dao.findProductDiscard(pageModel.getStartIndex(),pageModel.getPageSize());
		pageModel.setList(findProductDiscard);
		pageModel.setUrl("admin/product/pushDown_list.jsp");
		
		return pageModel;
	}

	@Override
	public void updatePushDownlist(String pid) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		dao.updatePushDownlist(pid);
		
	}

	@Override
	public PageModel findOrders(int num) throws Exception {
		CategoryDao dao = new CategoryDaoImpl();
		int count = dao.Ordercounts();
		PageModel pageModel = new PageModel(num,count,7);
		List findProductDiscard = dao.findOrders(pageModel.getStartIndex(),pageModel.getPageSize());
		pageModel.setList(findProductDiscard);
		pageModel.setUrl("admin/order/list.jsp");
		
		return pageModel;
	}



}
