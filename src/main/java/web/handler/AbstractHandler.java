package web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import org.springframework.web.servlet.support.RequestContextUtils;

import entity.UserEntity;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

abstract public class AbstractHandler {
	/**
	 * 获取当前session中的用户
	 * @return
	 */
	public UserEntity getCurrentUser(){
		//从当前线程中取RequestAttributes
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		//从session中获取当前登录用户，如果有的话
		UserEntity u=(UserEntity)requestAttributes.getAttribute("currentUser", RequestAttributes.SCOPE_GLOBAL_SESSION);
		return u;
	}
	/**
	 * 获取当前用户的id
	 * @return
	 */
	public String getCurrentUserId(){
		UserEntity u=this.getCurrentUser();
		if(u!=null){
			return u.getId();
		}
		return null;
	}
}
