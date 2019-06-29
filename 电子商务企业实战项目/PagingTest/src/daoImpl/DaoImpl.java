package daoImpl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Utilt.JDBCUtils;
import dao.Dao;
import domain.Product;

public class DaoImpl implements Dao {
	QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public int totalautoAll() throws Exception {
		Long l = (Long)runner.query("select count(*) from product", new ScalarHandler());
		return l.intValue();
	}
	@Override
	public List listAll(int pageSize, int startIndex) throws Exception {
		return runner.query("select * from product limit ?,?", new BeanListHandler<Product>(Product.class),startIndex,pageSize);
	}




}
