package cn.itcast.store.dao.daoimpl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public List<ProductBean> findhotproduct() throws Exception {
		String sql = "select * from product where pflag=0 and is_hot=1 order by pdate desc limit 0,9";
		return runner.query(sql, new BeanListHandler<ProductBean>(ProductBean.class));
	}

	@Override
	public List<ProductBean> findnewproduct() throws Exception{
		String sql = "select * from product where pflag=0 order by pdate desc limit 0,9";
		return runner.query(sql, new BeanListHandler<ProductBean>(ProductBean.class));
	}

	@Override
	public List<ProductBean> findProductBypid(String pid) throws Exception {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query("select * from product where pid=?", new BeanListHandler<ProductBean>(ProductBean.class),pid);
	}

	@Override
	public int findTotalNum(String cid) throws Exception {
		
		Long l  = (Long)runner.query("select count(*) from product where cid=?", new ScalarHandler(),cid);
		return l.intValue();
	}

	@Override
	public List findProductsWithCidAndPage(String cid, int startIndex, int pageSize) throws Exception {
		List list =  runner.query("select * from product where cid=?  limit ?,?", new BeanListHandler<ProductBean>(ProductBean.class),cid,startIndex,pageSize);
		return list;
	}


}
