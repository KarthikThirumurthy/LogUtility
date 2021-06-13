package com.karthikThirumurthy.mmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.karthikThirumurthy.mmt.ILogService.ILogService;

public class LogController {

	@Autowired
	private ILogService logService;

	// mapping the LogOccurences for Given input
	@GetMapping(value = "/findLogOccurences")
	public int getLogOccurences(String input) {
		return logService.fetchOccurences(input);

	}

}
