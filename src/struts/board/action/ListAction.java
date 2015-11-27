package struts.board.action;

import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

import struts.board.bean.SboardDTO;
import struts.board.interceptor.IbatisFace;

public class ListAction extends ActionSupport implements IbatisFace{

	/*** 파일 스트림을 위한 reader*/
	public static  Reader reader;
	/*** SqlMapClient API를 사용하기 위한 sqlMapper 객체*/
	public static SqlMapClient sqlMapper;
	
	private List<SboardDTO> list = new ArrayList<SboardDTO>();
	
	/*** 현재 페이지*/
	private int currentPage = 1;
	/*** 총 게시물의 수*/
	private int totalCount;
	/*** 한 페이지의 수*/
	private int blockCount	= 10;
	/*** 한 화면에 보여줄  페이지 수*/
	private int blockpage	= 5;
	/*** 페이징을 구현한 HTML*/
	private String pagingHtml;
	/*** 페이징 클래스*/
	private PagingAction page;

	
	public String execute() throws SQLException {
		list 	   = sqlMapper.queryForList("board.selectAll");	// 모든 글을 가져와 list에 넣는다.
		totalCount = list.size();								// 전체 글 갯수를 구한다.
		page = new PagingAction(currentPage, totalCount, blockCount,  blockpage);
		pagingHtml = page.getPagingHtml().toString();			// 페이지 HTML 생성.
		
		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;
		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1번호로 설정.
		if (page.getEndCount() < totalCount) {
			lastCount = page.getEndCount() + 1;
		}
		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);
		
		return "success";
	}
	
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}
	

	public String intercept(ActionInvocation arg0) throws Exception {
		return null;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		ListAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		ListAction.sqlMapper = sqlMapper;
	}

	public List<SboardDTO> getList() {
		return list;
	}

	public void setList(List<SboardDTO> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockpage() {
		return blockpage;
	}

	public void setBlockpage(int blockpage) {
		this.blockpage = blockpage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public PagingAction getPage() {
		return page;
	}

	public void setPage(PagingAction page) {
		this.page = page;
	}
}
