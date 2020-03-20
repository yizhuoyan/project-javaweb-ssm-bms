package web.handler.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerAdvice {

	/**
	 * 全局的异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public String handlerException(Exception e){
		e.printStackTrace();
		return "forward:/WEB-INF/error.jsp";
	}
	
}
