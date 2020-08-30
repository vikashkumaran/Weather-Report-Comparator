package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resource.WeatherComparatorConstants;

/**
 * @class NdtvWeatherPage
 * @class_description NdtvWeatherPage class is a page object class that contains
 *                    web elements and their respective events
 * @created_date 30-08-2020
 * @author VIKASH
 *
 */

public class NdtvWeatherPage {
	//Web Elements initialization
	WebDriver driver;
	public NdtvWeatherPage(WebDriver parentDriver) {
		this.driver = parentDriver;
		PageFactory.initElements(parentDriver, this);
	}

	@FindBy(id = WeatherComparatorConstants.SEARCH_BOX)
	public WebElement searchBox;

	@FindBy(id = WeatherComparatorConstants.TARGET_CITY)
	public WebElement targetCity;

	@FindBy(xpath = WeatherComparatorConstants.TARGET_CITY_SELECT_LIST)
	public WebElement targetCitySelectList;

	@FindBy(xpath = WeatherComparatorConstants.TARGET_CITY_MAP_TEXT)
	public WebElement targetCityMapText;

	@FindBy(xpath = WeatherComparatorConstants.TARGET_CITY_TEMP_C)
	public WebElement targetCityTempInC;

	@FindBy(xpath = WeatherComparatorConstants.TARGET_CITY_TEMP_F)
	public WebElement targetCityTempInF;

	@FindBy(xpath = WeatherComparatorConstants.TARGET_WEATHER_DIALOG)
	public WebElement targetWeatherDialog;
}
