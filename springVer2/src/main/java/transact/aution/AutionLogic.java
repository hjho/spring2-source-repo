package transact.aution;

import java.sql.Connection;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutionLogic {
	
	@Autowired(required=false)
	private AutionDao autionDao = null;
	
	@Autowired(required=false)
	private SeedDao seedDao = null;
	
	@Autowired(required=false)
	private ProductDao productDao = null;
	
	Connection con = null;
	//@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=(DataAccessException.class))
	//@Pointcut(value="execution(* transact.aution.*Logic.*(..))")
	public int methodA() {
		int result = 0; // 1이면 업무처리 완료, 0이면 업무처리 실행
		// 진입 바로 직전 - 자동 트랜잭션 기능을 꺼두기 
		try {
			con.setAutoCommit(false);
			
			int r1 = autionDao.autionINS();
			int r2 = seedDao.seedUPD();
			int r3 = productDao.productDEL();
			if(r1 == 0 && r2 == 0 && r3 == 0) {
				result = 1;
				con.commit();
			} else {
				con.rollback();
			}
		} catch(DataAccessException da) {
			throw da;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
