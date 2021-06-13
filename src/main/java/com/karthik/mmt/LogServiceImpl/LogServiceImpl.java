package com.karthik.mmt.LogServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.karthik.mmt.utility.fileReader.FileReaderUtility;
import com.karthikThirumurthy.mmt.ILogService.ILogService;
import com.karthikThirumurthy.mmt.model.LogData;

public class LogServiceImpl implements ILogService {

	@Autowired
	public FileReaderUtility utility;
	public int fetchOccurences(String inputString) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			ArrayList<LogData> inputJsons = utility.readFile();
			result= processInputFileAndfetchResult(inputJsons, inputString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private int processInputFileAndfetchResult(ArrayList<LogData> inputJsons, String inputString) {
		// TODO Auto-generated method stub
		return 0;
	}

}
