package com.MasterCard.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test1 {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.google.com");

        System.out.println("Page Title: " + page.title());

        browser.close();
        playwright.close();
    }
}
