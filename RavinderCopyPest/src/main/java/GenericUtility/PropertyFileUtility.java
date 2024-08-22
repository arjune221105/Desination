package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * This method read the data form propertyfile Provides key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	public String toReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties props=new Properties();
		props.load(fis);
		
		String value = props.getProperty(key);
		return value ;
	}

}
