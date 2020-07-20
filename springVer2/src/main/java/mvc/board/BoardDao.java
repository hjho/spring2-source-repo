package mvc.board;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDao {
	
	Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("호출 : Dao : boardList");
		List<Map<String, Object>> list = null;
		list = sqlSessionTemplate.selectList("boardList",pMap);
		logger.info("list : "+list.toString());
		return list;
	}
}
