package helper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bsh.ParseException;

public class JsonHelper {
	JSONParser parser;
	Reader reader;

	public String readData(String jsonPath, String valueName) throws IOException, ParseException, org.json.simple.parser.ParseException {
		parser = new JSONParser();

		//reader = new FileReader(jsonPath);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(jsonPath), "utf-8"));
		
		JSONObject jsonObject = (JSONObject) parser.parse(buff);
		String name = (String) jsonObject.get(valueName);

		return name;
	}
}
