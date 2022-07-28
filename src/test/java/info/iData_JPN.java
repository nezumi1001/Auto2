package info;

import java.io.File;

public class iData_JPN {
	// --- Base ---
	public static String baseUrl = "https://10.8.162.157"; // NSa 2700
//	public static String baseUrl = "https://10.103.50.207"; // TZ 270W
//	public static String baseUrl = "https://10.8.162.169"; // TZ 570P

	public static File my_path = new File(System.getProperty("user.dir"));
	public static String[] chromeDriver_data = { "webdriver.chrome.driver",
			my_path.getParent() + "\\Driver\\chromedriver.exe" };

	// ===================================================================================================================================================================================
	// --- Item ---
	// Preempt
	public static String preempt_path = "//button[contains(text(),'非構成')]";
	// ユーザ名 field
	public static String userName_path = "//input[contains(@placeholder,'ユーザ名を入力')]";
	public static String login_name = "admin";
	// パスワード field
	public static String password_path = "//input[contains(@placeholder,'パスワードを入力')]";
	public static String login_pass = "sonicwall";
	// ログイン button
	public static String login_path = "//div[contains(text(),'ログイン')]";

	// --- Info ---
	// Box Name > e.g. SONICWALL TZ 370W Japan
	public static String Box_Name_path = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
	// シリアル番号 > e.g. 2CB8ED69339C
	public static String Serial_Number_path = "//span[contains(text(),'シリアル番号')]/parent::div/following-sibling::div/span";
	// ファームウェア バージョン > e.g. SonicOS 7.0.1-5018
	public static String Firmware_Version_path = "//span[contains(text(),'ファームウェア バージョン')]/parent::div/following-sibling::div/span";

	// Config mode
	public static String Config_path = "//div[@class='sw-toggle sw-toggle--left sw-toggle--regular sw-toggle--light']";

	// Top Page
	// HOME
	public static String HomeMenu_Dashboard_url = baseUrl + "/sonicui/7/m/dashboard/overview/status/device";
	public static String HomeMenu_Legal_Information_url = baseUrl + "/sonicui/7/m/mgmt/legal/view/device";
	public static String HomeMenu_API_url = baseUrl + "/sonicui/7/m/mgmt/api/documentation/device";

	// MONITOR
	public static String MonitorMenu_RealTimeCharts_url = baseUrl + "/sonicui/7/m/mgmt/system/real-time-monitor";
	public static String MonitorMenu_AppFlow_url = baseUrl + "/sonicui/7/m/analytics/appflow/reports";
	public static String MonitorMenu_SDWAN_url = baseUrl + "/sonicui/7/m/mgmt/sdwan/sdwan-legacy-monitor";
	public static String MonitorMenu_SDWAN_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='SDWAN']";
	public static String MonitorMenu_Logs_url = baseUrl + "/sonicui/7/m/mgmt/log/log-monitor";
	public static String MonitorMenu_ToolsMonitors_url = baseUrl
			+ "/sonicui/7/m/mgmt/diagnostics/ngpe-packets/captured-packets";

	// DEVICE
	public static String DeviceMenu_Settings_url = baseUrl + "/sonicui/7/m/mgmt/system/license-enhanced";
	public static String DeviceMenu_HighAvailability_url = baseUrl + "/sonicui/7/m/mgmt/ha/status";
	public static String DeviceMenu_Users_url = baseUrl + "/sonicui/7/m/mgmt/users/users-status";
	public static String DeviceMenu_AppFlow_url = baseUrl + "/sonicui/7/m/mgmt/appflow/appflow-flow-reporting";
	public static String DeviceMenu_Log_url = baseUrl + "/sonicui/7/m/mgmt/log/log-settings";
	public static String DeviceMenu_Diagnostics_url = baseUrl + "/sonicui/7/m/mgmt/diagnostics/report";
	public static String DeviceMenu_SwitchNetwork_url = baseUrl + "/sonicui/7/m/mgmt/switch-network/switch-overview";
	public static String DeviceMenu_AccessPoints_url = baseUrl + "/sonicui/7/m/mgmt/aps/access-points-settings";
	public static String DeviceMenu_AccessPoints_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='アクセス ポイント']";
	public static String DeviceMenu_WWAN_url = baseUrl + "/sonicui/7/m/mgmt/construction/wwan-dashboard";
	
	// Test
