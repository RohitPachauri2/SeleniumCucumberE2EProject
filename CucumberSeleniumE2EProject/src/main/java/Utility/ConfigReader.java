package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties pro;
	/**
	 * used to load properties from config.properties file
	 * @throws IOException
	 */
	public Properties init_prop() throws IOException {
		pro=new Properties();
		FileInputStream fis=new FileInputStream("src/test/java/Config/Config.properties");

		pro.load(fis);
		String browserString=pro.getProperty("browser");
		return pro;
	}
}
