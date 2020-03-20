package web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter{
	private Set<String> whiteLists=new HashSet<>();
	private final String message;
	public AuthorizationFilter() {
		message="请先登录!";
	}
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		String url=req.getRequestURI();
		String contextPath=req.getContextPath();
		//获取url
		url=url.substring(contextPath.length());
		//如果当前的url是白名单，则直接通过
		if(inWhiteList(url)){
			chain.doFilter(req, resp);
		}else{
			//否则判断是否登录
			if(isLogin(req)){
				//放行
				chain.doFilter(req, resp);
			}else{
				req.getSession().setAttribute("message", message);
				//如果未登录，则跳到登录界面
				resp.sendRedirect(contextPath+"/login.jsp");
			}
			
		}
	}
	private boolean isLogin(HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session==null)return false;
		Object u=session.getAttribute("currentUser");
		if(u==null)return false;
		return true;
	}
	private boolean inWhiteList(String url){
		return whiteLists.contains(url);
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		String lists=config.getInitParameter("white-list");
		if(lists==null){
			return;
		}
		String[] listArray=lists.trim().split("\\s+");
		whiteLists.addAll(Arrays.asList(listArray));
	}

}
