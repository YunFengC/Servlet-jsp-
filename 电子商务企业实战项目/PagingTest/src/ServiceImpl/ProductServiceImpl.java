package ServiceImpl;

import java.util.List;

import Service.ProductService;
import Utilt.PageModel;
import dao.Dao;
import daoImpl.DaoImpl;

public class ProductServiceImpl implements ProductService {

	@Override
	public PageModel autoAll(int numPage) throws Exception {
		//实现底层数据库查出总数据数和分页列表
		Dao dao = new DaoImpl();
		int total = dao.totalautoAll();
		PageModel pageModel = new PageModel( numPage, 5, total);
		int startIndex = pageModel.getStartIndex();
		List list = dao.listAll(pageModel.getPageSize(),startIndex);
		pageModel.setList(list);
		pageModel.setUrl("ProductServlet");
		return pageModel;
	}
	
}
