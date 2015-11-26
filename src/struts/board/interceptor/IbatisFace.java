package struts.board.interceptor;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface IbatisFace {

	/**
	 * @param sqlMapper
	 * 전달받을 대상의 타입
	 */
	public void setIbatis(SqlMapClient sqlMapper);
}
