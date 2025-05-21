package com.chromatech.Cucumber_BDD_Testing.appsCommon;

import com.chromatech.Cucumber_BDD_Testing.pages.LoginPage;

public class PageInitializer {

    /**
     * THIS PAGE WILL BE USED TO INITIALIZE ALL
     * PAGE OBJECTS
     */
    public static LoginPage loginPage;

    public static void initializeAllPages() {
        loginPage = new LoginPage();

    }
}