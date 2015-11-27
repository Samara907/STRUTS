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

	/*** ���� ��Ʈ���� ���� reader*/
	public static  Reader reader;
	/*** SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü*/
	public static SqlMapClient sqlMapper;
	
	private List<SboardDTO> list = new ArrayList<SboardDTO>();
	
	/*** ���� ������*/
	private int currentPage = 1;
	/*** �� �Խù��� ��*/
	private int totalCount;
	/*** �� �������� ��*/
	private int blockCount	= 10;
	/*** �� ȭ�鿡 ������  ������ ��*/
	private int blockpage	= 5;
	/*** ����¡�� ������ HTML*/
	private String pagingHtml;
	/*** ����¡ Ŭ����*/
	private PagingAction page;

	
	public String execute() throws SQLException {
		list 	   = sqlMapper.queryForList("board.selectAll");	// ��� ���� ������ list�� �ִ´�.
		totalCount = list.size();								// ��ü �� ������ ���Ѵ�.
		page = new PagingAction(currentPage, totalCount, blockCount,  blockpage);
		pagingHtml = page.getPagingHtml().toString();			// ������ HTML ����.
		
		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;
		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1��ȣ�� ����.
		if (page.getEndCount() < totalCount) {
			lastCount = page.getEndCount() + 1;
		}
		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
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
