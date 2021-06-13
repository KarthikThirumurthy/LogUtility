package com.karthik.mmt.utility.fileReader;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.karthikThirumurthy.mmt.model.LogData;

public class FileReaderUtility {

	@Autowired
	private static Environment env;

	public static ArrayList<LogData> readFile() throws IOException {

		ArrayList<LogData> jsons = new ArrayList<>();
		String path = env.getProperty("LogFileLocation");
		File inputFile = new File(FileReaderUtility.class.getResource(path).getFile());

		try {
			jsons = readInput(inputFile, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsons;
	}

	public static synchronized ArrayList<LogData> readInput(File MyFile, String Encoding)
			throws FileNotFoundException, ParseException {
		Scanner scn = new Scanner(MyFile, Encoding);
		ArrayList<LogData> json = new ArrayList<LogData>();
		// Reading and Parsing Strings to Json
		while (scn.hasNext()) {
			LogData obj = (LogData) new JSONParser().parse(scn.nextLine());
			json.add(obj);
		}
		return json;
	}

}
