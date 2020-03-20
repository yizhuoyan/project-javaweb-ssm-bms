package dto;

import entity.UserEntity;

/**
 * 用户上下文
 * @author Administrator
 *
 */
public class UserContext {

	private UserEntity user;
	
	public UserContext(UserEntity user) {
		super();
		this.user = user;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