//	public static String DeviceMenu_AccessPoints_IDS_path = "//li[@class='sw-nav-group sw-nav-group--dark sw-nav-group--compact']//ul[@class='sw-nav-group__items sw-nav-group__items--nested-level-0']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='IDS']";


	// All nested
	public static String SubMenu_nested = "//ul[@class='sw-nav-group__items sw-nav-group__items--nested-level-0']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";
	// Unselect nested
	public static String Unselected_Nested_path = "//li[@class='sw-nav-group sw-nav-group--dark sw-nav-group--compact']//ul[@class='sw-nav-group__items sw-nav-group__items--nested-level-0']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	public static String HomeMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='ホーム']";
	public static String MonitorMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='監視']";
	public static String DeviceMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='デバイス']";
	public static String NetworkMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='ネットワーク']";
	public static String ObjectMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='オブジェクト']";
	public static String PolicyMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='ポリシー']";
	// --- Main menu ---
	// Home > Dashboard > System
	public static String HomeMenu_Dashboard_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ダッシュボード']";
	public static String HomeMenu_System_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='システム']";
	public static String HomeMenu_System_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='システム']";
	// MONITOR > Real-Time Charts > System Monitor
	public static String MonitorMenu_RealTimeCharts_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='リアルタイム グラフ']";
	public static String MonitorMenu_SystemMonitor_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='システム監視']";
	public static String MonitorMenu_SystemMonitor_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='システム監視']";
	// DEVICE > Settings > Licenses
	public static String DeviceMenu_Settings_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='設定']";
	public static String DeviceMenu_Licenses_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ライセンス']";
	public static String DeviceMenu_Licenses_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='ライセンス']";
	// NETWORK > System > Interfaces
	public static String NetworkMenu_System_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='システム']";
	public static String NetworkMenu_Interfaces_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='インターフェース']";
	public static String NetworkMenu_Interfaces_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='インターフェース']";
	// OBJECT > Match Objects > Zones
	public static String ObjectMenu_MatchObjects_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='一致オブジェクト']";
	public static String ObjectMenu_Zones_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ゾーン']";
	public static String ObjectMenu_Zones_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='ゾーン']";
	// POLICY > Rules and Policies > Access Rules
	public static String PolicyMenu_RulesPolicies_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ルールとポリシー']";
	public static String PolicyMenu_AccessRules_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='アクセス ルール']";
	public static String PolicyMenu_AccessRules_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='アクセス ルール']";

	// Main menu > Sub menu
	public static String MainSub_menu_path = "//span[@class='sw-breadcrumb__item__text']//span[@class='fw-app-header__breadcrumb-device-name']";

	// All left pane
	public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// --- Dark menu ---
	public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Left pane ---
	// HOME
	public static String[][] leftPane_HOME = { { "ダッシュボード", "Dashboard" }, { "システム", "System" },
			{ "アクセス ポイント", "Access Points" }, { "キャプチャ ATP", "Capture ATP" }, { "Policy Overview", "Policy Overview" },
			{ "トポロジ", "Topology" }, { "法的情報", "Legal Information" }, { "API", "API" } };

	// MONITOR
	public static String[][] leftPane_MONITOR = { { "リアルタイム グラフ", "Real-Time Charts" }, { "システム監視", "System Monitor" },
			{ "プロトコル監視", "Protocol Monitor" }, { "Policy Monitor", "Policy Monitor" }, { "ユーザ監視", "User Monitor" },
			{ "帯域幅管理監視", "BWM Monitor" }, { "AppFlow", "AppFlow" }, { "AppFlow 報告", "AppFlow Report" },
			{ "AppFlow 監視", "AppFlow Monitor" }, { "AppFlow Sessions", "AppFlow Sessions" },
			{ "CTA レポート", "CTA Report" }, { "SDWAN", "SDWAN" }, { "SDWAN 監視", "SDWAN Monitor" },
			{ "SD-WAN 接続", "SD-WAN Connections" }, { "ログ", "Logs" }, { "システム ログ", "System Logs" },
			{ "監査ログ", "Auditing Logs" }, { "ツールと監視", "Tools & Monitors" }, { "パケット監視", "Packet Monitor" },
			{ "Active Connections", "Active Connections" }, { "接続", "Connections" },
			{ "コア 0 プロセス", "Core 0 Processes" }, { "パケット再生", "Packet Replay" } };

	// DEVICE
	public static String[][] leftPane_DEVICE = { { "設定", "Settings" }, { "ライセンス", "Licenses" },
			{ "管理", "Administration" }, { "時間", "Time" }, { "証明書", "Certificates" }, { "SNMP", "SNMP" },
			{ "ファームウェアと設定", "Firmware and Settings" }, { "記憶装置", "Storage" }, { "再起動", "Restart" },
			{ "内部無線", "Internal Wireless" }, { "状況", "Status" }, { "セキュリティ", "Security" }, { "詳細", "Advanced" },
			{ "MAC フィルタ リスト", "MAC Filter List" }, { "IDS", "IDS" }, { "仮想アクセス ポイント", "Virtual Access Point" },
			{ "高可用性", "High Availability" }, { "監視", "Monitoring" }, { "ユーザ", "Users" }, { "パーティション", "Partitions" },
			{ "ローカル ユーザとグループ", "Local Users & Groups" }, { "ゲスト サービス", "Guest Services" },
			{ "ゲスト アカウント", "Guest Accounts" }, { "ゲスト状況", "Guest Status" }, { "AppFlow", "AppFlow" },
			{ "フロー報告", "Flow Reporting" }, { "AppFlow エージェント", "AppFlow Agent" },
			{ "Network Access Control", "Network Access Control" }, { "Settings", "Settings" },
			{ "Sessions", "Sessions" }, { "ログ", "Log" }, { "Syslog", "Syslog" }, { "自動化", "Automation" },
			{ "名前解決", "Name Resolution" }, { "レポート", "Reports" }, { "AWS", "AWS" }, { "診断", "Diagnostics" },
			{ "テクニカル サポート レポート", "Tech Support Report" }, { "ネットワーク設定の確認", "Check Network Settings" },
			{ "DNS 名の調査", "DNS Name Lookup" }, { "ネットワーク パス", "Network Path" }, { "Ping", "Ping" },
			{ "ルート追跡", "Trace Route" }, { "リアルタイム ブラックリスト", "Real-Time Blacklist" },
			{ "逆引き名前調査", "Reverse Name Lookup" }, { "上位接続", "Connection TopX" }, { "地域とボットネット", "Geo and Botnet" },
			{ "MX とバナー", "MX and Banner" }, { "グリッド確認", "GRID Check" }, { "URL 格付け要求", "URL Rating Request" },
			{ "PMTU 検出", "PMTU Discovery" }, { "スイッチ診断", "Switch Diagnostics" }, { "Policy Lookup", "Policy Lookup" },
			{ "スイッチ ネットワーク", "Switch Network" }, { "概要", "Overview" }, { "スイッチ", "Switches" },
			{ "アクセス ポイント", "Access Points" }, { "ファームウェア管理", "Firmware Management" },
			{ "フロア プランの表示", "Floor Plan View" }, { "ステーション状況", "Station Status" }, { "IDS", "IDS" },
			{ "高度な IDP", "Advanced IDP" }, { "パケット キャプチャ", "Packet Capture" },
			{ "仮想アクセス ポイント", "Virtual Access Point" }, { "RF 監視", "RF Monitoring" }, { "RF 解析", "RF Analysis" },
			{ "RF スペクトラム", "RF Spectrum" }, { "FairNet", "FairNet" }, { "Wi-Fi マルチメディア", "Wi-Fi Multimedia" },
			{ "3G/4G/LTE WWAN", "3G/4G/LTE WWAN" }, { "Bluetooth LE", "Bluetooth LE" }, { "無線管理", "Radio Management" },
			{ "WWAN", "WWAN" } };

	// NETWORK
	public static String[] leftPane_NETWORK = { "システム", "インターフェース", "フェイルオーバーと負荷分散", "近隣者検出", "ARP", "MAC IP アンチスプーフ",
			"ウェブ プロキシ", "PortShield グループ", "PoE 設定", "VLAN 変換", "IP ヘルパー", "動的ルーティング", "DHCP サーバ", "マルチキャスト",
			"ネットワーク監視", "AWS 設定", "ファイアウォール", "詳細", "フラッド防御", "SSL 制御", "暗号化制御", "RBL フィルタ", "VoIP", "設定", "通話状況",
			"DNS", "設定", "動的 DNS", "DNS プロキシ", "DNS セキュリティ", "スイッチング", "VLAN トランク", "L2 発見", "リンク統合", "ポート ミラーリング",
			"SDWAN", "グループ", "SLA プローブ", "SLA クラス オブジェクト", "パス選択プロファイル", "ルール", "IPSec VPN", "ルールと設定", "詳細",
			"VPN を越えた DHCP", "L2TP サーバ", "AWS VPN", "SSL VPN", "状況", "サーバ設定", "クライアント設定", "ポータル設定", "仮想オフィス" };

	// OBJECT
	public static String[] leftPane_OBJECT = { "一致オブジェクト", "ゾーン", "アドレス", "サービス", "Countries", "Applications",
			"Web Categories", "Websites", "URI リスト", "Match Patterns", "Custom Match", "一致オブジェクト", "スケジュール", "動的グループ",
			"電子メール アドレス", "プロファイル オブジェクト", "エンドポイント セキュリティ", "帯域幅", "Block Page", "Log and Alerts",
			"Intrusion Prevention", "QoS 級割", "コンテンツ フィルタ", "DHCP オプション", "AWS", "Action Profiles",
			"Security Action Profile", "DoS Action Profile", "Signatures", "Anti-Virus Signatures",
			"Anti-Spyware Signatures", "動作オブジェクト", "アプリケーション ルールの動作", "コンテンツ フィルタの動作" };

	// POLICY
	public static String[] leftPane_POLICY = { "ルールとポリシー", "Settings", "Security Policy", "NAT Policy", "Route Policy",
			"Decryption Policy", "DoS Policy", "Endpoint Policy", "Shadow", "アクセス ルール", "NAT ルール", "ルーティング ルール",
			"コンテンツ フィルタ ルール", "アプリケーション ルール", "エンドポイント ルール", "DPI-SSL", "クライアント SSL", "サーバ SSL", "DPI-SSH", "設定",
			"セキュリティ サービス", "サマリ", "ゲートウェイ アンチウイルス", "アンチスパイウェア", "侵入防御", "地域 IP フィルタ", "ボットネット フィルタ", "アプリケーション制御",
			"コンテンツ フィルタ", "アンチスパム", "状況", "設定", "キャプチャ ATP", "設定", "スキャン履歴", "エンドポイント セキュリティ" };

}
