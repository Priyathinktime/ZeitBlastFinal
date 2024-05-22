/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.constants;

import com.anhtester.helpers.Helpers;
import com.anhtester.helpers.PropertiesHelpers;
import com.anhtester.utils.ReportUtils;

import java.io.File;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    static {
        PropertiesHelpers.loadAllFiles();
        System.out.println("Data From FrameworkConstants: " + PropertiesHelpers.getProperties());
    }
    
//  LOGIN_PAGE
  public static final String LOGIN_USERNAME_PATH = PropertiesHelpers.getValue("LOGIN_USERNAME_PATH");
  public static final String LOGIN_PASSWORD_PATH = PropertiesHelpers.getValue("LOGIN_PASSWORD_PATH");
  public static final String LOGIN_TERMS_CONDITION_BOX = PropertiesHelpers.getValue("LOGIN_TERMS_CONDITION_BOX");
  public static final String LOGIN_BUTTON = PropertiesHelpers.getValue("LOGIN_BUTTON");
  public static final String LOGOUT_BUTTON = PropertiesHelpers.getValue("LOGOUT_BUTTON");
  public static final String ACCOUNT_NAME_ICON = PropertiesHelpers.getValue("ACCOUNT_NAME_ICON");
//  SETTING PAGE
  public static final String SETTING_PAGE= PropertiesHelpers.getValue("SETTING_PAGE");
  public static final String TODAY_MESSAGE_COUNT1=PropertiesHelpers.getValue("TODAY_MESSAGE_COUNT1");
  public static final String CREATE_NEW_MARKET_BUTTON=PropertiesHelpers.getValue("CREATE_NEW_MARKET_BUTTON");
  public static final String INPUT_MARKET_NAME=PropertiesHelpers.getValue("INPUT_MARKET_NAME");
  public static final String ENTER_AREACODE_BOX=PropertiesHelpers.getValue("ENTER_AREACODE_BOX");
  public static final String ENTER_AREACODE=PropertiesHelpers.getValue("ENTER_AREACODE");
  public static final String MARKET_SUBMIT_BUTTON=PropertiesHelpers.getValue("MARKET_SUBMIT_BUTTON");
  public static final String MARKET_CREATED_SUCCESS_MESSAGE=PropertiesHelpers.getValue("MARKET_CREATED_SUCCESS_MESSAGE");
  public static final String ADD_OUTBOUND_NUMBER_BUTTON=PropertiesHelpers.getValue("ADD_OUTBOUND_NUMBER_BUTTON");
  public static final String INPUT_OUTBOUND_NUMBER=PropertiesHelpers.getValue("INPUT_OUTBOUND_NUMBER");
  public static final String ADD_NUMBER_TO_MARKET_BUTTON=PropertiesHelpers.getValue("ADD_NUMBER_TO_MARKET_BUTTON");
  public static final String NUMBER_ADDED_SUCCESS_MESSAGE=PropertiesHelpers.getValue("NUMBER_ADDED_SUCCESS_MESSAGE");
  public static final String TODAY_MESSAGE_COUNT=PropertiesHelpers.getValue("TODAY_MESSAGE_COUNT");

  public static final String FOLLOWUP_CAMPAIGN_CREATED_SUCCESS_MESSAGE=PropertiesHelpers.getValue("FOLLOWUP_CAMPAIGN_CREATED_SUCCESS_MESSAGE");
  public static final String FOLLOWUP_CREATED_SUCCESSFULLY_SUCESS_MESSAGE=PropertiesHelpers.getValue("FOLLOWUP_CREATED_SUCCESSFULLY_SUCESS_MESSAGE");
  
