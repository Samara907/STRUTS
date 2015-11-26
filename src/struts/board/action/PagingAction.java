package struts.board.action;

public class PagingAction {
	
	/** * 현재 페이지*/
	private int currentPage;
	/** * 전체 게시물 수 */
	private int totalCount;
	/*** 전체 페이지 수*/
	private int totalPage;
	/*** 한 페이지의 게시물 수*/
	private int blockCount;
	/*** 한 화면에 보여줄 페이지 수*/
	private int blockPage;
	/*** 한 페이지에서 보여줄 게시글의 시작 번호*/
	private int startCount;
	/*** 한 페이지에서 보여줄 게시글의 끝 번호*/
	private int endCount;
	/** * 시작 페이지*/
	private int starPage;
	/*** 마지막 페이지*/
	private int endPage;
	
	private StringBuffer pagingHtml;
	
	// 페이징 생성자
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockpage) {
		
		this.blockCount = blockCount;
		this.blockPage = blockpage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		// 전체 페이지 수
		totalPage = (int)Math.ceil((double)totalCount/blockCount);
		if (totalPage == 0) {
			totalPage = -1;
		}
		// 현제 페이지가 전체 페이지 수 보다 크면 전체 페이지 수로 설정
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// 현제
		
	}
}
