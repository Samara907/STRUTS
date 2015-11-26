package struts.board.action;

import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapTransactionManager;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.Interceptor;

import struts.board.bean.SboardDTO;

@SuppressWarnings("serial")
public class ListAction implements Interceptor, ModelDriven<SboardDTO>{

	public static  Reader reader;			// 파일 스트림을 위한 reader
	public static SqlMapClient sqlMapper;	// SqlMapClient API를 사용하기 위한 sqlMapper 객체
	
	private List<SboardDTO> list = new ArrayList<SboardDTO>();
	
	private int currentPage = 1;	// 현재 페이지
	private int totalCount;			// 총 게시물의 수
	private int blockCount	= 10;	// 한 페이지의 수
	private int blockpage	= 5;	// 한 화면에 보여줄  페이지 수
	private String pagingHtml;		// 페이징을 구현한 HTML

	
	public String execute() throws SQLException {
		

		list 	   = sqlMapper.queryForList("board.selectAll");	// 모든 글을 가져와 list에 넣는다.
		totalCount = list.size();								// 전체 글 갯수를 구한다.
		page	   = new pagingac
		return "success";
	}
	
	public SboardDTO getModel() {
		return null;
	}

	public void destroy() {
		
	}

	public void init() {
		
		
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		return null;
	}


}
