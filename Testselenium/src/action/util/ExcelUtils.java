package action.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;




/**
 * 加载Excel文件中的参数
 * @author admin
 *
 */
public class ExcelUtils {
      public static List<String>  getParameters(){
    	  List<String> params=new ArrayList<String>();
    	  return params;
      }
      
     /**
     * 用来存储从excel中解析出来的参数
     */
    private  static Map<String,String> params=new HashMap<String,String>();
    
    static {
    	 loadParams();
    }
    
    private static  void loadParams() {
    	 HSSFWorkbook  book =null;; 
    	 
    	 File  file =new File("src/formdata/paragram.xls");
    	 InputStream in=null;
    	 try {
			in =new BufferedInputStream(new FileInputStream(file));
			
		    book=new HSSFWorkbook(in);
		    
		    Sheet sheet=null;;
		    
		    Cell cell=null;
		    
		    Row row=null;
		    
		    
		    int sheetsNumbers= book.getNumberOfSheets();
		    
		    String key="";
		    
		    String value="";
		    
		    for(int i=0;i<sheetsNumbers;i++) {
		    	 System.out.println("第"+i+"个sheet");
		    	sheet =book.getSheetAt(i);
		    	
		    	int firstRowNum=sheet.getFirstRowNum();
		    	
		    	int lastRowNum=sheet.getLastRowNum();
		    			    	
		    	  for(int j=firstRowNum;j<=lastRowNum;j++) {
		    		  
		    		  row=sheet.getRow(j);
		    		  
		    		  if(row!=null) {
		    			 
		    			  int firstCellNum=row.getFirstCellNum();
		    			  
		    			  int lastCellNum=row.getLastCellNum();
		    			  
		    			   for(int k=firstCellNum;k<lastCellNum;k++) {
		    				   
		    				   
		    				   cell=row.getCell(k);
		    				   
		    				   if(k==0) {
		    					   key=cell.getStringCellValue(); 
		    				   }
		    				   if(k==1) {
		    					   
		    					   value=cell.getStringCellValue();
		    				   }
		    				   
		    				   params.put(key, value);
		    				   
		    				   if(k==2) {
		    					   break;
		    				   }
		    			   }
		    			  
		    		  }
		    		  
		    	  }
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
    	
    }
    public static Map<String,String> getParams(){
    	return params;
    }
    public static void main(String[] args) {
    	ExcelUtils  excel= new ExcelUtils();
    	
    	Map<String,String> data= excel.getParams();
    	
    	for(String str:data.keySet()) {
    		
    		System.out.println(str+":"+data.get(str));
    		
    	}
	}
}
