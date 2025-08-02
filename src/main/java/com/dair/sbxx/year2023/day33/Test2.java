package com.dair.sbxx.year2023.day33;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

import org.apache.commons.configuration2.YAMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.DefaultExpressionEngineSymbols;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2023/5/26
 ************************************************************/
public class Test2 {
	
	public static List<Map<String, Object>> realYaml(){
		Map<String, Object> hashMap=new HashMap<>();
		InputStream resourceStream = null;
		try {
			resourceStream = new FileInputStream(new File("/Users/dary/Documents/project/algorithm-sbxx/src/main/resources/application1.yml"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		Yaml test=new Yaml();
		List<Map<String,Object> > map=test.load(resourceStream);
		if (null != resourceStream) {
			YAMLConfiguration config = new YAMLConfiguration();
			
			try {
				LoaderOptions loaderOptions=new LoaderOptions();
				loaderOptions.setAllowDuplicateKeys(false);
				config.read(resourceStream,loaderOptions);
			} catch (ConfigurationException e) {
				throw new RuntimeException(e);
			}
			Iterator<String> keys = config.getKeys();
			while (keys.hasNext()) {
				String key = keys.next();
				Object property = config.getProperty(key);
				if (key.contains(DefaultExpressionEngineSymbols.DEFAULT_ESCAPED_DELIMITER)) {
					//yml解析带小数点的Key，会将key值中的小数点替换成两个小数点，这里替换回去
					key = key.replace(DefaultExpressionEngineSymbols.DEFAULT_ESCAPED_DELIMITER,
							DefaultExpressionEngineSymbols.DEFAULT_PROPERTY_DELIMITER);
				}
				hashMap.put(key, property);
			}
			List<Map<String, Object>> res=new ArrayList<>();
			res.add(hashMap);
			return res;
			
		}
		return null;
	
	}
	
	public static void main(String[] args) {
		String ss=Objects.requireNonNull("1");
		System.out.println(realYaml());
	}
	
	
	
}
