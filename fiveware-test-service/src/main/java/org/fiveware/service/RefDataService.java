package org.fiveware.service;

import java.util.List;

import org.fiveware.model.entity.enums.Gender;
import org.springframework.stereotype.Service;

@Service
public interface RefDataService {

	List<Gender> listGenders();
	
}