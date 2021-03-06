package com.bdd.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	private Properties pro;
	
	public Properties initialize_the_properties()
	{
		pro=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/com/bdd/config/config.properties");
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pro;
	}
}
