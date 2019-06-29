package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.CategoryBean;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceimpl.CategoryServiceImpl;
import cn.itcast.store.service.serviceimpl.ProductServiceImpl;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CategoryService service = new CategoryServiceImpl();
		List<CategoryBean> list = service.findAllCats();
		
		request.setAttribute("list", list);*/
		
		
		ProductService service = new ProductServiceImpl();
		List<ProductBean> hotlist = service.findhotproduct();
		List<ProductBean> newlist = service.findnewproduct();
		
		request.setAttribute("hotlist", hotlist);
		request.setAttribute("newlist", newlist);
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		
		return null;
	}
}
