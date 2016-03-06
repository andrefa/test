package org.fiveware.service.impl;

import java.util.List;

import org.fiveware.model.dao.InterestDao;
import org.fiveware.model.entity.Interest;
import org.fiveware.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestDao interestDao;
	
	@Override
	public List<Interest> listInterests() {
		return interestDao.list();
	}

}