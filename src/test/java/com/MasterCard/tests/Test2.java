package com.MasterCard.tests;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Test2 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
       Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
       BrowserContext context =  browser.newContext(new Browser.NewContextOptions().setViewportSize(1680,1050));
       Page page =  context.newPage();
       page.navigate("https://testautomationpractice.blogspot.com/");
       String pageTitle = page.title();
       System.out.println(pageTitle);
       assertThat(page).hasTitle("Automation Testing Practice");
       String pageURL = page.url();
       System.out.println(pageURL);
       assertThat(page).hasURL("https://testautomationpractice.blogspot.com/");

       page.locator("#name").fill("Sambit");
       page.locator("#email").fill("samb@gmail.com");
       page.locator("#phone").fill("7681888967");

       page.locator("#male").click();

       String[] checkbox = {"#sunday","#monday","#tuesday","#friday"};

       for(String day : checkbox)
       {
          page.locator(day).check();
       }




       // Select Dropdown
       // Select Dropdown
       Locator dropdownOptions = page.locator("#country option");

       int optionCount = dropdownOptions.count();

       assertThat(dropdownOptions).hasCount(10);

       for(int i = 0; i < optionCount; i++)
       {
          String optionText = dropdownOptions.nth(i).textContent().trim();

          if(optionText.equalsIgnoreCase("Germany"))
          {
             String value = dropdownOptions.nth(i).getAttribute("value");
             page.locator("#country").selectOption(value);
             break;
          }
       }

       assertThat(page.locator("#country")).hasValue("germany");

       Locator colorsDropdown = page.locator("#colors");

       colorsDropdown.selectOption(new String[]{"red","blue"});



      //dropdown

      Locator datePickerBox =  page.locator("input.hasDatepicker#datepicker");
      datePickerBox.click();

      String ExpectedMonth = "August";
      String ExpectedYear = "2028";
      String ExpectedDate = "27";

      while(true)
      {
        String CurrentMonth =  page.locator(".ui-datepicker-month").textContent().trim();
        String CurrentYear = page.locator(".ui-datepicker-year").textContent().trim();
        if(ExpectedMonth.equals(CurrentMonth) && ExpectedYear.equals(CurrentYear))
        {
           break;
        }
        page.locator(".ui-icon:has-text('Next')").click();
      }

     Locator dates =  page.locator("//a[@class='ui-state-default']");

      for(int i = 0;i<dates.count();i++)
      {
        String days = dates.nth(i).textContent().trim();

         if(days.equals(ExpectedDate))
         {
            dates.nth(i).click();
            break;
         }
      }

      assertThat(datePickerBox).hasValue("08/27/2028");

       page.waitForTimeout(3000);






       page.close();
       context.close();
       playwright.close();

    }
}

