package info;

import java.io.File;

public class iData_ENG {
	// Box info
//	public static String baseUrl = "https://10.103.50.189"; // TZ 370W
//	public static String baseUrl = "https://10.8.162.201"; // NSa 2700
	public static String baseUrl = "https://10.8.162.230"; // TZ 570P
//	public static String baseUrl = "https://10.8.178.176"; // NSa 4700 KellyDu

	// ChromeDriver Settings
	public static File my_path = new File(System.getProperty("user.dir"));
	public static String[] chromeDriver_data = { "webdriver.chrome.driver",
			my_path.getParent() + "\\Driver\\chromedriver.exe" };
	public static String Chrome_userData = "--user-data-dir=C:\\Users\\khuang\\AppData\\Local\\Google\\Chrome\\User Data3";

	// Preempt
	public static String preempt_path = "//button[contains(text(),'Non-Config')]";
	// Username field
	public static String userName_path = "//input[contains(@placeholder,'Enter your username')]";
	public static String login_name = "admin";
	// Password field
	public static String password_path = "//input[contains(@placeholder,'Enter your password')]";

//	public static String login_pass = "password";
	public static String login_pass = "sonicwall";

	// LOGIN button
	public static String login_path = "//div[@class='sw-login sw-typo-default sw-flexbox']//div[contains(text(),'LOG')]";

	// Config mode
	public static String Config_path = "//div[@class='sw-toggle sw-toggle--left sw-toggle--regular sw-toggle--light']";

	// Firmware and Settings URL
	public static String FirmwareSettings_url = baseUrl + "/sonicui/7/m/mgmt/system/settings/firmware";
	// Box name
	public static String Box_path = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
	public static String SN_path = "//span[@class='fw-app-header__breadcrumb-device-name']";
	public static String Version_path_01 = "//div[@class='sw-table-row__cell__wrapper sw-flexbox__flex sw-flexbox sw-flexbox--center-items']/div/div/div/span[1]";
	public static String Version_path_02 = "//div[@class='sw-table-row__cell__wrapper sw-flexbox__flex sw-flexbox sw-flexbox--center-items']/div/div/div[2]";

	// Top menu URL
	public static String[][] Menu_url = { { "HOME", baseUrl + "/sonicui/7/m/dashboard/overview/status/device" },
			{ "MONITOR", baseUrl + "/sonicui/7/m/mgmt/system/real-time-monitor" },
			{ "DEVICE", baseUrl + "/sonicui/7/m/mgmt/system/license-enhanced" },
			{ "NETWORK", baseUrl + "/sonicui/7/m/mgmt/network/interfaces" },
			{ "OBJECT", baseUrl + "/sonicui/7/m/mgmt/objects/zones" },
			{ "POLICY", baseUrl + "/sonicui/7/m/mgmt/policies/ngpe-access-rules" } };

	// Left
	public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
	// Dark
	public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
	// Nested
	public static String SubMenu_nested = "//ul[@class='sw-nav-group__items sw-nav-group__items--nested-level-0']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

}
