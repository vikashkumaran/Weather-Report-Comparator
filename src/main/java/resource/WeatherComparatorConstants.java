package resource;

/**
 * @class WeatherComparatorConstants
 * @class_description WeatherComparatorConstants class consists of all the
 *                    constants related to WeatherComparator functionality
 * @created_date 30-08-2020
 * @author VIKASH
 *
 */
public class WeatherComparatorConstants {

	// system property constants
	public static final String PROPERTY_KEY = "webdriver.chrome.driver";
	public static final String PROPERTY_VALUE = "C:\\Users\\VIKASH\\selenium_project\\WeatherReportComparator\\drivers\\chromedriver.exe";
	public static final String TEMP_CONFIG_FILE_PATH = "C:\\\\Users\\\\VIKASH\\\\selenium_project\\\\WeatherReportComparator\\\\TempConfigFile\\\\temperature_configuration.xls";
	public static final String TARGET_SHEET = "testdata";

	// URL & API constants
	public static final String NDTV_MAIN_PAGE = "https://www.ndtv.com/";
	public static final String TARGET_API = "https://api.openweathermap.org/data/2.5/weather?q=Ahmedabad&appid=7fe67bf08c80ded756e598d6f8fedaea";

	// constants for Element locators
	public static final String EXPANSION_BUTTON = "h_sub_menu";
	public static final String WEATHER_BUTTON = "//a[@href='https://social.ndtv.com/static/Weather/report/?pfrom=home-topsubnavigation']";
	public static final String SEARCH_BOX = "searchBox";
	public static final String ZOOM_IN_BUTTON = "leaflet-control-zoom-in";
	public static final String TARGET_CITY = "Ahmedabad";
	public static final String TARGET_CITY_MAP_TEXT = "(//div[@class='cityText'])[12]";
	public static final String TARGET_CITY_SELECT_LIST = "//label[@for='Ahmedabad']";
	public static final String TARGET_CITY_TEMP_C = "(//span[@class=\"tempRedText\"])[12]";
	public static final String TARGET_CITY_TEMP_F = "(//span[@class=\"tempWhiteText\"])[12]";
	public static final String TARGET_WEATHER_DIALOG = "//div[@class='leaflet-popup-content']";

	// fixed constants for data manipulation
	public static final float KELVIN_VALUE = 273.15f;
	public static final int VALUE_ZERO = 0;
	public static final int VALUE_TWO = 2;
	public static final int VALUE_NEG_TWO = -2;
	public static final int VALUE_THREE_THOUSAND = 3000;
	public static final int VALUE_THIRTY = 30;
	public static final int VALUE_THREE = 3;

	// API method constants
	public static final String TARGET_API_MAP = "main";
	public static final String TARGET_API_KEY = "temp";
}
