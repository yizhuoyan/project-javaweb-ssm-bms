package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;

import dto.PaginationQueryResult;
import entity.AuthorEntity;
import formbean.AuthorFB;

/**
 * 作者管理功能
 * @author Administrator
 *
 */
@Transactional
public interface AuthorManageService {
	/**
	 * 新增作者
	 * @throws Exception
	 */

	void addAuthor(AuthorFB b)throws Exception;
	/**
	 * 通过id来删除作者信息
	 * @param id
	 * @throws Exception
	 */
	void deleteAuthor(String id)throws Exception;
	/**
	 * 修改作者信息
	 * @param id
	 * @throws Exception
	 */
	void modifyAuthor(String id, AuthorFB b)throws Exception;
	/**
	 * 查看作者详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	AuthorEntity checkAuthor(String id)throws Exception;
	/**
	 * 模糊分页查询作者
	 * @param key 查询关键字
	 * @param pageNo 查看的页面
	 * @param pageSize 每页大小
	 * @return 分页查询结果
	 * @throws Exception
	 */
	PaginationQueryResult<AuthorEntity> queryByKey(String key, String pageNo, String pageSize)throws Exception;
  @Transactional
  void deleteAuthor(String... ids)throws  Exception;
}
