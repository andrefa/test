package org.fiveware.web.controller;

import java.util.List;

import org.fiveware.model.entity.Interest;
import org.fiveware.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterestController {

	@Autowired
	private InterestService interestService;

	@RequestMapping(value = "/interest", method = RequestMethod.GET)
	@ResponseBody
	public List<Interest> listInterest() {
		return interestService.listInterests();
	}
	
	@RequestMapping(value = "/interest/{interestId}", method = RequestMethod.GET)
	@ResponseBody
	public Interest find(@PathVariable Long interestId) {
		return interestService.findInterest(interestId);
	}
	
}