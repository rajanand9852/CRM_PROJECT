import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class json {

	public static void main(String[] args) throws ParseException {
		//step1:parse json physical file in to java object using jsonparse class
		 JSONParser parser =new JSONParser();
		 Object obj=parser.parse("./configData/AppCommonData.json");
		 
		 //step2:convert java object in to jsonobject using down casting
		 JSONObject map=(JSONObject)obj;
		 System.out.println(map.get("url"));

	}

}
