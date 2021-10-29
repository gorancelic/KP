package KupujemProdajemObjekti;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class KPLogin extends BasePageObject{

	private By username = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='submitButton']");
	
	public KPLogin(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void PopuniUsername() {
		log.info("Naslov je popunjen");
		type("tanasic.georgije1999@gmail.com", username);
	}
	
	public void PopuniPassword() {
		log.info("Naslov je popunjen");
		type("Aleksa123!", password);
	}
	
	public void Login() {
		click(login);
	}
	
	
}
