package org.fiveware.service.impl;

import java.util.Arrays;
import java.util.List;

import org.fiveware.model.entity.enums.Gender;
import org.fiveware.service.RefDataService;
import org.springframework.stereotype.Service;

@Service
public class RefDataServiceImpl implements RefDataService {

	@Override
	public List<Gender> listGenders() {
		return Arrays.asList(Gender.values());
	}

}