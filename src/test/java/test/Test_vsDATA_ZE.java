package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_vsDATA_ZE {
	private File my_path = new File(System.getProperty("user.dir"));
	private Logger log = LogManager.getLogger(Test_NavData_ENG.class.getName());
	private String main_menu;
	private int match = 0;
	private ExtentReports exReport;
	private ExtentTest exTest;

	// Import data only (info ZHT)
	public List<String> info_ZHT() throws IOException {
		List<String> data_infos_ZHT = new ArrayList<String>();
		FileInputStream fs_ZHT = new FileInputStream(my_path + "\\Data\\info\\info_ZHT.xls");
		HSSFWorkbook workbook_ZHT = new HSSFWorkbook(fs_ZHT);
		HSSFSheet sheet = workbook_ZHT.getSheet("ZHT");
		// Get info ZHT
		for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
			HSSFCell data_info = sheet.getRow(data_row).getCell(0);
			if (data_info == null) {
				continue;
			}
			String dataInfo = data_info.getStringCellValue();
			data_infos_ZHT.add(dataInfo);
		}
		workbook_ZHT.close();
		return data_infos_ZHT;
	}

	// Import data only (info ENG)
	public List<String> info_ENG() throws IOException {
		List<String> data_infos_ENG = new ArrayList<String>();
		FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\info\\info_ENG.xls");
		HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
		HSSFSheet sheet = workbook_ENG.getSheet("ENG");
		// Get info ENG
		for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
			HSSFCell data_info = sheet.getRow(data_row).getCell(0);
			if (data_info == null) {
				continue;
			}
			String dataInfo = data_info.getStringCellValue();
			data_infos_ENG.add(dataInfo);
		}
		workbook_ENG.close();
		return data_infos_ENG;
	}

	// Box_ZHT
	public String[][] Box_ZHT() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		List<String> menu_HOME = new ArrayList<String>();
		List<String> menu_MONITOR = new ArrayList<String>();
		List<String> menu_DEVICE = new ArrayList<String>();
		List<String> menu_NETWORK = new ArrayList<String>();
		List<String> menu_OBJECT = new ArrayList<String>();
		List<String> menu_POLICY = new ArrayList<String>();
		// Import data ZHT
		FileInputStream fs_ZHT = new FileInputStream(my_path + "\\Data\\compare\\Box_ZHT.xls");
		HSSFWorkbook workbook_ZHT = new HSSFWorkbook(fs_ZHT);
		HSSFSheet sheet = workbook_ZHT.getSheet("ZHT");
		// Get data ZHT
		for (int data_column = 0; data_column < sheet.getRow(data_column).getLastCellNum(); data_column++) {
			for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
				HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
				if (data_value == null) {
					continue;
				}
				String dataValue = data_value.getStringCellValue();

				// Get data from each column
				if (data_column == 0) {
					menu_HOME.add(dataValue);
				} else if (data_column == 1) {
					menu_MONITOR.add(dataValue);
				} else if (data_column == 2) {
					menu_DEVICE.add(dataValue);
				} else if (data_column == 3) {
					menu_NETWORK.add(dataValue);
				} else if (data_column == 4) {
					menu_OBJECT.add(dataValue);
				} else if (data_column == 5) {
					menu_POLICY.add(dataValue);
				}
			}
		}

		// Merge data ZHT
		String[] menu_HOMEs = menu_HOME.toArray(new String[menu_HOME.size()]);
		String[] menu_MONITORs = menu_MONITOR.toArray(new String[menu_MONITOR.size()]);
		String[] menu_DEVICEs = menu_DEVICE.toArray(new String[menu_DEVICE.size()]);
		String[] menu_NETWORKs = menu_NETWORK.toArray(new String[menu_NETWORK.size()]);
		String[] menu_OBJECTs = menu_OBJECT.toArray(new String[menu_OBJECT.size()]);
		String[] menu_POLICYs = menu_POLICY.toArray(new String[menu_POLICY.size()]);
		String[][] menu_ZHT = { menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs };
		// [L]Log
		log_message(testName, "Got data!");
		workbook_ZHT.close();
		return menu_ZHT;
	}

	// box_ENG
	public String[][] box_ENG() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		List<String> menu_HOME = new ArrayList<String>();
		List<String> menu_MONITOR = new ArrayList<String>();
		List<String> menu_DEVICE = new ArrayList<String>();
		List<String> menu_NETWORK = new ArrayList<String>();
		List<String> menu_OBJECT = new ArrayList<String>();
		List<String> menu_POLICY = new ArrayList<String>();
		// Import data ENG
		FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\compare\\Box_ENG.xls");
		HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
		HSSFSheet sheet = workbook_ENG.getSheet("ENG");
		// Get data ENG
		for (int data_column = 0; data_column < sheet.getRow(data_column).getLastCellNum(); data_column++) {
			for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
				HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
				if (data_value == null) {
					continue;
				}
				String dataValue = data_value.getStringCellValue();

				// Get data from each column
				if (data_column == 0) {
					menu_HOME.add(dataValue);
				} else if (data_column == 1) {
					menu_MONITOR.add(dataValue);
				} else if (data_column == 2) {
					menu_DEVICE.add(dataValue);
				} else if (data_column == 3) {
					menu_NETWORK.add(dataValue);
				} else if (data_column == 4) {
					menu_OBJECT.add(dataValue);
				} else if (data_column == 5) {
					menu_POLICY.add(dataValue);
				}
			}
		}

		// Merge data ENG
		String[] menu_HOMEs = menu_HOME.toArray(new String[menu_HOME.size()]);
		String[] menu_MONITORs = menu_MONITOR.toArray(new String[menu_MONITOR.size()]);
		String[] menu_DEVICEs = menu_DEVICE.toArray(new String[menu_DEVICE.size()]);
		String[] menu_NETWORKs = menu_NETWORK.toArray(new String[menu_NETWORK.size()]);
		String[] menu_OBJECTs = menu_OBJECT.toArray(new String[menu_OBJECT.size()]);
		String[] menu_POLICYs = menu_POLICY.toArray(new String[menu_POLICY.size()]);
		String[][] menu_ENG = { menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs };
		// [L]Log
		log_message(testName, "Got data!");
		workbook_ENG.close();
		return menu_ENG;
	}

	// Get missing page
	public int missing_page(int column_no, List<String> MenusZHTs, List<String> MenusENGs) {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// Column name
		String[] column_name = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
		// New menu ZHT
		List<String> HOME_MenusZHTs = new ArrayList<String>();
		List<String> MONITOR_MenusZHTs = new ArrayList<String>();
		List<String> DEVICE_MenusZHTs = new ArrayList<String>();
		List<String> NETWORK_MenusZHTs = new ArrayList<String>();
		List<String> OBJECT_MenusZHTs = new ArrayList<String>();
		List<String> POLICY_MenusZHTs = new ArrayList<String>();

		// HOME ZHT
		String[] HOME_Menus_ZHT = { "Dashboard", "Legal Information", "API" };
		// MONITOR ZHT
		String[] MONITOR_Menus_ZHT = { "Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors" };
		// DEVICE ZHT
		String[] DEVICE_Menus_ZHT = { "Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
				"Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN" };
		// NETWORK ZHT
		String[] NETWORK_Menus_ZHT = { "System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "IPSec VPN",
				"SSL VPN" };
		// OBJECT ZHT
		String[] OBJECT_Menus_ZHT = { "Match Objects (TOP)", "Profile Objects", "Action Objects", "Signatures" };
		// POLICY ZHT
		String[] POLICY_Menus_ZHT = { "Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
				"Capture ATP", "Endpoint Security" };
		// ------------------------------------------------------------------------------------------------------------------------------
		// New menu ENG
		List<String> HOME_MenusENGs = new ArrayList<String>();
		List<String> MONITOR_MenusENGs = new ArrayList<String>();
		List<String> DEVICE_MenusENGs = new ArrayList<String>();
		List<String> NETWORK_MenusENGs = new ArrayList<String>();
		List<String> OBJECT_MenusENGs = new ArrayList<String>();
		List<String> POLICY_MenusENGs = new ArrayList<String>();
		// HOME ENG
		String[] HOME_Menus_ENG = { "Dashboard", "Legal Information", "API" };
		// MONITOR ENG
		String[] MONITOR_Menus_ENG = { "Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors" };
		// DEVICE ENG
		String[] DEVICE_Menus_ENG = { "Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
				"Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN" };
		// NETWORK ENG
		String[] NETWORK_Menus_ENG = { "System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "IPSec VPN",
				"SSL VPN" };
		// OBJECT ENG
		String[] OBJECT_Menus_ENG = { "Match Objects (TOP)", "Profile Objects", "Action Objects", "Signatures" };
		// POLICY ENG
		String[] POLICY_Menus_ENG = { "Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
				"Capture ATP", "Endpoint Security" };

		// --- Make new menu ---
		main_menu = column_name[column_no];
		// Mark ">" ZHT
		for (int i = 0; i < MenusZHTs.size(); i++) {
			// HOME ZHT
			if (main_menu.equals("HOME")) {
				String MenusZHT_temp = MenusZHTs.get(i);
				int iTemp = i;

//				while (!MenusZHT_temp.equals("Dashboard") && !MenusZHT_temp.equals("Legal Information")
//						&& !MenusZHT_temp.equals("API")) {
//					iTemp = iTemp - 1;
//					MenusZHT_temp = MenusZHTs.get(iTemp);
//				}

				int iMenu = 0;
				while (iMenu == 0) {
					for (int j = 0; j < HOME_Menus_ZHT.length; j++) {
						if (MenusZHT_temp.equals(HOME_Menus_ZHT[j]))
							iMenu = 1;
					}
					if (iMenu == 0)
						MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
				}

				for (int k = 0; k < HOME_Menus_ZHT.length; k++) {
					if (MenusZHT_temp.equals(HOME_Menus_ZHT[k])) {
						if (iTemp == i) {
							HOME_MenusZHTs.add(HOME_Menus_ZHT[k]);
						} else {
							HOME_MenusZHTs.add(HOME_Menus_ZHT[k] + " > " + MenusZHTs.get(i));
						}
					}
				}
			}

			// MONITOR ZHT
			if (main_menu.equals("MONITOR")) {
				String MenusZHT_temp = MenusZHTs.get(i);
				int iTemp = i;
//				while (!MenusZHT_temp.equals("Real-Time Charts") && !MenusZHT_temp.equals("AppFlow")
//						&& !MenusZHT_temp.equals("SDWAN") && !MenusZHT_temp.equals("Logs")
//						&& !MenusZHT_temp.equals("Tools & Monitors")) {
//					iTemp = iTemp - 1;
//					MenusZHT_temp = MenusZHTs.get(iTemp);
//				}

				int iMenu = 0;
				while (iMenu == 0) {
					for (int j = 0; j < MONITOR_Menus_ZHT.length; j++) {
						if (MenusZHT_temp.equals(MONITOR_Menus_ZHT[j]))
							iMenu = 1;
					}
					if (iMenu == 0)
						MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
				}

				for (int k = 0; k < MONITOR_Menus_ZHT.length; k++) {
					if (MenusZHT_temp.equals(MONITOR_Menus_ZHT[k])) {
						if (iTemp == i) {
							MONITOR_MenusZHTs.add(MONITOR_Menus_ZHT[k]);
						} else {
							MONITOR_MenusZHTs.add(MONITOR_Menus_ZHT[k] + " > " + MenusZHTs.get(i));
						}
					}
				}
			}

			// DEVICE ZHT
			if (main_menu.equals("DEVICE")) {
				String MenusZHT_temp = MenusZHTs.get(i);
				int iTemp = i;
//				while (!MenusZHT_temp.equals("Settings (TOP)") && !MenusZHT_temp.equals("Internal Wireless")
//						&& !MenusZHT_temp.equals("High Availability") && !MenusZHT_temp.equals("Users")
//						&& !MenusZHT_temp.equals("AppFlow") && !MenusZHT_temp.equals("Network Access Control")
//						&& !MenusZHT_temp.equals("Log") && !MenusZHT_temp.equals("Diagnostics")
//						&& !MenusZHT_temp.equals("Switch Network") && !MenusZHT_temp.equals("Access Points")
//						&& !MenusZHT_temp.equals("WWAN")) {
//					iTemp = iTemp - 1;
//					MenusZHT_temp = MenusZHTs.get(iTemp);
//				}

				int iMenu = 0;
				while (iMenu == 0) {
					for (int j = 0; j < DEVICE_Menus_ZHT.length; j++) {
						if (MenusZHT_temp.equals(DEVICE_Menus_ZHT[j]))
							iMenu = 1;
					}
					if (iMenu == 0)
						MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
				}

				for (int k = 0; k < DEVICE_Menus_ZHT.length; k++) {
					if (MenusZHT_temp.equals(DEVICE_Menus_ZHT[k])) {
						if (iTemp == i) {
							DEVICE_MenusZHTs.add(DEVICE_Menus_ZHT[k]);
						} else {
							DEVICE_MenusZHTs.add(DEVICE_Menus_ZHT[k] + " > " + MenusZHTs.get(i));
						}
					}
				}
			}

			// NETWORK ZHT
			if (main_menu.equals("NETWORK")) {
				String MenusZHT_temp = MenusZHTs.get(i);
				int iTemp = i;
//				while (!MenusZHT_temp.equals("System") && !MenusZHT_temp.equals("Firewall")
//						&& !MenusZHT_temp.equals("VoIP") && !MenusZHT_temp.equals("DNS")
//						&& !MenusZHT_temp.equals("Switching") && !MenusZHT_temp.equals("SDWAN")
//						&& !MenusZHT_temp.equals("IPSec VPN") && !MenusZHT_temp.equals("SSL VPN")) {
//					iTemp = iTemp - 1;
//					MenusZHT_temp = MenusZHTs.get(iTemp);
//				}

				int iMenu = 0;
				while (iMenu == 0) {
					for (int j = 0; j < NETWORK_Menus_ZHT.length; j++) {
						if (MenusZHT_temp.equals(NETWORK_Menus_ZHT[j]))
							iMenu = 1;
					}
					if (iMenu == 0)
						MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
				}

				for (int k = 0; k < NETWORK_Menus_ZHT.length; k++) {
					if (MenusZHT_temp.equals(NETWORK_Menus_ZHT[k])) {
						if (iTemp == i) {
							NETWORK_MenusZHTs.add(NETWORK_Menus_ZHT[k]);
						} else {
							NETWORK_MenusZHTs.add(NETWORK_Menus_ZHT[k] + " > " + MenusZHTs.get(i));
						}
					}
				}
			}

			// OBJECT ZHT
			if (main_menu.equals("OBJECT")) {
				String MenusZHT_temp = MenusZHTs.get(i);
				int iTemp = i;
//				while (!MenusZHT_temp.equals("Match Objects") && !MenusZHT_temp.equals("Profile Objects")
//						&& !MenusZHT_temp.equals("Action Objects") && !MenusZHT_temp.equals("Signatures")) {
//					iTemp = iTemp - 1;
//					MenusZHT_temp = MenusZHTs.get(iTemp);
//				}

				int iMenu = 0;
				while (iMenu == 0) {
					for (int j = 0; j < OBJECT_Menus_ZHT.length; j++) {
						if (MenusZHT_temp.equals(OBJECT_Menus_ZHT[j]))
							iMenu = 1;
					}
					if (iMenu == 0)
						MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
				}

				for (int k = 0; k < OBJECT_Menus_ZHT.length; k++) {
					if (MenusZHT_temp.equals(OBJECT_Menus_ZHT[k])) {
						if (iTemp == i) {
							OBJECT_MenusZHTs.add(OBJECT_Menus_ZHT[k]);
						} else {
							OBJECT_MenusZHTs.add(OBJECT_Menus_ZHT[k] + " > " + MenusZHTs.get(i));
						}
					}
				}
			}

			// POLICY ZHT
			if (main_menu.equals("POLICY")) {
				String MenusZHT_temp = MenusZHTs.get(i);
				int iTemp = i;
//				while (!MenusZHT_temp.equals("Rules and Policies") && !MenusZHT_temp.equals("DPI-SSL")
//						&& !MenusZHT_temp.equals("DPI-SSH") && !MenusZHT_temp.equals("Security Services")
//						&& !MenusZHT_temp.equals("Anti-Spam") && !MenusZHT_temp.equals("Capture ATP")
//						&& !MenusZHT_temp.equals("Endpoint Security")) {
//					iTemp = iTemp - 1;
//					MenusZHT_temp = MenusZHTs.get(iTemp);
//				}

				int iMenu = 0;
				while (iMenu == 0) {
					for (int j = 0; j < POLICY_Menus_ZHT.length; j++) {
						if (MenusZHT_temp.equals(POLICY_Menus_ZHT[j]))
							iMenu = 1;
					}
					if (iMenu == 0)
						MenusZHT_temp = MenusZHTs.get(iTemp = iTemp - 1);
				}

				for (int k = 0; k < POLICY_Menus_ZHT.length; k++) {
					if (MenusZHT_temp.equals(POLICY_Menus_ZHT[k])) {
						if (iTemp == i) {
							POLICY_MenusZHTs.add(POLICY_Menus_ZHT[k]);
						} else {
							POLICY_MenusZHTs.add(POLICY_Menus_ZHT[k] + " > " + MenusZHTs.get(i));
						}
					}
				}
			}

		}

		// Mark ">" ENG
		for (int i = 0; i < MenusENGs.size(); i++) {
			// HOME ENG
			if (main_menu.equals("HOME")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Dashboard") && !MenusENG_temp.equals("Legal Information")
						&& !MenusENG_temp.equals("API")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < HOME_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(HOME_Menus_ENG[k])) {
						if (iTemp == i) {
							HOME_MenusENGs.add(HOME_Menus_ENG[k]);
						} else {
							HOME_MenusENGs.add(HOME_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// MONITOR ENG
			if (main_menu.equals("MONITOR")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Real-Time Charts") && !MenusENG_temp.equals("AppFlow")
						&& !MenusENG_temp.equals("SDWAN") && !MenusENG_temp.equals("Logs")
						&& !MenusENG_temp.equals("Tools & Monitors")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < MONITOR_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(MONITOR_Menus_ENG[k])) {
						if (iTemp == i) {
							MONITOR_MenusENGs.add(MONITOR_Menus_ENG[k]);
						} else {
							MONITOR_MenusENGs.add(MONITOR_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// DEVICE ENG
			if (main_menu.equals("DEVICE")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Settings (TOP)") && !MenusENG_temp.equals("Internal Wireless")
						&& !MenusENG_temp.equals("High Availability") && !MenusENG_temp.equals("Users")
						&& !MenusENG_temp.equals("AppFlow") && !MenusENG_temp.equals("Network Access Control")
						&& !MenusENG_temp.equals("Log") && !MenusENG_temp.equals("Diagnostics")
						&& !MenusENG_temp.equals("Switch Network") && !MenusENG_temp.equals("Access Points")
						&& !MenusENG_temp.equals("WWAN")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < DEVICE_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(DEVICE_Menus_ENG[k])) {
						if (iTemp == i) {
							DEVICE_MenusENGs.add(DEVICE_Menus_ENG[k]);
						} else {
							DEVICE_MenusENGs.add(DEVICE_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// NETWORK ENG
			if (main_menu.equals("NETWORK")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("System") && !MenusENG_temp.equals("Firewall")
						&& !MenusENG_temp.equals("VoIP") && !MenusENG_temp.equals("DNS")
						&& !MenusENG_temp.equals("Switching") && !MenusENG_temp.equals("SDWAN")
						&& !MenusENG_temp.equals("IPSec VPN") && !MenusENG_temp.equals("SSL VPN")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < NETWORK_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(NETWORK_Menus_ENG[k])) {
						if (iTemp == i) {
							NETWORK_MenusENGs.add(NETWORK_Menus_ENG[k]);
						} else {
							NETWORK_MenusENGs.add(NETWORK_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// OBJECT ENG
			if (main_menu.equals("OBJECT")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Match Objects (TOP)") && !MenusENG_temp.equals("Profile Objects")
						&& !MenusENG_temp.equals("Action Objects") && !MenusENG_temp.equals("Signatures")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < OBJECT_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(OBJECT_Menus_ENG[k])) {
						if (iTemp == i) {
							OBJECT_MenusENGs.add(OBJECT_Menus_ENG[k]);
						} else {
							OBJECT_MenusENGs.add(OBJECT_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// POLICY ENG
			if (main_menu.equals("POLICY")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Rules and Policies") && !MenusENG_temp.equals("DPI-SSL")
						&& !MenusENG_temp.equals("DPI-SSH") && !MenusENG_temp.equals("Security Services")
						&& !MenusENG_temp.equals("Anti-Spam") && !MenusENG_temp.equals("Capture ATP")
						&& !MenusENG_temp.equals("Endpoint Security")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < POLICY_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(POLICY_Menus_ENG[k])) {
						if (iTemp == i) {
							POLICY_MenusENGs.add(POLICY_Menus_ENG[k]);
						} else {
							POLICY_MenusENGs.add(POLICY_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

		}

		// --- Final VS ---
		// Merge data ZHT & ENG
		String[] HOME_ZHTs = HOME_MenusZHTs.toArray(new String[HOME_MenusZHTs.size()]);
		String[] MONITOR_ZHTs = MONITOR_MenusZHTs.toArray(new String[MONITOR_MenusZHTs.size()]);
		String[] DEVICE_ZHTs = DEVICE_MenusZHTs.toArray(new String[DEVICE_MenusZHTs.size()]);
		String[] NETWORK_ZHTs = NETWORK_MenusZHTs.toArray(new String[NETWORK_MenusZHTs.size()]);
		String[] OBJECT_ZHTs = OBJECT_MenusZHTs.toArray(new String[OBJECT_MenusZHTs.size()]);
		String[] POLICY_ZHTs = POLICY_MenusZHTs.toArray(new String[POLICY_MenusZHTs.size()]);
		String[][] Menu_ZHTs = { HOME_ZHTs, MONITOR_ZHTs, DEVICE_ZHTs, NETWORK_ZHTs, OBJECT_ZHTs, POLICY_ZHTs };

		// Merge data ENG
		String[] HOME_ENGs = HOME_MenusENGs.toArray(new String[HOME_MenusENGs.size()]);
		String[] MONITOR_ENGs = MONITOR_MenusENGs.toArray(new String[MONITOR_MenusENGs.size()]);
		String[] DEVICE_ENGs = DEVICE_MenusENGs.toArray(new String[DEVICE_MenusENGs.size()]);
		String[] NETWORK_ENGs = NETWORK_MenusENGs.toArray(new String[NETWORK_MenusENGs.size()]);
		String[] OBJECT_ENGs = OBJECT_MenusENGs.toArray(new String[OBJECT_MenusENGs.size()]);
		String[] POLICY_ENGs = POLICY_MenusENGs.toArray(new String[POLICY_MenusENGs.size()]);
		String[][] Menu_ENGs = { HOME_ENGs, MONITOR_ENGs, DEVICE_ENGs, NETWORK_ENGs, OBJECT_ENGs, POLICY_ENGs };

		// ZHT version missing
		for (int i = 0; i < 6; i++) {
			List<String> MenuZHTs = Arrays.asList(Menu_ZHTs[i]);
			List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
			for (String MenuENG : MenuENGs) {
				if (!MenuZHTs.contains(MenuENG)) {
					if (MenuENG.contains(" (TOP)")) {
						MenuENG = MenuENG.replace(" (TOP)", "");
					}
					// [L]Log
					log_message(testName, "[ZHT] version missing: " + main_menu + " > " + MenuENG);
					match++;
				}
			}
		}

		// ENG version missing
		for (int i = 0; i < 6; i++) {
			List<String> MenuZHTs = Arrays.asList(Menu_ZHTs[i]);
			List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
			for (String MenuZHT : MenuZHTs) {
				if (!MenuENGs.contains(MenuZHT)) {
					if (MenuZHT.contains(" (TOP)")) {
						MenuZHT = MenuZHT.replace(" (TOP)", "");
					}
					// [L]Log
					log_message(testName, "[ENG] version missing: " + main_menu + " > " + MenuZHT);
					match++;
				}
			}
		}

		return match;
	}

	// Start > Extent report
	public void start_exReport() {
		exReport = new ExtentReports(my_path + "\\Log\\report\\ExReport_VS.html");
		exTest = exReport.startTest("Menu Test > [ZHT] vs [ENG]");
	}

	// End > Extent report
	public void close_exReport() {
		exReport.endTest(exTest);
		exReport.flush();
	}

	// Log message[S]
	public void log_message(String test_name, String info) {
		log.info(test_name + " > " + info);
		exTest.log(LogStatus.INFO, test_name + " > " + info);
		Reporter.log("[S]ReportLog >> " + test_name + " > " + info, true);
	}

	@Test
	public void test_dataCompare() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		start_exReport();

		// Get data ZHT & ENG
		String[][] Menus_ZHTs = Box_ZHT();
		String[][] Menus_ENGs = box_ENG();

		// [L]Log
		log_message(testName, "Ready to start...");

		// [L]Log
		log_message(testName, "--------------------------------------------------------------------");

		// [L]Log (info ZHT)
		List<String> InfoZHTs = info_ZHT();
		log_message(testName, "[ZHT] info: " + "Device Name -----> " + InfoZHTs.get(0));
		log_message(testName, "[ZHT] info: " + "Serial Number ---> " + InfoZHTs.get(1));
		log_message(testName, "[ZHT] info: " + "Firmware Version > " + InfoZHTs.get(2));

		// [L]Log
		log_message(testName, "--------------------------------------------------------------------");

		// [L]Log (info ZHT)
		List<String> InfoENGs = info_ENG();
		log_message(testName, "[ENG] info: " + "Device Name -----> " + InfoENGs.get(0));
		log_message(testName, "[ENG] info: " + "Serial Number ---> " + InfoENGs.get(1));
		log_message(testName, "[ENG] info: " + "Firmware Version > " + InfoENGs.get(2));

		// [L]Log
		log_message(testName, "--------------------------------------------------------------------");

		// Compare data ZHT & ENG
		for (int i = 0; i < 6; i++) {
			List<String> MenusZHTs = Arrays.asList(Menus_ZHTs[i]);
			List<String> MenusENGs = Arrays.asList(Menus_ENGs[i]);
			match = missing_page(i, MenusZHTs, MenusENGs);
		}
		// Completely Match!
		if (match == 0) {
			log_message(testName, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			log_message(testName, "^          All Matched!          ^");
			log_message(testName, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//			System.out.println("********** All matched! **********");
		}

		close_exReport();
	}

}
