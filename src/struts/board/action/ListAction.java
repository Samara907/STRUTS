package struts.board.action;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.Interceptor;

import struts.board.bean.SboardDTO;

@SuppressWarnings("serial")
public class ListAction implements Interceptor, ModelDriven<SboardDTO>{

	public static  Reader reader;			// ���� ��Ʈ���� ���� reader
	public static SqlMapClient sqlMapper;	// SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü
	
	private List<SboardDTO> list = new ArrayList<SboardDTO>();
	
	private int currentPage = 1;	// ���� ������
	private int totalCount;			// �� �Խù��� ��
	private int blockCount	= 10;	// �� �������� ��
	private int blockpage	= 5;	// �� ȭ�鿡 ������  ������ ��
	private String pagingHtml;		// ����¡�� ������ HTML

	
	public String execute() {
		
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
