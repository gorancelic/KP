package gile.kupujemprodajem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;


import KupujemProdajemObjekti.KPCetvrtiPopUp;
import KupujemProdajemObjekti.KPDrugiPopUP;
import KupujemProdajemObjekti.KPLogin;
import KupujemProdajemObjekti.KPPrviPopUP;
import KupujemProdajemObjekti.KPTreciPopUP;
import KupujemProdajemObjekti.WelcomePageObject;
import test.baza.TestUtilities;

public class DataDrivenTestingUsingCSVInSelenium extends TestUtilities{

	    
	    //Provide test data CSV file path. As below path based on Mac machine. So, lets say you are using windows machine then write the below path accordingly. 
	    String CSV_PATH = "./CSVmaticneploce.csv";
	    //WebDriver driver;
	    private CSVReader csvReader;
	    String[] csvCell;
		private WelcomePageObject welcomePage;
	    
	    @Test
	    
	    public void dataRead_CSV() throws Exception {
	        //Create an object of CSVReader
	    	
	        csvReader = new CSVReader(new FileReader(CSV_PATH));
	 
	        log.info("Starting Postavi Oglas");

			
			  // open main page WelcomePageObject 
	        welcomePage = new WelcomePageObject(driver, log); 
			  welcomePage.openPage();
			  
				
				  KPPrviPopUP Prvi = new KPPrviPopUP(driver, log); 
				  Prvi.skloniDobroDosli();
				  sleep(1000);
				  
				  KPPrviPopUP Drugi = new KPPrviPopUP(driver, log); 
				  Drugi.Login(); sleep(1000);
				  
				  KPLogin Login = new KPLogin(driver, log); 
				  Login.PopuniUsername();
				  Login.PopuniPassword(); 
				  Login.Login();
				  
				  KPPrviPopUP Treci = new KPPrviPopUP(driver, log); 
				  Treci.klikniPostaviOglas();
				 
	 
	        //You can use while loop like below, It will be executed until the last line in CSV used. 
	        while ((csvCell = csvReader.readNext()) != null) {
	            String SubjectOglasa = csvCell[0];
	            System.out.println("iz fajla je izvucen proizvod:" +SubjectOglasa);
	            String Cena = csvCell[1];
	            System.out.println("iz fajla je izvucena cena:" +Cena);
	  
				
				
				
				  KPPrviPopUP Cetvrti = new KPPrviPopUP(driver, log);
				  Cetvrti.isDugmePredloziVisible(); 
				  Cetvrti.predefinisanaOblast();
				  
				  KPDrugiPopUP Peta = new KPDrugiPopUP(driver, log);
				  Peta.isDugmePredloziVisible(); 
				  Peta.PopuniNaslov(SubjectOglasa);
				  Peta.PopuniStanje(); 
				  Peta.PopuniCenu(Cena); 
				  Peta.PopuniValutu();
				  Peta.PopuniTekstOglasa(); 
				  				  
				  Peta.UploadDokument(SubjectOglasa);
				  Peta.isPictureUploaded();
				  Peta.Next();
				  
				  KPTreciPopUP Sesti = new KPTreciPopUP(driver, log);
				  Sesti.StandardnaVidljivost(); 
				  Sesti.Next();
				  
				  KPCetvrtiPopUp Sedmi = new KPCetvrtiPopUp(driver, log); 
				  Sedmi.FizickoLice();
				  Sedmi.Prihvati(); 
				  Sedmi.PostaviteOglas();
				  System.out.println("Oglas je uspesno postavljen:" +SubjectOglasa);
				  
				  KPPrviPopUP Osmi = new KPPrviPopUP(driver, log); 
				  Osmi.klikniPostaviOglas();
				
	        }
	    
		}
	    
}
	    