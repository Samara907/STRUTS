package struts.board.interceptor;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class IbatisInterceptor implements Interceptor{

	public Reader reader;
	public SqlMapClient sqlMapper;
	
	public void destroy() {}

	public void init() {
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null ) try {reader.close();} catch (IOException ie) {}
		}
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		Object obj = arg0.getAction();
		if (obj instanceof IbatisFace) {
			IbatisFace df = (IbatisFace)obj;
			df.setIbatis(sqlMapper);
		}
		return arg0.invoke();
	}

}
