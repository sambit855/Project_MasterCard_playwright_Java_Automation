package com.MasterCard.tests;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Test2 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
       Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
       BrowserContext context =  browser.newContext(new Browser.NewContextOptions().setViewportSize(1680,1050));
       Page page =  context.newPage();
       page.navigate("https://automationexercise.com/test_cases");
       String pageTitle = page.title();
       System.out.println(pageTitle);
       assertThat(page).hasTitle("Automation Practice Website for UI Testing - Test Case");
       String pageURL = page.url();
       System.out.println(pageURL);
       assertThat(page).hasURL("https://automationexercise.com/test_cases");

       






       page.close();
       context.close();
       playwright.close();

    }
}

