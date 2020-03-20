package dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 查询结果模型
 */
public class QueryResult<T>  implements Serializable{
	private static final long serialVersionUID = -7873892176012856700L;
	private String message="";
	private HashMap<String,Object> ext;
	private List rows;
	private int totalRows=0;
	
	public QueryResult() {
	}
	
	public QueryResult(List rows) {
		if(rows!=null){
			this.totalRows=rows.size();
			this.setRows(rows);
		}
	}
	
	
	
	
	public boolean isNotFound() {
		return this.totalRows<=0;
	}
	public boolean isFound() {
		return this.totalRows>0;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getTotalRows() {
		return this.totalRows;
	}
	public void setTotalRows(int totalRecords) {
		this.totalRows = totalRecords;
	}
	public void setTotalRows(long totalRecords) {
		this.totalRows=(int)totalRecords;
	}
	public Object putExt(String key,Object value){
		HashMap<String, Object> thisext=this.ext;
		if(thisext==null){
			this.ext=thisext=new HashMap<String,Object>();
		}
		return thisext.put(key, value);
	}
	public Object getExt(String key){
		return this.ext==null?null:this.ext.get(key);
	}
	public Object removeExt(String key){
		HashMap<String, Object> thisext=this.ext;
		if(thisext!=null){
			return thisext.remove(key);
		}
		return null;
	}
	public HashMap<String, Object> getExt() {
		return this.ext;
	}
	public List getRows() {
		return this.rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
