package KupujemProdajemObjekti;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KPPrviPopUP extends BasePageObject{

	
	private String pageUrl = "https://www.kupujemprodajem.com/oglasi.php?action=new";
	
	
	private By prviButton = By.xpath("//div[@id='submitAdHolder']");
	private By poljeZaProizvod = By.xpath("//input[@id='data[group_suggest_text]']");
	private By dugmePredlozi = By.xpath("//input[@value='Predloži gde']");
	private By maticnePloce = By.xpath("//label[@group-name='Matične ploče']");
	private By dobroDosli = By.xpath("//div[@class='kpBoxCloseButton']");
	private By login = By.xpath("//a[@href='/login']");
	
	
	private By predefinisano = maticnePloce;
	
	public KPPrviPopUP(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	
	public String getPageUrl() {
		return pageUrl;
	}
	
	public void skloniDobroDosli() {
		click(dobroDosli);
	}
	
	
	public void Login() {
		click(login);
	}
	
	public void klikniPostaviOglas() {
		click(prviButton);
	}
	
	public boolean isDugmePredloziVisible() {
		log.info("Stranica je ucitana");
		return find(dugmePredlozi).isDisplayed();
	}
	
	public void predefinisanaOblast() {
		log.info("kliknuti na predefinisanu oblast");
		click(predefinisano);
	}
	
	
	
	
}
