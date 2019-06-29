package cn.itcast.store.dao;

import java.util.List;

public interface adminDao {

	int findcount()throws Exception;

	List findPage(int startIndex,int pageSize)throws Exception;

}
