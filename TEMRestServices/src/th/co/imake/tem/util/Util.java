package th.co.imake.tem.util;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class Util {
	private static final String FILE_PROPERTY = "property";
	private static Properties properties = null;
	private static ResourceBundle bundle;
	
	static {
		if(properties == null){
			if ( bundle == null ) bundle = ResourceBundle.getBundle( FILE_PROPERTY );
				properties = new Properties();
	        for (Enumeration keys = bundle.getKeys (); keys.hasMoreElements ();) {
	            final String key = (String) keys.nextElement ();
	            final String value = bundle.getString (key);
	            properties.put (key, value);
	        } 
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
