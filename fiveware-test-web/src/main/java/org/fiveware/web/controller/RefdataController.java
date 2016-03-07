package org.fiveware.web.controller;

import java.util.List;

import org.fiveware.model.entity.enums.Gender;
import org.fiveware.service.RefDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RefdataController {

	@Autowired
	private RefDataService refdataService;

	@RequestMapping(value = "/refdata/listGenders", method = RequestMethod.GET)
	@ResponseBody
	public List<Gender> listGenders() {
		return refdataService.listGenders();
	}
	
}