//  INBOX PAGE
  public static final String INBOX_PAGE= PropertiesHelpers.getValue("INBOX_PAGE");
  public static final String QUICK_REPLY_BUTTON= PropertiesHelpers.getValue("QUICK_REPLY_BUTTON");
  public static final String QUICK_REPLY_TEMPLATE= PropertiesHelpers.getValue("QUICK_REPLY_TEMPLATE");
  public static final String SEND_BUTTON= PropertiesHelpers.getValue("SEND_BUTTON");
  public static final String VERIFIED_BUTTON= PropertiesHelpers.getValue("VERIFIED_BUTTON");
  public static final String LEADS_NAME= PropertiesHelpers.getValue("LEADS_NAME");
  public static final String DRIP_ICON= PropertiesHelpers.getValue("DRIP_ICON");
  public static final String DRIP_NAME= PropertiesHelpers.getValue("DRIP_NAME");
  public static final String DRIP_ASSIGN_SUCESS_MESSAGE= PropertiesHelpers.getValue("DRIP_ASSIGN_SUCESS_MESSAGE");
  public static final String ASSIGNED_DRIP= PropertiesHelpers.getValue("ASSIGNED_DRIP");
  public static final String NEXT_DRIP= PropertiesHelpers.getValue("NEXT_DRIP");
  public static final String DRIP_STATUS= PropertiesHelpers.getValue("DRIP_STATUS");
  public static final String NO_STATUS_DRIP= PropertiesHelpers.getValue("NO_STATUS_DRIP");
  public static final String DRIP_MESSAGE= PropertiesHelpers.getValue("DRIP_MESSAGE");
  public static final String DRIP_EXPIRED= PropertiesHelpers.getValue("DRIP_EXPIRED");
  public static final String LEAD_MESSAGE= PropertiesHelpers.getValue("LEAD_MESSAGE");
  public static final String DRIP_MESSAGE_TEMPLATE= PropertiesHelpers.getValue("DRIP_MESSAGE_TEMPLATE");
  public static final String GRAB_SEND_MESSAGE= PropertiesHelpers.getValue("GRAB_SEND_MESSAGE");
  public static final String LEAD_MESSAGE_NAME= PropertiesHelpers.getValue("LEAD_MESSAGE_NAME");
  public static final String ASSIGNED_DRIP_LEADS= PropertiesHelpers.getValue("ASSIGNED_DRIP_LEADS");
  public static final String LEAD_RESPONSE_MESSAGE= PropertiesHelpers.getValue("LEAD_RESPONSE_MESSAGE");
  public static final String LEAD_NUMBER_PATH= PropertiesHelpers.getValue("LEAD_NUMBER_PATH");
  
  
  
  //  TEMPLATE_PAGE
  public static final String PAGE_ICON = PropertiesHelpers.getValue("PAGE_ICON");
  public static final String TEMPLATE_PAGE = PropertiesHelpers.getValue("TEMPLATE_PAGE");
  public static final String PAGE_HEADER = PropertiesHelpers.getValue("PAGE_HEADER");
  public static final String CREATE_INITIAL_MESSAGE = PropertiesHelpers.getValue("CREATE_INITIAL_MESSAGE");
  public static final String INPUT_TEMPLATE_NAME = PropertiesHelpers.getValue("INPUT_TEMPLATE_NAME");
  public static final String SELECT_TEMPLATE_TYPE = PropertiesHelpers.getValue("SELECT_TEMPLATE_TYPE");
  public static final String QUICK_REPLY_TAB = PropertiesHelpers.getValue("QUICK_REPLY_TAB");
  public static final String CREATE_NEW_CATEGORY_BUTTON = PropertiesHelpers.getValue("CREATE_NEW_CATEGORY_BUTTON");
  public static final String CATEGORY_NAME = PropertiesHelpers.getValue("CATEGORY_NAME");
  public static final String SAVE_BUTTON = PropertiesHelpers.getValue("SAVE_BUTTON");
  public static final String SELECT_OPTIONS = PropertiesHelpers.getValue("SELECT_OPTIONS");
  public static final String INPUT_TITLE = PropertiesHelpers.getValue("INPUT_TITLE");
  public static final String TEXTAREA = PropertiesHelpers.getValue("TEXTAREA");
  public static final String NEXT_BUTTON = PropertiesHelpers.getValue("NEXT_BUTTON");
  public static final String SUBMIT_BUTTON = PropertiesHelpers.getValue("SUBMIT_BUTTON");
  public static final String SAVE_QUICK_REPLY_BUTTON = PropertiesHelpers.getValue("SAVE_QUICK_REPLY_BUTTON");
  public static final String CREATE_FOLLOWUP_MESSAGE = PropertiesHelpers.getValue("CREATE_FOLLOWUP_MESSAGE");
  public static final String TEMPLATE_CREATED_SUCCESS_MESAGE_PATH = PropertiesHelpers.getValue("TEMPLATE_CREATED_SUCCESS_MESAGE_PATH");
  public static final String CATEGORY_CREATED_SUCCESS_MESAGE = PropertiesHelpers.getValue("CATEGORY_CREATED_SUCCESS_MESAGE");
  public static final String SUCCESSFULLY_CREATED_SUCCESS_MESAGE = PropertiesHelpers.getValue("SUCCESSFULLY_CREATED_SUCCESS_MESAGE");
  public static final String INITIAL_MESSAGE_PAGE_TITLE = PropertiesHelpers.getValue("INITIAL_MESSAGE_PAGE_TITLE");
  public static final String TEMPLATE_TEXTAREA = PropertiesHelpers.getValue("TEMPLATE_TEXTAREA");

  
