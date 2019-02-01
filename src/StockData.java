import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class StockData {
	
	//URL Builder
	static String NASDAQ = "https://www.nasdaq.com/symbol/";
	
	public static String[] getBestBidAsk(String ticker, WebDriver driver) {
		if (driver.getCurrentUrl().equals(NASDAQ+ticker)) {
			String[] bestBidAsk = driver.findElement(By.xpath("//div[@id=\"left-column-div\"]/div[1]/div[1]/div/div[1]/div[2]")).getText().split("/");
			return bestBidAsk;
		}
		else {
			driver.get(NASDAQ+ticker);
			return getBestBidAsk(ticker, driver);
		}
	}
	public static float getBestBid(String ticker, WebDriver driver) {
		String[] spread = getBestBidAsk(ticker, driver);
		float bestBid = Float.parseFloat(spread[0].replace("$", "").trim());
		return bestBid;
	}
	public static float getBestAsk(String ticker, WebDriver driver) {
		String[] spread = getBestBidAsk(ticker, driver);
		float bestAsk = Float.parseFloat(spread[1].replace("$", "").trim());
		return bestAsk;
	}
}