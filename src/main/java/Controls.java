import java.util.HashMap;
import java.util.Map;

public class Controls {
	

	
	// General length restrictions often re-used
	final int GENERAL_MIN_LENGTH = 2;
	final int GENERAL_MAX_LENGTH = 15;
	
	// Client restrictions
	// companyName 1,0
	final int CLIENT_COMPANY_NAME_MIN_LENGTH = GENERAL_MIN_LENGTH;
	
	Map<String, int[]> testMap = new HashMap<>();
	
	
	public Controls() {

		testMap.put("test", new int[] {0, 2} );
		testMap.get("test");
	}
	
	
	
}
