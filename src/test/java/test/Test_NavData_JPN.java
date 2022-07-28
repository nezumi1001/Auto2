package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import info.iData_JPN;
import main.Func_JPN;

public class Test_NavData_JPN {
	private int Preempt;
	private Func_JPN mf;
	private WebDriver driver;
	private List<String> actualData;
	private List<WebElement> expandMenus;

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		// [A]ChromeDriver Settings
		System.setProperty(iData_JPN.chromeDriver_data[0], iData_JPN.chromeDriver_data[1]);
		ChromeOptions chromOptions = new ChromeOptions();
		chromOptions.addArguments("--user-data-dir=C:\\Users\\khuang\\AppData\\Local\\Google\\Chrome\\User Data3");
		chromOptions.addArguments("--lang=ja-JP", "--incognito", "--ignore-certificate-errors");
//		chromOptions.addArguments("--start-maximized");
		chromOptions.addArguments("window-size=1920, 1080");
		chromOptions.addArguments("--headless");
		driver = new ChromeDriver(chromOptions);
		driver.get(iData_JPN.baseUrl);
		mf = new Func_JPN(driver);
		mf.start_exReport();
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Before Navigate To..." + iData_JPN.baseUrl + "[JPN]");
	}

	// Create info & data
	public void info_data() throws IOException {
		// [A]Get info
		mf.wait_element("xpath", iData_JPN.HomeMenu_System_title_path);
		String Device_Name_JPN = mf.wait_element("xpath", iData_JPN.Box_Name_path).getText();
		String Serial_Number_JPN = mf.wait_element("xpath", iData_JPN.Serial_Number_path).getText();
		String Firmware_Version_JPN = mf.wait_element("xpath", iData_JPN.Firmware_Version_path).getText();
		List<String> info_JPNs = new ArrayList<String>();
		info_JPNs.add(Device_Name_JPN);
		info_JPNs.add(Serial_Number_JPN);
		info_JPNs.add(Firmware_Version_JPN);
		// [M]Create info >> Excel
		mf.create_info();
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Got info for [JPN]!");
		// [M]Update info >> Excel
		mf.update_info(info_JPNs, 0);
	}

	// Actual data
	public List<String> actual_data(String top_menu) throws InterruptedException, IOException {
		String top_parent = null;
		List<String> actual_data = new ArrayList<String>();

		// HOME
		String[] HomeMenu_urls = { iData_JPN.HomeMenu_Dashboard_url, iData_JPN.HomeMenu_Legal_Information_url,
				iData_JPN.HomeMenu_API_url };
		if (top_menu.equals("HOME")) {
			for (String HomeMenu_url : HomeMenu_urls) {
				driver.get(HomeMenu_url);
				if (HomeMenu_url.equals(iData_JPN.HomeMenu_Dashboard_url))
					top_parent = "Dashboard";
				if (HomeMenu_url.equals(iData_JPN.HomeMenu_Legal_Information_url))
					top_parent = "Legal Information";
				if (HomeMenu_url.equals(iData_JPN.HomeMenu_API_url))
					top_parent = "API";

				// Special page (not include submenu)
				if (top_parent.equals("Dashboard")) {
					mf.wait_element("xpath", iData_JPN.SubMenu_nested);
					expandMenus = mf.find_elements("xpath", iData_JPN.SubMenu_nested);
				} else {
					expandMenus = null;
				}
				actual_data.addAll(mf.expand_menu(expandMenus, top_menu, top_parent));
			}
		}

		// MONITOR
		String[] MonitorMenu_urls = { iData_JPN.MonitorMenu_RealTimeCharts_url, iData_JPN.MonitorMenu_AppFlow_url,
				iData_JPN.MonitorMenu_SDWAN_url, iData_JPN.MonitorMenu_Logs_url,
				iData_JPN.MonitorMenu_ToolsMonitors_url };
		if (top_menu.equals("MONITOR")) {
			for (String MonitorMenu_url : MonitorMenu_urls) {
				if (MonitorMenu_url.equals(iData_JPN.MonitorMenu_SDWAN_url)) {
					mf.js_click(mf.wait_element("xpath", iData_JPN.MonitorMenu_SDWAN_path));
				} else {
					driver.get(MonitorMenu_url);
				}
				if (MonitorMenu_url.equals(iData_JPN.MonitorMenu_RealTimeCharts_url))
					top_parent = "Real-Time Charts";
				if (MonitorMenu_url.equals(iData_JPN.MonitorMenu_AppFlow_url))
					top_parent = "AppFlow";
				if (MonitorMenu_url.equals(iData_JPN.MonitorMenu_SDWAN_url))
					top_parent = "SDWAN";
				if (MonitorMenu_url.equals(iData_JPN.MonitorMenu_Logs_url))
					top_parent = "Logs";
				if (MonitorMenu_url.equals(iData_JPN.MonitorMenu_ToolsMonitors_url))
					top_parent = "Tools & Monitors";

				// Special page (unable to redirect)
				if (MonitorMenu_url.equals(iData_JPN.MonitorMenu_SDWAN_url)) {
					mf.wait_element("xpath", iData_JPN.Unselected_Nested_path);
					expandMenus = mf.find_elements("xpath", iData_JPN.Unselected_Nested_path);
				} else {
					mf.wait_element("xpath", iData_JPN.SubMenu_nested);
					expandMenus = mf.find_elements("xpath", iData_JPN.SubMenu_nested);
				}
				actual_data.addAll(mf.expand_menu(expandMenus, top_menu, top_parent));
			}
		}

		// DEVICE
		String[] DeviceMenu_urls = { iData_JPN.DeviceMenu_Settings_url, iData_JPN.DeviceMenu_HighAvailability_url,
				iData_JPN.DeviceMenu_Users_url, iData_JPN.DeviceMenu_AppFlow_url, iData_JPN.DeviceMenu_Log_url,
				iData_JPN.DeviceMenu_Diagnostics_url, iData_JPN.DeviceMenu_SwitchNetwork_url,
				iData_JPN.DeviceMenu_AccessPoints_url, iData_JPN.DeviceMenu_WWAN_url };
		if (top_menu.equals("DEVICE")) {
			for (String DeviceMenu_url : DeviceMenu_urls) {
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_AccessPoints_url)) {
					mf.js_click(mf.wait_element("xpath", iData_JPN.DeviceMenu_AccessPoints_path));
				} else {
					driver.get(DeviceMenu_url);
				}
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_Settings_url))
					top_parent = "Settings (TOP)";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_HighAvailability_url))
					top_parent = "High Availability";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_Users_url))
					top_parent = "Users";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_AppFlow_url))
					top_parent = "AppFlow";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_Log_url))
					top_parent = "Log";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_Diagnostics_url))
					top_parent = "Diagnostics";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_SwitchNetwork_url))
					top_parent = "Switch Network";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_AccessPoints_url))
					top_parent = "Access Points";
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_WWAN_url))
					top_parent = "WWAN";

				// Special page (unable to redirect)
				if (DeviceMenu_url.equals(iData_JPN.DeviceMenu_AccessPoints_url)) {
					mf.wait_element("xpath", iData_JPN.Unselected_Nested_path);
//					mf.wait_element("xpath", iData_JPN.DeviceMenu_AccessPoints_IDS_path);
					expandMenus = mf.find_elements("xpath", iData_JPN.Unselected_Nested_path);
				} else {
					// Special page (not include submenu)
					if (top_parent.equals("WWAN")) {
						expandMenus = null;
					} else {
						mf.wait_element("xpath", iData_JPN.SubMenu_nested);
						expandMenus = mf.find_elements("xpath", iData_JPN.SubMenu_nested);
					}
				}
				actual_data.addAll(mf.expand_menu(expandMenus, top_menu, top_parent));
			}
		}

		return actual_data;
	}

	@Test
	public void test_Step01_Login_JPN() throws Exception {
		// [A]Enter "ユーザ名"
		mf.wait_element("xpath", iData_JPN.userName_path).sendKeys(iData_JPN.login_name);
		// [A]Enter "パスワード"
		mf.wait_element("xpath", iData_JPN.password_path).sendKeys(iData_JPN.login_pass);
		// [A]Click "ログイン"
		mf.js_click(mf.wait_element("xpath", iData_JPN.login_path));
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Login to main page...");
		// [A]Preempt
		if (mf.wait_element_short("xpath", iData_JPN.preempt_path) != null) {
			mf.js_click(mf.wait_element("xpath", iData_JPN.preempt_path));
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Preempt the box...");
			Preempt = 1;
		}
	}

	@Test
	public void test_Step02_MenuTop_JPN() throws Exception {
//		String[] topMenus = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
		String[] topMenus = { "HOME", "MONITOR", "DEVICE" };

		// [A]Switch to "Non-Config" mode
		if (Preempt == 0) {
			mf.js_click(mf.wait_element("xpath", iData_JPN.Config_path));
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Switch to 'Non-Config' mode...");
		}

		// [M]Create data >> Excel
		mf.create_data();
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data created!");

		// [A]Run all top menu
		for (int i = 0; i < topMenus.length; i++) {
			// [A]Click e.g. ("HOME" > "Main menu" > "Sub menu")
			actualData = actual_data(topMenus[i]);
			// [M]Update data >> Excel
			mf.update_data(actualData, i);
			// [L]Log
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
			// [L]Log
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
					"Top menu " + "'" + topMenus[i] + "'" + " is done!");
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		// Take screenshot [Pass] or [Fail]
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			mf.take_screenshot(testResult.getName(), "[PASS]");
			mf.log_message(testResult.getName(), "[Pass]Take screenshot...");
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = mf.take_screenshot(testResult.getName(), "[FAIL]");
			mf.extent_screenshot(path);
			mf.log_message(testResult.getName(), "[Fail]Take screenshot...");
		}
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		mf.close_exReport();
	}
}