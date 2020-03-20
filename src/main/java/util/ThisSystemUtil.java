package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.management.RuntimeErrorException;

public class ThisSystemUtil {

	public static String uuid(){
		String uuid=UUID.randomUUID().toString();
		char[] cs=new char[32];
		char c=0;
		for(int i=uuid.length(),j=0;i-->0;){
			if((c=uuid.charAt(i))!='-'){
				cs[j++]=c;
			}
		}
		return new String(cs);
	}
	static public boolean isBlank(String target){
		return target==null||target.trim().length()==0;
	}
	
	public static int parseInt(String target,int defaultValue){
		try{
			return Integer.parseInt(target);
		}catch(Exception e){
			return defaultValue;
		}
	}
	/**
	 * 解析日期，如果不能解析，则异常
	 * @param target
	 * @return
	 * @throws ParseException 
	 */
	public static Date parseDate(String target,String pattern) throws ParseException{
		if(isBlank(target))return null;
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.parse(target);
	}
	/**
	 * 计算字符串md5
	 * @param str
	 * @return
	 */
	public static String md5(String s) {
		if(s==null)return null;
		s+="$$";
	    try {
	        // 生成一个MD5加密计算摘要
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // 计算md5函数
	        md.update(s.getBytes());
	        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	        s= new BigInteger(1, md.digest()).toString(16);
	        char[] cs=new char[s.length()];
	        for(int i=s.length(),j=0;i-->0;cs[j++]=s.charAt(i));
	        return new String(cs);
	    } catch (Exception e) {
	        throw new RuntimeException("MD5加密出现错误");
	    }
	}
	final static  public void main(String[] args) {
		System.out.println(md5("admin"));
	}
}
