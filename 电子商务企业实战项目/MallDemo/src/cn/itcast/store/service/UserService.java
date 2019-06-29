package cn.itcast.store.service;

import java.sql.SQLException;

import cn.itcast.store.domain.UserBean;

public interface UserService {

	void AddUser(UserBean userBean)throws SQLException;

	UserBean userActive(String code)throws SQLException;

	void UpdataUser(UserBean userBean)throws SQLException;

	UserBean UserLogin(String username, String password)throws SQLException;

	boolean AllUserName(String username)throws SQLException;

}
