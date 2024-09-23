package comBplHRMGenericFileUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * This class is used to read data from Json File
 * @author whosc
 *
 */
public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable, ParseException {
		FileReader fileReader=new FileReader("./configAppData/CommonData.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fileReader);
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(key);
		return data;
		
	}

}
