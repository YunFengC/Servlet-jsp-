package cn.itcast.store.dao.daoimpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.store.dao.UserDao;
import cn.itcast.store.domain.UserBean;
import cn.itcast.store.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void AddUser(UserBean userBean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] param ={userBean.getUid(),userBean.getUsername(),userBean.getPassword(),userBean.getName(),userBean.getEmail(),userBean.getTelephone(),userBean.getBirthday(),userBean.getSex(),userBean.getState(),userBean.getCode()};
		runner.update("insert into user values(?,?,?,?,?,?,?,?,?,?)", param);
	}

	@Override
	public UserBean UserActive(String code) throws SQLException {

		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query("select*from user where code=?",new BeanHandler<UserBean>(UserBean.class),code);

	}

	@Override
	public void UpdataUser(UserBean userBean) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update user set username=? ,password=? ,name=? ,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
		Object[] params = {userBean.getUsername(),userBean.getPassword(),userBean.getName(),userBean.getEmail(),userBean.getTelephone(),userBean.getBirthday(),userBean.getSex(),userBean.getState(),userBean.getCode(),userBean.getUid()};
		runner.update(sql, params);
		
	}

	@Override
	public UserBean UserLogin(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query("select*from user where username=? and password=?", new BeanHandler<UserBean>(UserBean.class),username,password);	
	}

	@Override
	public String AllUserName(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String name = (String) runner.query("select * from user where username=?", new ScalarHandler(),username);
		
		return name;
	}

}
