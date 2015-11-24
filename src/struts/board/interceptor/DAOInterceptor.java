package struts.board.interceptor;

import java.io.IOException;
import java.io.Reader;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

@SuppressWarnings("serial")
public class DAOInterceptor implements Interceptor{

	public void destroy() {
		
	}

	public void init() {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			@SuppressWarnings("unused")
			SqlMapClient sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String intercept(ActionInvocation arg0) throws Exception {
		return arg0.invoke();
	}

}
