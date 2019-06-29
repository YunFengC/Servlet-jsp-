package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ProductService;
import ServiceImpl.ProductServiceImpl;
import Utilt.PageModel;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//获取当前页
			int numPage = Integer.parseInt(request.getParameter("num"));
			System.out.println(numPage);
			
			ProductService service = new ProductServiceImpl();
			PageModel pm = service.autoAll(numPage);
			System.out.println(pm.toString());
			System.out.println(pm.getList());
			
			request.setAttribute("page", pm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("/product_list2.jsp").forward(request, response);
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
