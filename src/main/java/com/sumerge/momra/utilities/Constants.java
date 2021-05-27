package com.sumerge.momra.utilities;

import java.util.ResourceBundle;

public class Constants {

    private static final ResourceBundle ENVIRONMENT_RN = ResourceBundle.getBundle("environment");
    public static final String MAIL_CONFIG = ENVIRONMENT_RN.getString("email.properties");
    public static final String ENVIRONMENT_NAME = ENVIRONMENT_RN.getString("env.name");
    public static final String APPLICATION_HOST = ENVIRONMENT_RN.getString("app.host");
    public static final String MODULE_NAME = ENVIRONMENT_RN.getString("module.name");

    /***********Search Data***********/
    public static final String SEARCH_OFFICES_WORKBOOK = "SearchOfficesData.xlsx";
    public static final String SEARCH_OFFICES_ENV_SHEET = "Sheet1";


    /***********ENGINEERING OFFICES Data***********/
    public static final String ENGINEERING_OFFICES_WORKBOOK = "EngineeringOfficesData.xlsx";
    public static final String ENGINEERING_OFFICES_ENV_SHEET = "Sheet1";

    /***********Visits Reports Data***********/
    public static final String VISITS_REPORT_WORKBOOK = "VisitsReportData.xlsx";
    public static final String VISITS_REPORT_ENV_SHEET = "Sheet1";


}
