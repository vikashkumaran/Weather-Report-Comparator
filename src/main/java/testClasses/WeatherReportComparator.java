package testClasses;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.NdtvMainPage;
import PageObjects.NdtvWeatherPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import resource.WeatherComparatorConstants;

/**
 * @class WeatherReportComparator
 * @class_description WeatherReportComparator class deals with testscript
 *                    statements related to NdtvWeatherReport data comparison
 *                    with openweathermap data
 * @created_date 30-08-2020
 * @author VIKASH
 *
 */
public class WeatherReportComparator {
	int webWeather = WeatherComparatorConstants.VALUE_ZERO;
	int apiWeather = WeatherComparatorConstants.VALUE_ZERO;

	/**
	 * @method getNdtvReport
	 * @method_description getNdtvReport method is to get the target city's weather
	 *                     report from ndtv website
	 * @return void
	 * @created_date 30-08-2020
	 * @author VIKASH
	 *
	 */
	public void getNdtvReport() throws InterruptedException {
		System.setProperty(WeatherComparatorConstants.PROPERTY_KEY, WeatherComparatorConstants.PROPERTY_VALUE);
		WebDriver driver = new ChromeDriver();
		driver.get(WeatherComparatorConstants.NDTV_MAIN_PAGE);
		driver.manage().timeouts().implicitlyWait(WeatherComparatorConstants.VALUE_THREE_THOUSAND,
				TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		NdtvMainPage ndtvMainPage = new NdtvMainPage(driver);
		ndtvMainPage.expansionButton.click();
		ndtvMainPage.weatherButton.click();
		WebDriverWait wait = new WebDriverWait(driver, WeatherComparatorConstants.VALUE_THIRTY);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.className(WeatherComparatorConstants.ZOOM_IN_BUTTON)));
		NdtvWeatherPage ndtvWeatherPage = new NdtvWeatherPage(driver);
		ndtvWeatherPage.searchBox.sendKeys(WeatherComparatorConstants.TARGET_CITY);
		ndtvWeatherPage.targetCitySelectList.click();
		assertTrue(ndtvWeatherPage.targetCityMapText.getText().equals(WeatherComparatorConstants.TARGET_CITY));
		assertTrue(ndtvWeatherPage.targetCityTempInC.getText().substring(WeatherComparatorConstants.VALUE_ZERO,
				WeatherComparatorConstants.VALUE_TWO) != null);
		assertTrue(ndtvWeatherPage.targetCityTempInF.getText().substring(WeatherComparatorConstants.VALUE_ZERO,
				WeatherComparatorConstants.VALUE_TWO) != null);
		ndtvWeatherPage.targetCityMapText.click();
		assertTrue(ndtvWeatherPage.targetWeatherDialog.isDisplayed() == true);
		webWeather = Integer.valueOf(ndtvWeatherPage.targetCityTempInC.getText()
				.substring(WeatherComparatorConstants.VALUE_ZERO, WeatherComparatorConstants.VALUE_TWO));
		driver.close();
	}

	/**
	 * @method getWeatherReportByAPI
	 * @method_description getWeatherReportByAPI method is to get the target city's
	 *                     weather report using openwethermap api
	 * @return void
	 * @created_date 30-08-2020
	 * @author VIKASH
	 *
	 */
	public void getWeatherReportByAPI() {
		Response response = RestAssured.get(WeatherComparatorConstants.TARGET_API);
		Object temp = response.jsonPath().getMap(WeatherComparatorConstants.TARGET_API_MAP)
				.get(WeatherComparatorConstants.TARGET_API_KEY);
		apiWeather = (int) (Float.parseFloat(temp.toString()) - WeatherComparatorConstants.KELVIN_VALUE);
	}

	/**
	 * @method compareReport
	 * @method_description compareReport method is used to compare the weather
	 *                     report received from ndtv website and openweathermap api
	 * @return void
	 * @created_date 30-08-2020
	 * @author VIKASH
	 *
	 */
	@Test
	public void compareReport() throws IOException, InterruptedException {
		getNdtvReport();
		getWeatherReportByAPI();
		int resultValue = webWeather - apiWeather;
		HSSFWorkbook wb = new HSSFWorkbook(
				new FileInputStream(new File(WeatherComparatorConstants.TEMP_CONFIG_FILE_PATH)));
		int configdata = (int) wb.getSheet(WeatherComparatorConstants.TARGET_SHEET)
				.getRow(WeatherComparatorConstants.VALUE_THREE).getCell(WeatherComparatorConstants.VALUE_ZERO)
				.getNumericCellValue();
		assertTrue((resultValue <= configdata && resultValue >= WeatherComparatorConstants.VALUE_ZERO)
				|| (resultValue >= -configdata && resultValue <= WeatherComparatorConstants.VALUE_ZERO));
	}
}
