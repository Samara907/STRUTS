package struts.board.action;

public class PagingAction {
	
	/** * ���� ������*/
	private int currentPage;
	/** * ��ü �Խù� �� */
	private int totalCount;
	/*** ��ü ������ ��*/
	private int totalPage;
	/*** �� �������� �Խù� ��*/
	private int blockCount;
	/*** �� ȭ�鿡 ������ ������ ��*/
	private int blockPage;
	/*** �� ���������� ������ �Խñ��� ���� ��ȣ*/
	private int startCount;
	/*** �� ���������� ������ �Խñ��� �� ��ȣ*/
	private int endCount;
	/** * ���� ������*/
	private int starPage;
	/*** ������ ������*/
	private int endPage;
	
	private StringBuffer pagingHtml;
	
	// ����¡ ������
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockpage) {
		
		this.blockCount = blockCount;
		this.blockPage = blockpage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		// ��ü ������ ��
		totalPage = (int)Math.ceil((double)totalCount/blockCount);
		if (totalPage == 0) {
			totalPage = -1;
		}
		// ���� �������� ��ü ������ �� ���� ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// ����
		
	}
}
