package seleniumCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class SC {
    private WebDriver webDriver;

    public SC(){

    }

    public void createIEBrowser(){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://www.sberbank.ru");
    }

    public boolean selectWindow(WebDriver webDriver, String windowTitle){
        for (String handle : webDriver.getWindowHandles()){
            System.out.println(handle);
            String newWindowTitle = webDriver.switchTo().window(handle).getTitle();
            if (newWindowTitle.equalsIgnoreCase(windowTitle)){
                return true;
            }
        }
        return false;
    }

    public void setIEWebdriver(){
        System.setProperty("webdriver.ie.driver","path to IE driver.exe");
        webDriver = new InternetExplorerDriver();
    }
}