//  DRIP AUTOMATION PAGE
  public static final String DRIP_AUTOMATION_ICON = PropertiesHelpers.getValue("DRIP_AUTOMATION_ICON");
  public static final String DRIP_AUTOMATION_BUTTON = PropertiesHelpers.getValue("DRIP_AUTOMATION_BUTTON");
  public static final String CREATE_NEW_DRIP_BUTTON = PropertiesHelpers.getValue("CREATE_NEW_DRIP_BUTTON");
  public static final String INPUT_DRIP_AUTOMATION_NAME = PropertiesHelpers.getValue("INPUT_DRIP_AUTOMATION_NAME");
  public static final String ADD_DRIP_BUTTON = PropertiesHelpers.getValue("ADD_DRIP_BUTTON");
  public static final String SAVE_DRIP_BUTTON = PropertiesHelpers.getValue("SAVE_DRIP_BUTTON");
  public static final String DRIP_CREATED_SUCESS_MESSAGE_PATH = PropertiesHelpers.getValue("DRIP_CREATED_SUCESS_MESSAGE_PATH");
  
//  DIRECT IMPORT PAGE
  public static final String DIRECT_IMPORT_BUTTON = PropertiesHelpers.getValue("DIRECT_IMPORT_BUTTON");
  public static final String IMPORT_LIST_BUTTON = PropertiesHelpers.getValue("IMPORT_LIST_BUTTON");
  public static final String INPUT_FILE_PATH = PropertiesHelpers.getValue("INPUT_FILE_PATH");
  public static final String INPUT_FIELD_BUTTON = PropertiesHelpers.getValue("INPUT_FIELD_BUTTON");
  public static final String IMPORT_BUTTON = PropertiesHelpers.getValue("IMPORT_BUTTON");
  public static final String ADDED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("ADDED_SUCCESS_MESSAGE");
  public static final String ASSIGN_CAMPAIGN_BUTTON = PropertiesHelpers.getValue("ASSIGN_CAMPAIGN_BUTTON");
  public static final String SELECT_BUTTON = PropertiesHelpers.getValue("SELECT_BUTTON");
  public static final String ASSIGN_SUCCESSFULLY_SUCESS_MESSAGE = PropertiesHelpers.getValue("ASSIGN_SUCCESSFULLY_SUCESS_MESSAGE");
  public static final String FILE_UPLOADED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("FILE_UPLOADED_SUCCESS_MESSAGE");
  public static final String IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE = PropertiesHelpers.getValue("IMPORTED_SUCCESSFULLY_SUCCESS_MESSAGE");
  
  
  
//  DASHBOARD PAGE
  public static final String AVERAGE_DELIVERY_RATE = PropertiesHelpers.getValue("AVERAGE_DELIVERY_RATE");
  public static final String AVERAGE_RESPONSE_RATE = PropertiesHelpers.getValue("AVERAGE_RESPONSE_RATE");
 
