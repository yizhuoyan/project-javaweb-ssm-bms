package dto;

import java.util.List;

/**
 * 分页查询结果
 * @author Administrator
 *
 * @param <T>
 */
public class PaginationQueryResult<T> extends QueryResult<T> {
	private static final long serialVersionUID = 139388877941624007L;
	private int totalPages=-1;
	private int pageSize;
	private int pageNo;
	
	public PaginationQueryResult() {
		super();
	}
	public PaginationQueryResult(int totalSize,List<T> data) {
		super(data);
		this.setTotalRows(totalSize);
	}
	public PaginationQueryResult(long totalSize,List<T> data) {
		super(data);
		this.setTotalRows(totalSize);
	}
	public int getTotalPages() {
		if(this.isNotFound())return 0;
		int tp=this.totalPages;
		if(tp==-1){
			int tr=this.getTotalRows();
			int ps=this.getPageSize();
			tp=tr/ps;
			if((tr%ps)!=0){
				tp++;
			}
		}
		return tp;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PaginationQueryResult [totalPages=" + totalPages + ", pageSize=" + pageSize + ", pageNo=" + pageNo
				+ ", isNotFound()=" + isNotFound() + ", isFound()=" + isFound() + ", getMessage()=" + getMessage()
				+ ", getTotalRows()=" + getTotalRows() + ", getExt()=" + getExt() + ", getRows()=" + getRows()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
