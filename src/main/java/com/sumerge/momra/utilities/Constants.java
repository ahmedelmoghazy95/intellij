package com.sumerge.momra.utilities;

import java.util.ResourceBundle;

public class Constants {

    private static final ResourceBundle ENVIRONMENT_RN = ResourceBundle.getBundle("environment");
    public static final String MAIL_CONFIG = ENVIRONMENT_RN.getString("email.properties");
    public static final String ENVIRONMENT_NAME = ENVIRONMENT_RN.getString("env.name");
    public static final String PERFORMANCE_PROJECT_ID = ENVIRONMENT_RN.getString("performance.project.Id");
    public static final String APPLICATION_HOST = ENVIRONMENT_RN.getString("app.host");


    /***********Search Users***********/
    public static final String SEARCH_OFFICES_WORKBOOK = "SearchOfficesData.xlsx";
    public static final String SEARCH_OFFICES_ENV_SHEET = ENVIRONMENT_RN.getString("env.data.provider");


    /***********ENGINEERING OFFICES Users***********/
    public static final String ENGINEERING_OFFICES_WORKBOOK = "EngineeringOfficesData.xlsx";
    public static final String ENGINEERING_OFFICES_ENV_SHEET = ENVIRONMENT_RN.getString("env.data.provider");


}