//  CAMPAIGNS PAGE
  public static final String CAMAPIGN_BUTTON = PropertiesHelpers.getValue("CAMAPIGN_BUTTON");
  public static final String CREATE_NEW_CAMPAIGN_BUTTON = PropertiesHelpers.getValue("CREATE_NEW_CAMPAIGN_BUTTON");
  public static final String INPUT_CAMAPIGN_NAME = PropertiesHelpers.getValue("INPUT_CAMAPIGN_NAME");
  public static final String SELECT_MARKET_NAME = PropertiesHelpers.getValue("SELECT_MARKET_NAME");
  public static final String CREATE_NEW_FOLLOWUP_CAMPAIGN_BUTTON = PropertiesHelpers.getValue("CREATE_NEW_FOLLOWUP_CAMPAIGN_BUTTON");
  public static final String SELECT_CAMAPIGN_BUTTON = PropertiesHelpers.getValue("SELECT_CAMAPIGN_BUTTON");
  public static final String BUTTON_CONTAINS_SELECT_ = PropertiesHelpers.getValue("BUTTON_CONTAINS_SELECT_");
  public static final String SELECT_FOLLOWUP_CAMPAIGN = PropertiesHelpers.getValue("SELECT_FOLLOWUP_CAMPAIGN");
  public static final String CREATED_SUCCESSFULLY_SUCESS_MESSAGE = PropertiesHelpers.getValue("CREATED_SUCCESSFULLY_SUCESS_MESSAGE");
  public static final String CAMPAIGN_DETAILS = PropertiesHelpers.getValue("CAMPAIGN_DETAILS");
  public static final String CAMPAIGN_DETAIL_DASHBOARD = PropertiesHelpers.getValue("CAMPAIGN_DETAIL_DASHBOARD");
  public static final String CAMPAIGN_DELIVERABILITY_STATUS = PropertiesHelpers.getValue("CAMPAIGN_DELIVERABILITY_STATUS");
  public static final String CAMPAIGN_RESPONSE_STATUS = PropertiesHelpers.getValue("CAMPAIGN_RESPONSE_STATUS");

//  BATCHES PAGE
  public static final String BATCHES_BUTTON = PropertiesHelpers.getValue("BATCHES_BUTTON");
  public static final String CREATE_NEW_BATCH_BUTTON = PropertiesHelpers.getValue("CREATE_NEW_BATCH_BUTTON");
  public static final String SELECT_BATCH_BUTTON = PropertiesHelpers.getValue("SELECT_BATCH_BUTTON");
  public static final String SELECT2_BUTTON = PropertiesHelpers.getValue("SELECT2_BUTTON");
  public static final String SELECT_BATCH_SIZE_BUTTON = PropertiesHelpers.getValue("SELECT_BATCH_SIZE_BUTTON");
  public static final String SELECT_100_BUTTON = PropertiesHelpers.getValue("SELECT_100_BUTTON");
  public static final String CREATE_BATCH_BUTTON = PropertiesHelpers.getValue("CREATE_BATCH_BUTTON");
  public static final String BOTTOM_BUTTON = PropertiesHelpers.getValue("BOTTOM_BUTTON");
  public static final String GO_TO_INBOX_BUTTON = PropertiesHelpers.getValue("GO_TO_INBOX_BUTTON");
  public static final String OFFICE_TIMEOUT_MESSAGE = PropertiesHelpers.getValue("OFFICE_TIMEOUT_MESSAGE");
  public static final String BATCHES_DELIVERABILITY_STATUS = PropertiesHelpers.getValue("BATCHES_DELIVERABILITY_STATUS");
  public static final String BATCHES_RESPONSE_STATUS = PropertiesHelpers.getValue("BATCHES_RESPONSE_STATUS");
  
    public static final String PROJECT_PATH = Helpers.getCurrentDir();
    public static final String EXCEL_DATA_FILE_PATH = PropertiesHelpers.getValue("EXCEL_DATA_FILE_PATH");
    public static final String JSON_DATA_FILE_PATH = PropertiesHelpers.getValue("JSON_DATA_FILE_PATH");
    
    
    public static final String SUCCESSFULLY_CREATED_MESSAGE = PropertiesHelpers.getValue("SUCCESSFULLY_CREATED_MESSAGE");
    public static final String CATEGORY_CREATED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("CATEGORY_CREATED_SUCCESS_MESSAGE");
    public static final String TEMPLATE_CREATED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("TEMPLATE_CREATED_SUCCESS_MESSAGE");
    public static final String OUTBOUND_NUMBER_ADDED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("OUTBOUND_NUMBER_ADDED_SUCCESS_MESSAGE");
    public static final String  NO_DRIP_STATUS = PropertiesHelpers.getValue("NO_DRIP_STATUS");
    public static final String  OFFICE_TIMEOUT_SUCCESS_MESSAGE = PropertiesHelpers.getValue("OFFICE_TIMEOUT_SUCCESS_MESSAGE");
    public static final String CAMPAIGN_CREATED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("CAMPAIGN_CREATED_SUCCESS_MESSAGE");
    public static final String FILE_IMPORTED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("FILE_IMPORTED_SUCCESS_MESSAGE");
    public static final String CAMPAIGN_ASSIGNED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("CAMPAIGN_ASSIGNED_SUCCESS_MESSAGE");
    public static final String DRIP_CREATED_SUCCESS_MESSAGE = PropertiesHelpers.getValue("DRIP_CREATED_SUCCESS_MESSAGE");
    
