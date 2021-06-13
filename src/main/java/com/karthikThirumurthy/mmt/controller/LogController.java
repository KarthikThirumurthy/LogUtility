package com.karthikThirumurthy.mmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karthikThirumurthy.mmt.ILogService.ILogService;

public class LogController {

	@Autowired
	private ILogService logService;

	// mapping the LogOccurences for Given input
	@GetMapping(value = "/findLogOccurences")
	@ResponseBody
	public int getLogOccurences(@RequestParam String input) {
		return logService.fetchOccurences(input);

	}

}
