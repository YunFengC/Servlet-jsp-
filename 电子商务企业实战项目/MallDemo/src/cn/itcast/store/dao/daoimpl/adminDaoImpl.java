package cn.itcast.store.dao.daoimpl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.store.dao.adminDao;
import cn.itcast.store.domain.ProductBean;
import cn.itcast.store.utils.JDBCUtils;

public class adminDaoImpl implements adminDao {
	QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public int findcount() throws Exception {
		Long l = (Long)runner.query("select count(*) from product where pflag=?", new ScalarHandler(),0);
		return l.intValue();
	}
	@Override
	public List findPage(int startIndex,int pageSize) throws Exception {
		return runner.query("select * from product where pflag=? limit ?,?", new BeanListHandler<ProductBean>(ProductBean.class),0,startIndex,pageSize);
	}

}
