package cn.itcast.store.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.CategoryBean;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.serviceimpl.CategoryServiceImpl;
import cn.itcast.store.web.base.BaseServlet;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends BaseServlet {

	public String findAllCats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryService service = new CategoryServiceImpl();
		List<CategoryBean> list = service.findAllCats();
		
		String jsonfile = JSONArray.fromObject(list).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonfile);
		
		return null;
	}
}
