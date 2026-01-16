package MarathonPractice;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class AmazonAppEntitlement {
	
	// ANSI Color Codes
	static String ANSI_RESET = "\u001B[0m";
    static String ANSI_RED = "\u001B[31m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_Yellow = "\u001B[33m";
		
    public static void main(String[] args) throws InterruptedException, IOException {
    	
    	//headless browser for chrome
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless=new"); 
    	options.addArguments("--disable-gpu");
    	options.addArguments("--window-size=1920,1080");
    	ChromeDriver driver=new ChromeDriver(options);
    	
    	//for output
    	FileWriter csvWriter = new FileWriter("./AmazonAppEntitlementResults.csv");
        csvWriter.append("ASIN,AppName,Result\n");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    	//Initialize timing and storing 
    	LocalDateTime startTime = LocalDateTime.now();
    	
    	System.out.println(ANSI_GREEN+"--------Run has started--------"+ANSI_RESET);    	
    	// Amazon site URL
    	System.out.println("Opening the"+ANSI_Yellow+ " amazon.com" +ANSI_RESET+" site" + " for entitle the US apps" );
		driver.get("http://amazon.com");
		driver.manage().window().maximize();
		// Clicking sign in button
		System.out.println("Clicking signin button for "+ANSI_Yellow+"open signin page"+ANSI_RESET);
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		// Entering email ID
		System.out.println("Entering "+ANSI_Yellow+"Email ID"+ANSI_RESET);
		driver.findElement(By.id("ap_email_login")).sendKeys("rsivakus+tester1@amazon.com");
		//Clicking Continue button
		driver.findElement(By.className("a-button-input")).click();
		// Entering password
		System.out.println("Entering "+ANSI_Yellow+"password"+ANSI_RESET);
		driver.findElement(By.id("ap_password")).sendKeys("qwerty123");
		//Clicking Sign in button
		System.out.println("Clicking "+ANSI_Yellow+ "signin"+ANSI_RESET+" button");
		driver.findElement(By.id("signInSubmit")).click();
		
		//open the WB/excel
		XSSFWorkbook wb=new XSSFWorkbook("./data/ASINFile.xlsx");
		//Identify the Worksheet
		XSSFSheet ws = wb.getSheetAt(0);
		//identify the Physical Number Of Rows
		int rowCount = ws.getPhysicalNumberOfRows();
		//loop 
		for (int i = 1; i <= rowCount-1; i++) {
			//To get A1 row from the excel
		    String ASIN = ws.getRow(i).getCell(0).getStringCellValue();
	   System.out.println(ANSI_Yellow+"--------------------------------"+ANSI_RESET);
	
	   //Entering for ASIN in the search
	   driver.findElement(By.id("twotabsearchtextbox")).clear();
	   System.out.println(ANSI_GREEN + "Searching for ASIN : " + ASIN +"..." + ANSI_RESET);
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys(ASIN);
      
       //Clicking search button
       driver.findElement(By.id("nav-search-submit-button")).click();
      
       //Try/catch for ASIN not found in the results
       try {
    	   driver.findElement(By.xpath("//*[@data-csa-c-item-id='amzn1.asin.1." + ASIN + "']")).click();
       }catch (Exception e) {
    	   System.out.println(i +") ASIN : " + ASIN + " is skipped");
    	   System.out.println(ANSI_RED + "Might be this is not a US app, Please check the PFM in the ALP" + ANSI_RESET);
    	   continue; 
       }

       String rawTitle = driver.getTitle(); 
       //Removing the - App on Amazon Appstore to take app name
       String AppName = rawTitle.replace(" - App on Amazon Appstore", "").trim();
       System.out.println(i +") ASIN : "+ ASIN + " & App Name : " + AppName);
       
       // After clicking the product, switch to the new window
       for (String handle : driver.getWindowHandles()) {
           driver.switchTo().window(handle);
       }
       Thread.sleep(100);
       
       //storing the final Result from the try/catch output
       String finalResult = "";
       try {
      driver.findElement(By.xpath("//*[@aria-labelledby='mas-buy-button-announce']")).click();
     String GetResultsOfBuyButtonClick = driver.findElement(By.xpath("//p[@class='a-size-base']")).getText();
      if("The app was successfully sent to your device.".equals(GetResultsOfBuyButtonClick)) {
    	  finalResult = "App entitled to your account successfully";
    	  }
    	  else{
    		driver.findElement(By.xpath("//*[contains(@data-csa-c-content-id,'incompatible-usk-check-cancel-desktop')]")).click();  
    		finalResult = "App is incompatible Please check the status in the ALP site";
    	  }
      } catch (Exception e) {
    	   String GetResults = driver.findElement(By.xpath("//p[contains(@class,'a-size-small masrw-lead-text')]")).getText();
    	   if("You already own this app.".equals(GetResults)) {
    		   finalResult = "App is incompatible Please check the status in the ALP site";
    	   }
    	   else {
    		   finalResult = "Unavailable to entitle Please check the status in the ALP site";
    	   }
      }
       //To print the output from above try/catch
       System.out.println(finalResult);
       
       //writing the O/P to csv file
	   csvWriter.append(ASIN + "," + AppName + "," + finalResult + "\n");
       }
		
		//csv file flush and close
		csvWriter.flush();
        csvWriter.close();
        
        //excel close
        wb.close();
        
        System.out.println(ANSI_Yellow+"--------------------------------"+ANSI_RESET);
        
        //Calculate final timing
        LocalDateTime endTime = LocalDateTime.now();
        Duration totalRunTime = Duration.between(startTime, endTime);
        long minutes = totalRunTime.toMinutes();
        long seconds = totalRunTime.toSecondsPart();
        
        //close the browser
        driver.close();
        System.out.println("Closing the browser");
        
        System.out.println(ANSI_GREEN +"--------Run has been completed--------"+ANSI_RESET);
        //To print the Total duration of run
		System.out.println(ANSI_Yellow+"Total duration : "+ANSI_RESET + minutes + " minute(s) and " + seconds + " second(s).");
    }
    	}