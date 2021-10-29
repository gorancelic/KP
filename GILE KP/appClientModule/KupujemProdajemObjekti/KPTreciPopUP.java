package KupujemProdajemObjekti;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class KPTreciPopUP extends BasePageObject{

	private By standardnaVidljivost = By.xpath("//input[@id='data[promo_type]none']");
	private By nextButton = By.xpath("//input[@action-name='adPromoNextButton']");
	
	
	public KPTreciPopUP(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	
	public void StandardnaVidljivost() {
		click(standardnaVidljivost);
	}
	
	public void Next() {
		click(nextButton);
	}
	
}
