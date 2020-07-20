package transact.aution;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class DeptDao {

	Logger logger = LoggerFactory.getLogger(DeptDao.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public int deptINS(Map<String, Object> pMap) throws DataAccessException {
		logger.info("deptINS 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.insert("deptINS", pMap);
		return result;
	}

}
