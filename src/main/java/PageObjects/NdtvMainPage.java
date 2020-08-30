package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resource.WeatherComparatorConstants;

/**
 * @class NdtvMainPage
 * @class_description NdtvMainPage class is a page object class that contains
 *                    web elements and their respective events
 * @created_date 30-08-2020
 * @author VIKASH
 *
 */
public class NdtvMainPage {
	// Web Elements initialization
	WebDriver driver;

	public NdtvMainPage(WebDriver parentDriver) {
		this.driver = parentDriver;
		PageFactory.initElements(parentDriver, this);
	}

	@FindBy(id = WeatherComparatorConstants.EXPANSION_BUTTON)
	public WebElement expansionButton;

	@FindBy(xpath = WeatherComparatorConstants.WEATHER_BUTTON)
	public WebElement weatherButton;

}
