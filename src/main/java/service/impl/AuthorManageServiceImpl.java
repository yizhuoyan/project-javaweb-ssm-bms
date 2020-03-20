package service.impl;

import entity.AuthorEntity;
import formbean.AuthorFB;
import service.AuthorManageService;
import util.ThisSystemUtil;
import static util.AssertUtil.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.AuthorDao;
import dto.PaginationQueryResult;
@Service
public class AuthorManageServiceImpl implements AuthorManageService {
	@Autowired
	private AuthorDao adao;
	@Value("${default.pageSize}")
	private int defaultPageSize;
	
	@Override
	public void addAuthor(AuthorFB b) throws Exception {
		//1验证参数
		String name=$("请输入名字",b.getName());
		int age=ThisSystemUtil.parseInt(b.getAge(),0);
		Date birthDay=ThisSystemUtil.parseDate(b.getBirthDay(), "yyyy-MM-dd");
		Date deadDay=ThisSystemUtil.parseDate(b.getDeadDay(), "yyyy-MM-dd");
		
		//2执行逻辑
		AuthorEntity e=new AuthorEntity();
		e.setAge(age);
		e.setBirthDay(birthDay);
		e.setDeadDay(deadDay);
		e.setIntro(b.getIntro());
		e.setName(name);
		e.setId(ThisSystemUtil.uuid());
		
		adao.insert(e);
		//3组装结果
		//aaaa
	}

	@Override
	public void deleteAuthor(String id) throws Exception {
		
	}

	@Override
	public void modifyAuthor(String id, AuthorFB b) throws Exception {
		//1验证参数
		id=$("id不能为空",id);
		AuthorEntity old=adao.select("id", id);
		
		isNotNull("数据不存在或已被删除", old);
		
		String name=$("请输入名字",b.getName());
		int age=ThisSystemUtil.parseInt(b.getAge(),0);
		Date birthDay=ThisSystemUtil.parseDate(b.getBirthDay(), "yyyy-MM-dd");
		Date deadDay=ThisSystemUtil.parseDate(b.getDeadDay(), "yyyy-MM-dd");
		//2执行业务逻辑
		old.setName(name);
		old.setBirthDay(birthDay);
		old.setDeadDay(deadDay);
		old.setAge(age);
		old.setIntro(b.getIntro());
		
		adao.update(old);
		
	}

	@Override
	public AuthorEntity checkAuthor(String id) throws Exception {
		id=$("id不能为空",id);
		AuthorEntity a=adao.select("id", id);
		isNotNull("数据不存在或已被删除", a);
		
		return a;
	}
	@Override
	public PaginationQueryResult<AuthorEntity> queryByKey(String key, String pageNo, String pageSize) throws Exception {
		//1参数验证
		if(ThisSystemUtil.isBlank(key)){
			key=null;
		}else{
			key="%"+key.trim()+"%";
		}
		int usePageNo=ThisSystemUtil.parseInt(pageNo, 1);
		int usePageSize=ThisSystemUtil.parseInt(pageSize, defaultPageSize);
		//2执行业务逻辑
		PageHelper.startPage(usePageNo, usePageSize);
		List<AuthorEntity> pageList=adao.selectByKey(key);
		PageInfo<AuthorEntity> pageInfo=new PageInfo<>(pageList);
		
		//3业务结果组装
		PaginationQueryResult<AuthorEntity> result=new PaginationQueryResult<>();
		result.setPageNo(usePageNo);
		result.setPageSize(usePageSize);
		result.setTotalRows(pageInfo.getTotal());
		result.setRows(pageList);
		return result;
	}

@Override
public void deleteAuthor(String... ids) throws Exception{
  for(String id:ids){
    adao.delete("id",id);
  }
}
}
