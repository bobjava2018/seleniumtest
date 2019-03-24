package action.util;

import java.util.HashMap;
import java.util.Map;

public class FormData {
	
	
    private static Map<String,String> data=new HashMap<String,String>();
    
    static {
    	data=ExcelUtils.getParams();
    }
    
    /**
     * 测试用的百度地址
     */
    public static final String TEST_IP=data.get("test_ip");
}
