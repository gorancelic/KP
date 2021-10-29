package KupujemProdajemObjekti;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class KPCetvrtiPopUp extends BasePageObject{
	
	private By fizickoLice = By.xpath("//input[@value='person']");
	private By prihvati = By.xpath("//input[@name='data[accept]']");
	private By postaviteOglas = By.xpath("//input[@value='Postavite oglas']");
	
	public KPCetvrtiPopUp(WebDriver driver, Logger log) {
		super(driver, log);
	}
		
		
		public void FizickoLice() {
			click(fizickoLice);
		}

		public void Prihvati() {
			click(prihvati);
		}

		public void PostaviteOglas() {
			click(postaviteOglas);
			
		}
		
}
