package cn.itcast.store.service.serviceimpl;

import java.util.List;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.dao.daoimpl.ProductDaoImpl;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao dao = new ProductDaoImpl();
	@Override
	public List<ProductBean> findhotproduct() throws Exception {
		
		return dao.findhotproduct();
	}

	@Override
	public List<ProductBean> findnewproduct() throws Exception {
		
		return dao.findnewproduct();
	}

	@Override
	public List<ProductBean> findProductBypid(String pid) throws Exception {
		
		return dao.findProductBypid(pid);
		
	}

	@Override
	public PageModel findProductsWithCidAndPage(String cid, int num) throws Exception {
		ProductDao dao = new ProductDaoImpl();
		int total = dao.findTotalNum(cid);
		
		PageModel page = new PageModel(num,total,12);
		
		List list = dao.findProductsWithCidAndPage(cid,page.getStartIndex(),page.getPageSize());
		
		page.setList(list);
		page.setUrl("ProductServlet?method=findProductsWithCidAndPage&cid="+cid);
		
		return page;
	}

}
