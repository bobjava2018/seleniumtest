package action.loginoperation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import action.util.FormData;

/**
 * 2019-3-30
 * 登录操作类
 * @author bob
 *
 */
public class LoginOperaAW {
	
	public static  WebDriver driver;
	
	public static   String  baidu_url=FormData.TEST_IP;
	
	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.gecko.driver", "src/driver/geckodriver.exe");
//			
//		
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//		
//		driver=new FirefoxDriver();
//		
//		Thread.sleep(2000);
//		
//		driver.manage().window().maximize();
//		
//		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//		
//		Thread.sleep(2000);
//		
//		driver.get(baidu_url);
//		
//		System.out.println("当前打开的页面是："+driver.getTitle());
//		
//		driver.quit();
		
		LoginOperaAW lg=new LoginOperaAW();
		
		lg.startChrome();
		
		driver.quit();
		
		//lg.startIE();
	}
	  
    public void startChrome() {
	    System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
		
	
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		driver.get(baidu_url);
		
		System.out.println("当前打开的页面是："+driver.getTitle());
		
		try {
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.quit();
    }
    public void startIE() {
    	
	    System.setProperty("webdriver.ie.driver", "src/driver/IEDriverServer.exe");
		
	
		driver=new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		driver.get(baidu_url);
		
		System.out.println("当前打开的页面是："+driver.getTitle());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.quit();
    }
}