//    public static final String Batches = PropertiesHelpers.getValue("Batches");
    public static final int BATCH_SIZE = Integer.parseInt(PropertiesHelpers.getValue("BATCH_SIZE"));
    public static final String API_HEADER = PropertiesHelpers.getValue("API_HEADER");
    public static final String QA_ADMIN_EMAIL_ADDRESS = PropertiesHelpers.getValue("QA_ADMIN_EMAIL_ADDRESS");
    public static final String SERVER_USERNAME = PropertiesHelpers.getValue("SERVER_USERNAME");
    public static final String SERVER_PASSWORD = PropertiesHelpers.getValue("SERVER_PASSWORD");
    public static final String MONGODB_URL = PropertiesHelpers.getValue("MONGODB_URL");
    public static final String OUTBOUND_NUMBER = PropertiesHelpers.getValue("OUTBOUND_NUMBER");
    public static final String QA_URL = PropertiesHelpers.getValue("QA_URL");
    public static final String QA_ADMIN_PASSWORD = PropertiesHelpers.getValue("QA_ADMIN_PASSWORD");
    public static final String MARKET_NAME = PropertiesHelpers.getValue("MARKET_NAME");
    public static final String AREA_CODE = PropertiesHelpers.getValue("AREA_CODE");
    public static final String CALL_FORWARDDING_NUMBER = PropertiesHelpers.getValue("CALL_FORWARDDING_NUMBER");
    public static final String CAMPAIGN_NAME = PropertiesHelpers.getValue("CAMPAIGN_NAME");
    public static final String SERVER_IP_ADDRESS = PropertiesHelpers.getValue("SERVER_IP_ADDRESS");
    public static final String API_URL = PropertiesHelpers.getValue("API_URL");
    public static final String TESTDATA_FILE_PATH =PROJECT_PATH + PropertiesHelpers.getValue("TESTDATA_FILE_PATH");
    public static final String LEADS_EXCEL_DATA_FILE_PATH= PROJECT_PATH + PropertiesHelpers.getValue("LEADS_EXCEL_DATA_FILE_PATH");
  
    public static final String LEADS_EXCEL_DATA_200_FILE_PATH= PROJECT_PATH + PropertiesHelpers.getValue("LEADS_EXCEL_DATA_200_FILE_PATH");
    
    public static final String EXCEL_DATA_20K_FILE_PATH= PROJECT_PATH + PropertiesHelpers.getValue("EXCEL_DATA_20K_FILE_PATH");
    public static final String XLX_DATA_30K_FILE_PATH= PROJECT_PATH + PropertiesHelpers.getValue("XLX_DATA_30K_FILE_PATH");
    public static final String CSV_DATA_50K_FILE_PATH= PROJECT_PATH + PropertiesHelpers.getValue("CSV_DATA_50K_FILE_PATH");
    public static final String INITIAL_MESSAGE_TEMPLATE_NAME= PROJECT_PATH + PropertiesHelpers.getValue("INITIAL_MESSAGE_TEMPLATE_NAME");
    public static final String INITIAL_MESSAGE_TEMPLATE_TYPE= PROJECT_PATH + PropertiesHelpers.getValue("INITIAL_MESSAGE_TEMPLATE_TYPE");
    public static final String FOLLOW_UP_TEMPLATE_NAME= PROJECT_PATH + PropertiesHelpers.getValue("FOLLOW_UP_TEMPLATE_NAME");
    public static final String FOLLOW_UP_TEMPLATE_TYPE= PROJECT_PATH + PropertiesHelpers.getValue("FOLLOW_UP_TEMPLATE_TYPE");
    public static final String MESSAGE_TEMPLATE= PROJECT_PATH + PropertiesHelpers.getValue("MESSAGE_TEMPLATE");
    public static final String TESTDATA_10_PATH= PROJECT_PATH + PropertiesHelpers.getValue("TESTDATA_10_PATH");
    public static final String TESTDATA_01_PATH= PROJECT_PATH + PropertiesHelpers.getValue("TESTDATA_01_PATH");		
    public static final String BATCHES_PAGE_TITLE=PropertiesHelpers.getValue("BATCHES_PAGE_TITLE");	
    public static final String CAMPAIGNS_PAGE_TITLE=PropertiesHelpers.getValue("CAMPAIGNS_PAGE_TITLE");	
    public static final String DASHBOARD_PAGE_TITLE=PropertiesHelpers.getValue("DASHBOARD_PAGE_TITLE");	
    public static final String DIRECT_IMPORT_PAGE_TITLE=PropertiesHelpers.getValue("DIRECT_IMPORT_PAGE_TITLE");	
    public static final String DRIP_PAGE_TITLE= PropertiesHelpers.getValue("DRIP_PAGE_TITLE");	
    public static final String INBOX_PAGE_TITLE= PropertiesHelpers.getValue("INBOX_PAGE_TITLE");	
    public static final String MARKET_PAGE_TITLE=  PropertiesHelpers.getValue("MARKET_PAGE_TITLE");	
    public static final String QA_AGENT_EMAIL_ADDRESS=PropertiesHelpers.getValue("QA_AGENT_EMAIL_ADDRESS");	
    public static final String QA_AGENT_PASSWORD=PropertiesHelpers.getValue("QA_AGENT_PASSWORD");	
    public static final String Time_Zone=PropertiesHelpers.getValue("Time_Zone");
    public static final int No_of_Delivery_1= Integer.parseInt(PropertiesHelpers.getValue("No_of_Delivery_1"));
    public static final int No_of_SendMSg_1= Integer.parseInt(PropertiesHelpers.getValue("No_of_SendMSg_1"));
    public static final int No_of_Verified_1= Integer.parseInt(PropertiesHelpers.getValue("No_of_Verified_1"));
    public static final int No_of_Delivery_2= Integer.parseInt(PropertiesHelpers.getValue("No_of_Delivery_2"));
    public static final int No_of_SendMSg_2= Integer.parseInt(PropertiesHelpers.getValue("No_of_SendMSg_2"));
    public static final int No_of_Verified_2= Integer.parseInt(PropertiesHelpers.getValue("No_of_Verified_2"));
    public static final int No_of_Delivery_3= Integer.parseInt(PropertiesHelpers.getValue("No_of_Delivery_3"));
    public static final int No_of_SendMSg_3= Integer.parseInt(PropertiesHelpers.getValue("No_of_SendMSg_3"));
  
    public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");
    public static final String URL_CRM = PropertiesHelpers.getValue("URL_CRM");
    public static final String REMOTE_URL = PropertiesHelpers.getValue("REMOTE_URL");
    public static final String REMOTE_PORT = PropertiesHelpers.getValue("REMOTE_PORT");
    public static final String PROJECT_NAME = PropertiesHelpers.getValue("PROJECT_NAME");
    public static final String REPORT_TITLE = PropertiesHelpers.getValue("REPORT_TITLE");
    public static final String EXTENT_REPORT_NAME = PropertiesHelpers.getValue("EXTENT_REPORT_NAME");
    public static final String EXTENT_REPORT_FOLDER = PropertiesHelpers.getValue("EXTENT_REPORT_FOLDER");
    public static final String EXPORT_VIDEO_PATH = PropertiesHelpers.getValue("EXPORT_VIDEO_PATH");
    public static final String EXPORT_CAPTURE_PATH = PropertiesHelpers.getValue("EXPORT_CAPTURE_PATH");
    public static final String SEND_REPORT_TO_TELEGRAM = PropertiesHelpers.getValue("SEND_REPORT_TO_TELEGRAM");
    public static final String TELEGRAM_TOKEN = PropertiesHelpers.getValue("TELEGRAM_TOKEN");
    public static final String TELEGRAM_CHATID = PropertiesHelpers.getValue("TELEGRAM_CHATID");
    public static final String AUTHOR = PropertiesHelpers.getValue("AUTHOR");
    public static final String TARGET = PropertiesHelpers.getValue("TARGET");
    public static final String HEADLESS = PropertiesHelpers.getValue("HEADLESS");
    public static final String OVERRIDE_REPORTS = PropertiesHelpers.getValue("OVERRIDE_REPORTS");
    public static final String OPEN_REPORTS_AFTER_EXECUTION = PropertiesHelpers.getValue("OPEN_REPORTS_AFTER_EXECUTION");
    public static final String SEND_EMAIL_TO_USERS = PropertiesHelpers.getValue("SEND_EMAIL_TO_USERS");
    public static final String SCREENSHOT_PASSED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_PASSED_STEPS");
    public static final String SCREENSHOT_FAILED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_FAILED_STEPS");
    public static final String SCREENSHOT_SKIPPED_STEPS = PropertiesHelpers.getValue("SCREENSHOT_SKIPPED_STEPS");
    public static final String SCREENSHOT_ALL_STEPS = PropertiesHelpers.getValue("SCREENSHOT_ALL_STEPS");
    public static final String ZIP_FOLDER = PropertiesHelpers.getValue("ZIP_FOLDER");
    public static final String ZIP_FOLDER_PATH = PropertiesHelpers.getValue("ZIP_FOLDER_PATH");
    public static final String ZIP_FOLDER_NAME = PropertiesHelpers.getValue("ZIP_FOLDER_NAME");
    public static final String VIDEO_RECORD = PropertiesHelpers.getValue("VIDEO_RECORD");
    public static final String LOCATE = PropertiesHelpers.getValue("LOCATE");

    public static final int WAIT_DEFAULT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_DEFAULT"));
    public static final int WAIT_IMPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_IMPLICIT"));
    public static final int WAIT_EXPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_EXPLICIT"));
    public static final int WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelpers.getValue("WAIT_PAGE_LOADED"));
    public static final int WAIT_SLEEP_STEP = Integer.parseInt(PropertiesHelpers.getValue("WAIT_SLEEP_STEP"));
    public static final String ACTIVE_PAGE_LOADED = PropertiesHelpers.getValue("ACTIVE_PAGE_LOADED");

    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + EXTENT_REPORT_FOLDER;
    public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
    public static String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;

    //Zip file for Report folder
    public static final String ZIPPED_EXTENT_REPORTS_FOLDER = EXTENT_REPORT_FOLDER + ".zip";

    public static final String YES = "yes";
    public static final String NO = "no";

    public static final String BOLD_START = "<b>";
    public static final String BOLD_END = "</b>";

    /* ICONS - START */

    public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
    public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
    public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";

    public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
    public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
    public static final String ICON_OS_LINUX = "<i class='fa fa-linux' ></i>";

    public static final String ICON_BROWSER_OPERA = "<i class=\"fa fa-opera\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_EDGE = "<i class=\"fa fa-edge\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_CHROME = "<i class=\"fa fa-chrome\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_FIREFOX = "<i class=\"fa fa-firefox\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_SAFARI = "<i class=\"fa fa-safari\" aria-hidden=\"true\"></i>";

    public static final String ICON_Navigate_Right = "<i class='fa fa-arrow-circle-right' ></i>";
    public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
    public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";
    /* style="text-align:center;" */

    public static final String ICON_SOCIAL_GITHUB_PAGE_URL = "https://anhtester.com/";
    public static final String ICON_SOCIAL_LINKEDIN_URL = "https://www.linkedin.com/in/anhtester/";
    public static final String ICON_SOCIAL_GITHUB_URL = "https://github.com/anhtester";
    public static final String ICON_SOCIAL_LINKEDIN = "<a href='" + ICON_SOCIAL_LINKEDIN_URL
            + "'><i class='fa fa-linkedin-square' style='font-size:24px'></i></a>";
    public static final String ICON_SOCIAL_GITHUB = "<a href='" + ICON_SOCIAL_GITHUB_URL
            + "'><i class='fa fa-github-square' style='font-size:24px'></i></a>";

    public static final String ICON_CAMERA = "<i class=\"fa fa-camera\" aria-hidden=\"true\"></i>";

    public static final String ICON_BROWSER_PREFIX = "<i class=\"fa fa-";
    public static final String ICON_BROWSER_SUFFIX = "\" aria-hidden=\"true\"></i>";
    /* ICONS - END */

    public static String getExtentReportFilePath() {
//        if (EXTENT_REPORT_FILE_PATH.isEmpty()) {
            EXTENT_REPORT_FILE_PATH = ReportUtils.createExtentReportPath();
//        }
        return EXTENT_REPORT_FILE_PATH;
    }

}
