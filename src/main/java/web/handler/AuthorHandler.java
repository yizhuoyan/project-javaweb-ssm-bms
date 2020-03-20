package web.handler;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AjaxResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;

import dto.PaginationQueryResult;
import entity.AuthorEntity;
import entity.UserEntity;
import formbean.AuthorFB;
/**
 * 作者管理handler
 * @author Administrator
 *
 */
import service.AuthorManageService;
import util.BMSException;
@Controller
@RequestMapping("/author")
public class AuthorHandler {
	@Autowired
	AuthorManageService ams;
	
	@GetMapping("/add")
	public String addView(){
		return "author/add";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute("authorFB") AuthorFB a,Map model,@ModelAttribute("currentUser") UserEntity u)throws Exception{
		String message=null;
		try{
		//1调用业务方法进行处理
		ams.addAuthor(a);
		//2把业务结果转为模型
		message="新增成功!";
		model.put("message", message);
		model.put("url", "author/qry.do");
		return "message";
		//3设置视图
		}catch(BMSException e){
			message=e.getMessage();
		}
		model.put("message", message);
		return "author/add";
	}
	
	@RequestMapping("qry")
	public String queryByKey(@ModelAttribute("tt") String xxx, String key,String pageNo,String pageSize,Map map)throws Exception{
		try{
			PaginationQueryResult<AuthorEntity> result=ams.queryByKey(key, pageNo, pageSize);
			map.put("result", result);
		}catch(BMSException e){
			
		}
		return "author/list";
	}
	@GetMapping("check.do")
	public String check(String id,Map m)throws Exception{
		try{
			//先尝试中模型中获取
			AuthorEntity a=ams.checkAuthor(id);
			m.put("m", a);
		}catch(BMSException e){
			m.put("message", e.getMessage());
		}
		return "author/mod";
	}
	@PostMapping("mod.do")
	public String mod(String id,AuthorFB b,Map model)throws Exception{
		String message=null;
		try{
			ams.modifyAuthor(id, b);	
			message="修改成功!";
			model.put("message", message);
			model.put("url", "author/qry.do");
			return "message";
		}catch(BMSException e){
			model.put("message", e.getMessage());
		}
		return "author/mod";
	}

	@PostMapping("del.do")
  @ResponseBody
	public  AjaxResponce del(@RequestParam("id") String[] ids,Map model)throws Exception{
    System.out.println(Arrays.toString(ids));
    ams.deleteAuthor(ids);

    AjaxResponce resp=new AjaxResponce();
    resp.setCode("ok");
    resp.setMessage("删除成功!");
    resp.setData(3);
    return resp;
  }
	
}

