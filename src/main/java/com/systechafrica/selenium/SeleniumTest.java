package com.systechafrica.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testTourBooking() {
        driver.get("http://34.125.27.159:8080/Tours-system/account-login");
        WebElement usernameInput = driver.findElement(By.id("username"));

        // Find password input by ID
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameInput.sendKeys("Emma");
        passwordInput.sendKeys("123");

        loginButton.click();

        WebElement siteLink = driver.findElement(By.linkText("Site"));
        siteLink.click();

        WebElement toursLink = driver.findElement(By.linkText("tours"));
        toursLink.click();

        WebElement viewMoreButton = driver.findElement(By.className("ViewMoreButton"));
        viewMoreButton.click();

        WebElement numberOfPeopleInput = driver.findElement(By.id("numberOfPeople"));
        numberOfPeopleInput.clear();
        numberOfPeopleInput.sendKeys("3");

        WebElement bookNowButton = driver.findElement(By.cssSelector("button[type='submit']"));
        bookNowButton.click();

        // Wait for the redirect and get the current URL
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://34.125.27.159:8080/Tours-system/my-bookings";

        // Check if the redirect is successful using assertEquals
        Assert.assertEquals("Error: Redirect failed.", expectedUrl, currentUrl);
        System.out.println("Booking Successful! Redirected to: " + currentUrl);

        // Add logout and additional steps if needed

        // You can also check the page title if necessary
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
