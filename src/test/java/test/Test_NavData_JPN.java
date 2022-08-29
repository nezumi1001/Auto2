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
	private Func_JPN mf;
	private WebDriver driver;
	private int Preempt;

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		// [S]ChromeDriver Settings
		System.setProperty(iData_JPN.chromeDriver_data[0], iData_JPN.chromeDriver_data[1]);
		ChromeOptions chromOptions = new ChromeOptions();
		chromOptions.addArguments(iData_JPN.Chrome_userData);
		chromOptions.addArguments("--lang=ja-JP", "--incognito", "--ignore-certificate-errors");
//		chromOptions.addArguments("window-size=1920, 1080");
		chromOptions.addArguments("window-size=1920, 3000");

		chromOptions.addArguments("--headless");
		driver = new ChromeDriver(chromOptions);
		driver.get(iData_JPN.baseUrl);
		mf = new Func_JPN(driver);
		mf.start_exReport();
		mf.log_message(this.getClass().getName(), "Before Navigate To..." + iData_JPN.baseUrl + "[JPN]");
	}

	// Box info
	public void box_info() throws IOException {
		List<String> info_JPNs = new ArrayList<String>();
		// [A]Go to DEVICE > Settings
		driver.get(iData_JPN.FirmwareSettings_url);
		// [A]Fix Box & SN shows unknown
		mf.wait_element("xpath", iData_JPN.Version_path_01);
		// [A]Get info
		String Box_JPN = mf.wait_element("xpath", iData_JPN.Box_path).getText();
		String SN_JPN = mf.wait_element("xpath", iData_JPN.SN_path).getText();
		String Version_JPN = mf.wait_element("xpath", iData_JPN.Version_path_02).getText();
		info_JPNs.add(Box_JPN);
		info_JPNs.add(SN_JPN);
		info_JPNs.add(Version_JPN);
		// [D]Create info >> Excel
		mf.create_info();
		mf.log_message(this.getClass().getName(), "Info created for [JPN]!");
		// [D]Update info >> Excel
		mf.update_info(info_JPNs, 0);
		mf.log_message(this.getClass().getName(), "Info updated for [JPN]!");
	}

	// Actual data
	public List<String> actual_data(String top_menu) throws InterruptedException, IOException {
		List<String> actual_data = new ArrayList<String>();

		// [A]Page redirect
		for (int i = 0; i < iData_JPN.Menu_url.length; i++) {
			if (iData_JPN.Menu_url[i][0].equals(top_menu)) {
				driver.get(iData_JPN.Menu_url[i][1]);
			}
		}

		// [A]Expand page
		mf.wait_element("xpath", iData_JPN.DarkMenu_LeftPane_path);
		List<WebElement> Menu_darks = mf.find_elements("xpath", iData_JPN.DarkMenu_LeftPane_path);
		for (WebElement Menu_dark : Menu_darks)
			mf.js_click(Menu_dark);
		mf.wait_element("xpath", iData_JPN.SubMenu_nested);
		List<WebElement> Menu_alls = mf.find_elements("xpath", iData_JPN.LeftPane_path);
		actual_data.addAll(mf.expand_menu(Menu_alls, top_menu));
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
		mf.log_message(this.getClass().getName(), "Login to main page...");
		// [A]Preempt
		if (mf.wait_element_short("xpath", iData_JPN.preempt_path) != null) {
			mf.js_click(mf.wait_element("xpath", iData_JPN.preempt_path));
			mf.log_message(this.getClass().getName(), "Preempt the box...");
			Preempt = 1;
		}
	}

	@Test
	public void test_Step02_MenuTop_JPN() throws Exception {
		List<String> actualData;
		String[] topMenus = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
		// [A]Switch to "Non-Config" mode
		if (Preempt == 0) {
			mf.js_click(mf.wait_element("xpath", iData_JPN.Config_path));
			mf.log_message(this.getClass().getName(), "Switch to 'Non-Config' mode...");
		}

		// [D]Create data >> Excel
		mf.create_data();
		mf.log_message(this.getClass().getName(), "Data created for [JPN]!");

		// [A]Access top menu
		for (int i = 0; i < topMenus.length; i++) {
			// [A]Click (e.g. "HOME")
			actualData = actual_data(topMenus[i]);
			// [D]Update data >> Excel
			mf.update_data(actualData, i);
			mf.log_message(this.getClass().getName(), "Data updated for [JPN]!");
			mf.log_message(this.getClass().getName(), "Top menu " + "'" + topMenus[i] + "'" + " is done!");
		}
		// [A]Get Box info
		box_info();
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