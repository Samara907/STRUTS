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
	private int startPage;
	/*** ������ ������*/
	private int endPage;
	
	private StringBuffer pagingHtml;
	
	// ����¡ ������
	/**
	 * @param currentPage
	 * ���� ������
	 * @param totalCount
	 * ��ü �Խù� ��
	 * @param blockCount
	 * �� �������� �Խù� ��
	 * @param blockpage
	 * �� ȭ�鿡 ������ ������ ��
	 * @return 
	 */
	public PagingAction(int currentPage, int totalCount, int blockCount, int blockpage) {
		
		this.blockCount  = blockCount;
		this.blockPage   = blockpage;
		this.currentPage = currentPage;
		this.totalCount  = totalCount;
		// ��ü ������ ��
		totalPage = (int)Math.ceil((double)totalCount/blockCount);
		if (totalPage == 0) {
			totalPage = -1;
		}
		// ���� �������� ��ü ������ �� ���� ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// ���� �������� ó���� ������ ���� ��ȣ ��������
		startCount = (currentPage -1) * blockCount;
		endPage	   = startCount + blockCount -1;
		
		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		// ���� block ������
		pagingHtml = new StringBuffer();
		if (currentPage > blockpage) {
			pagingHtml.append("<a href=listAction.action?currentPage="
					+ (startPage -1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
		
		pagingHtml.append("&nbsp;|&nbsp;");
		
		// ������ ��ȣ. ���� �������� ���������� �����ϰ� ��ũ�� ����
		for(int i=startPage; i<=endPage; i++) {
			if (i>totalPage) {
				break;
			}
			if (i==currentPage) {
				pagingHtml.append("&nbsp;<b> <font color='red'>");
				pagingHtml.append(i);
				pagingHtml.append("</font></b>");
			} else {
				pagingHtml.append("&nbsp;<a href='listAction.action?currentPage=");
				pagingHtml.append(i);
				pagingHtml.append("'>");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp;");
		}
			pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
		
		// ���� block ������
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<a href=listAction.action?currentPage="
					+ (endPage +1) +">");
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int starPage) {
		this.startPage = starPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(StringBuffer pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	
}
