package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.AuthorEntity;

public interface AuthorDao extends CommonDao<AuthorEntity>{

	public List<AuthorEntity> selectByKey(@Param("key") String key)throws SQLException;
}
