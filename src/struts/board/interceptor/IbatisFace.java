package struts.board.interceptor;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface IbatisFace {

	/**
	 * @param sqlMapper
	 * ���޹��� ����� Ÿ��
	 */
	public void setIbatis(SqlMapClient sqlMapper);
}
