package service;

import org.springframework.transaction.annotation.Transactional;

import dto.UserContext;

public interface UserService {

	/**
	 * 用户登录
	 * @throws Exception
	 */
	public  UserContext login(String account, String password)throws Exception;

	/**
	 * 修改密码
	 * 密码8-16位，必须要包含一个字母，一个数
	 * @param id 用户id
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @param newPasswordConfirm 新密码确认
	 * @throws Exception
	 */
	@Transactional
	public void modifyPassword(String id, String oldPassword, String newPassword, String newPasswordConfirm)throws Exception;
}
