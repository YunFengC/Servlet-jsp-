package cn.itcast.store.dao.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.store.dao.CategoryDao;
import cn.itcast.store.domain.CategoryBean;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.domain.ordersBean;
import cn.itcast.store.utils.JDBCUtils;
import cn.itcast.store.utils.UUIDUtils;

public class CategoryDaoImpl implements CategoryDao {
	QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public List<CategoryBean> findAllCats() throws Exception {
		return runner.query("select * from category", new BeanListHandler<CategoryBean>(CategoryBean.class));
	}

	@Override
	public void AddCategory(String value) throws Exception {
		String sql = "insert into category values('"+UUIDUtils.getId()+"','"+value+"')";
		runner.update(sql);
	}

	@Override
	public void updateCategory(String value,String cid) throws Exception {
		runner.update("update category set cname=? where cid=?",value,cid);
		
	}

	@Override
	public ProductBean findP(String cid) throws Exception {
		return	runner.query("select * from product where cid=?", new BeanHandler<ProductBean>(ProductBean.class),cid);
	}

	@Override
	public void delectCategory(String cid) throws Exception {
		runner.update("delete from category where cid=?",cid);
		
	}

	@Override
	public void updateProduct(ProductBean productBean) throws Exception {
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		runner.update(sql,productBean.getPname(),productBean.getMarket_price(),productBean.getShop_price(),productBean.getPimage(),productBean.getPdate(),productBean.getIs_hot(),productBean.getPdesc(),productBean.getPfiag(),productBean.getCid(),productBean.getPid());
	}

	@Override
	public ProductBean findProduct01(String pid) throws Exception {
		return runner.query("select * from product where pid=?",new BeanHandler<ProductBean>(ProductBean.class),pid);
	}

	@Override
	public void addProduct(ProductBean productBean) throws Exception {
		runner.update("insert into product values(?,?,?,?,?,?,?,?,?,?)",productBean.getPid(),productBean.getPname(),productBean.getMarket_price(),productBean.getShop_price(),productBean.getPimage(),productBean.getPdate(),productBean.getIs_hot(),productBean.getPdesc(),productBean.getPfiag(),productBean.getCid());
	}

	@Override
	public void updatePflag(String pid) throws Exception {
		runner.update("update product set pflag=? where pid=?",1,pid);
	}

	@Override
	public int counts() throws Exception {
		Long l = (Long)runner.query("select count(*) from product where pflag=?", new ScalarHandler(),1);
		return l.intValue();
	}

	@Override
	public List findProductDiscard(int startIndex, int pageSize) throws Exception {
		return runner.query("select * from product where pflag=? limit ?,?", new BeanListHandler<ProductBean>(ProductBean.class),1,startIndex,pageSize);
	}

	@Override
	public void updatePushDownlist(String pid) throws Exception {
		runner.update("update product set pflag=? where pid=?",0,pid);
		
	}

	@Override
	public int Ordercounts() throws Exception {
	Long l =(Long)runner.query("select count(*) from orders", new ScalarHandler());
		return l.intValue();
	}

	@Override
	public List findOrders(int startIndex, int pageSize) throws Exception {
		return runner.query("select * from orders limit ?,?", new BeanListHandler<ordersBean>(ordersBean.class),startIndex,pageSize);
	}
	
}
