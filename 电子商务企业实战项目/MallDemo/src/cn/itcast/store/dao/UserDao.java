package cn.itcast.store.dao;

import java.sql.SQLException;

import cn.itcast.store.domain.UserBean;

public interface UserDao {

	void AddUser(UserBean userBean)throws SQLException;

	UserBean UserActive(String code)throws SQLException;

	void UpdataUser(UserBean userBean)throws SQLException;

	UserBean UserLogin(String username, String password)throws SQLException;

	String AllUserName(String username)throws SQLException;
	
}
