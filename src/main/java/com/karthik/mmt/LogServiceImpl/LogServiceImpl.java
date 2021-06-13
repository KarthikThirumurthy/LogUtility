package com.karthik.mmt.LogServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.karthik.mmt.utility.fileReader.FileReaderUtility;
import com.karthikThirumurthy.mmt.ILogService.ILogService;
import com.karthikThirumurthy.mmt.model.LogData;

public class LogServiceImpl implements ILogService {

	@Autowired
	public FileReaderUtility utility;
	public static String AND="AND";
	public static String OR="OR";
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
		boolean containsAnd = false;
		boolean containsOr = false;
		List<LogData> resultList= new ArrayList<LogData>();
		String[] parts = processInputString(inputString);
		if(inputString.contains(AND))
			containsAnd=true;
		if(inputString.contains(OR))
			containsOr=true;
		
		
		if (parts != null) {
			List<String> searchList = Arrays.asList(parts);
			for (LogData data : resultList) {

				if (containsOr) {
					if (searchList.contains(data.getLevel()) || searchList.contains(data.getStep())
							|| searchList.contains((data.getPfm()))) {
						resultList.add(data);
					}
				}
			}
		}
		return resultList.size();
	}
	private String[] processInputString(String inputString) {
		String[] parts = null;
		if(inputString.contains(AND)) {
			 parts = inputString.split((AND));
		}
		if(inputString.contains(OR)) {
			parts= inputString.split(OR);
		}
		
		return parts;
	}

	
}
