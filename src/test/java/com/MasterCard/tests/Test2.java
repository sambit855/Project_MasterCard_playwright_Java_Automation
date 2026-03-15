package com.MasterCard.tests;

import com.microsoft.playwright.Playwright;

public class Test2 {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().new BrowserType.LaunchOptions().setHeadless(false)

}
