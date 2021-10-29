package KupujemProdajemObjekti;

import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.Toolkit;



public class KPDrugiPopUP extends BasePageObject{

	
	
	private By naslovOglasa = By.xpath("//input[@placeholder-job='npr. Pizza majstor u pekari']");
	private By stanje = By.xpath("//input[@value='as-new']");
	private By cena = By.xpath("//input[@id='price_number']");
	private By cenaValuta = By.xpath("//input[@id='currency_eur']");
	
	private By dodajSlike = By.xpath("//div[@value-name='ad-photos-remaining']");
	private By slikaDodata = By.xpath("//div[@id='thumbnailHolder1']");
	private By nextButton = By.xpath("//input[@action-name='adInfoNextButton']");
	String Cena;
	String SubjectOglasa = "OverRide";
	String TekstOglasa = "â†’ Slika se moÅ¾da razlikuje od prave komponente\r\n"
			+ "â†’ Novo, nekoriÅ¡Ä‡eno\r\n"
			+ "â†’ Garancija\r\n"
			+ "â†’ Rok isporuke 3-5 dana\r\n"
			+ "â†’ LiÄ�no preuzimanje: Novi Sad, Beograd, Subotica\r\n"
			+ "â†’ Slanje kurirskom sluÅ¾bom\r\n"
			+ "â†’ Cena kod dobavljaÄ�a se menja na dnevnom nivou, kontaktirati za trenutnu cenu\r\n"
			+ "â†’ MoguÄ‡nost nauÄ�ivanja i onoga Å¡to nemamo na oglasima\r\n"
			+ "â†’ Pogledajte i naÅ¡e ostale oglase";
	
	
	
	public KPDrugiPopUP(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public boolean isDugmePredloziVisible() {
		log.info("Drugi popUp je ucitan");
		return find(naslovOglasa).isDisplayed();
	}
	
	public void PopuniNaslov(String SubjectOglasa) {
		log.info("Naslov je popunjen");
		type(SubjectOglasa, naslovOglasa);
	}
	
	public void PopuniStanje() {
		log.info("Stanje je popunjeno");
		click(stanje);
	}
	
	public void PopuniCenu(String Cena) {
		log.info("Cena je popunjena");
		type(Cena, cena);
	}
	
	public void PopuniValutu() {
		log.info("Valuta je popunjena");
		click(cenaValuta);
	}
	
	public void PopuniTekstOglasa() {
		
		log.info("Tekst je unesen");
		driver.switchTo().frame("data[description]_ifr");
		driver.findElement(By.cssSelector("body")).sendKeys(TekstOglasa);
		driver.switchTo().parentFrame();	
	}
	
	
	public void UploadDokument(String SubjectOglasa) throws Exception {
	click(dodajSlike);
	//driver.findElement(By.id("adPhotosHolder")).sendKeys("C:/Gile/file.jpg");
	/*
	 * driver.switchTo() .activeElement() .sendKeys( "C:/Gile/file.jpg");
	 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 */
		  StringSelection ss = new StringSelection(SubjectOglasa);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  
		 Thread.sleep(1000);
			
			  Robot robot = new Robot();
			  
			  robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
			  robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
			  
			  robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
			  
			 
			/*
			 * 
			 * shell = win32com.client.Dispatch("WScript.Shell")
			 * shell.Sendkeys("C:\text.txt") shell.Sendkeys("~")
			 */
	}
	public boolean isPictureUploaded() {
		
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='thumbnailHolder1']")));
		log.info("Slika je dodata");
		return find(slikaDodata).isDisplayed();
	}
	public void Next() {
		click(nextButton);
	}
	
}
	
