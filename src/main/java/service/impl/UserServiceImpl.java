package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dao.UserDao;
import dto.UserContext;
import entity.UserEntity;
import service.UserService;
import util.BMSException;
import util.ThisSystemUtil;

import static util.AssertUtil.*;

import java.net.HttpURLConnection;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao udao;
	@Override
	public UserContext login(String account, String password) throws Exception {
		//1验证参数
		account=$("账户不能为空",account);
		password=$("密码不能为空",password);
		//2执行业务逻辑
		//2.1账户是否存在
		UserEntity u=udao.select("account", account);
		
		isNotNull("账户和密码不匹配", u);
		//2.2账户和密码是否匹配
		password=ThisSystemUtil.md5(password);
		isEquals("账户和密码不匹配", password, u.getPassword());
		/*
		//2.3账户是否禁用
		//2.4账户密码是否过期
		//2.5账户是否有不正常登录情况
		 */
		//3组装业务结果
		UserContext uc=new UserContext(u);
		u.setPassword(null);
		return uc;
	}

	@Override
	public void modifyPassword(String uid, String oldPassword, String newPassword, String newPasswordConfirm)
			throws Exception {
		//1验证参数
		//此处抛出系统级异常
		uid=$("uid不能为空",uid,IllegalArgumentException.class);
		oldPassword=$("旧密码不能为空",oldPassword);
		newPassword=$("新密码不能为空",newPassword);
		newPasswordConfirm=$("新密码不能为空",newPasswordConfirm);
		//2执行业务逻辑
		//2.1 验证旧密码
		UserEntity u= udao.select("id", uid);
		//系统级异常
		isNotNull("用户不存在", u);
		oldPassword=ThisSystemUtil.md5(oldPassword);
		isEquals("旧密码不正确，请重新输入", oldPassword, u.getPassword());
		//2.2 验证两次密码是否一致
		isEquals("两次密码不一致", newPassword, newPasswordConfirm);
		//2.3 验证新密码是否符合规范
			//验证的目的是防君子不能防小人(js验证没鸟用)
			//必须有一个字母，一个数字，一个特殊字符，不少于6位
		isTrue("新密码不符合规范，必须有一个字母，一个数字，一个特殊字符，不少于6位", isValidPassword(newPassword));
			
		//2.4 更新密码
		newPassword=ThisSystemUtil.md5(newPassword);
		u.setPassword(newPassword);
		
		udao.update(u);
		
		
	}
	/**
	 * 验证是否是有效的密码
	 * @param password
	 * @return
	 */
	private boolean isValidPassword(String password){
		return true;
	}
	public static void main(String[] args) {
		String getenv = System.getenv("username");
		System.out.println(getenv);
	}
	
}
