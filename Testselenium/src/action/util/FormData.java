package action.util;

import java.util.HashMap;
import java.util.Map;

public class FormData {
	
	
    private static Map<String,String> data=new HashMap<String,String>();
    
    static {
    	data=ExcelUtils.getParams();
    }
    
    /**
     * �����õİٶȵ�ַ
     */
    public static final String TEST_IP=data.get("test_ip");
}
