package dao;

import org.apache.ibatis.annotations.Param;


public interface CommonDao<T> {

	void insert(T t)throws Exception;
	
	void delete(@Param("uk") String uk, @Param("value") Object value)throws Exception;
	
	void update(T t)throws Exception;
	
	T select(@Param("uk") String uk, @Param("value") Object value)throws Exception;
	
	boolean exsits(@Param("uk") String uk, @Param("value") Object value)throws Exception;
}
