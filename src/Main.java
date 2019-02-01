import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) {
		//Create Driver object
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Eclipse\\selenium-java\\geckodriver.exe");
				
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//URL Builder
		String nasdaq = "https://www.nasdaq.com/symbol/";
		String ticker = "atvi";
		
		System.out.println("Start");
		
		driver.get(nasdaq+ticker);
		//Key Stock Data
		List<List<WebElement>> dataPanels = new ArrayList<List<WebElement>>();
		dataPanels.add(driver.findElements(By.xpath("//div[@id='left-column-div']/div[1]/div[1]/div/div/div[2]")));
		dataPanels.add(driver.findElements(By.xpath("//div[@id='left-column-div']/div[1]/div[2]/div/div/div[2]")));
		
		
		String bestBidAsk = dataPanels.get(0).get(0).getText();
		String oneYearTarget = dataPanels.get(0).get(1).getText();
		String todayHighLow = dataPanels.get(0).get(2).getText();
		String shareVolume = dataPanels.get(0).get(3).getText();
		String fiftyDayAvg = dataPanels.get(0).get(4).getText();
		String previousClose = dataPanels.get(0).get(5).getText();
		String yearHighLow = dataPanels.get(0).get(6).getText();
		String marketCap = dataPanels.get(0).get(7).getText();
		
		String peRatio = dataPanels.get(1).get(0).getText();
		String forwardPE = dataPanels.get(1).get(1).getText();
		String eps = dataPanels.get(1).get(2).getText();
		String dividend = dataPanels.get(1).get(3).getText();
		String exDividendDate = dataPanels.get(1).get(4).getText();
		String currentYield = dataPanels.get(1).get(5).getText();
		String beta = dataPanels.get(1).get(6).getText();
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("bestBidAsk: "+bestBidAsk);
		System.out.println("oneYearTarget: "+oneYearTarget);
		System.out.println("todayHighLow: "+todayHighLow);
		System.out.println("shareVolume: "+shareVolume);
		System.out.println("fiftyDayAvg: "+fiftyDayAvg);
		System.out.println("previousClose: "+previousClose);
		System.out.println("yearHighLow: "+yearHighLow);
		System.out.println("marketCap: "+marketCap);
		
		System.out.println("peRatio: "+peRatio);
		System.out.println("forwardPE: "+forwardPE);
		System.out.println("eps: "+eps);
		System.out.println("dividend: "+dividend);
		System.out.println("exDividendDate: "+exDividendDate);
		System.out.println("currentYield: "+currentYield);
		System.out.println("beta: "+beta);
		
		System.out.println(Arrays.toString(StockData.getBestBidAsk("atvi", driver)));
		System.out.println(StockData.getBestBid("atvi", driver));
		System.out.println(StockData.getBestAsk("atvi", driver));
	}

}
