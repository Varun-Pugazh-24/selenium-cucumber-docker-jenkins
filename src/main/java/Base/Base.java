package Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Base extends Constants {
	
	static Properties prop;

	public static Properties initProperties() {

		File PropertyFile = new File(CONFIG_PROPERTIES_FILE_PATH);
		try {
			FileInputStream fis = new FileInputStream(PropertyFile);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return prop;

	}

}
