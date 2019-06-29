package dao;

import java.util.List;

public interface Dao {

	int totalautoAll() throws Exception;

	List listAll(int pageSize,int startIndex) throws Exception;

}
