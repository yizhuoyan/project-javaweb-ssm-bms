package util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	static private final SqlSessionFactory SESSION_FACTORY=init();
	
	private static SqlSessionFactory init(){
		try{
		String resource = "mybatis.xml";
		InputStream inputStream =SqlSessionUtil.class.getResourceAsStream("/mybatis.xml");
		//创建sqlSession工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
	
	public static SqlSession getSession(){
		SqlSession s=threadLocal.get();
		if(s==null){
			s= SESSION_FACTORY.openSession();
			threadLocal.set(s);
		}
		return s;
	}
	
}
