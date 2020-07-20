package mvc.board;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardLogic {
	
	Logger logger = LoggerFactory.getLogger(BoardLogic.class);
	
	private BoardDao boardDao = null;
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("호출 : Logic : boardList");
		List<Map<String, Object>> list = null;
		list = boardDao.boardList(pMap);
		return list;
	}
	
}
