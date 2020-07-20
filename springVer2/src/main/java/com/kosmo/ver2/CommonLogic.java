package com.kosmo.ver2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonLogic {
	@Autowired
	private CommonDao commonDao = null;
	public String currentTime() {
		String cdate = null;
		cdate = commonDao.currentTime();
		return cdate;
	}
}
