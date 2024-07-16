package com.amlankumar.tests.integration;

import base.BaseTest;
import com.amlankumar.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TCintegrationFlow extends BaseTest {
    @Test(groups="integration", priority = 1)
    @Owner("Amlan")
    @Description("Verify that booking can be created")
    public void testCreateBooking(ITestContext iTestContext){
        iTestContext.setAttribute("token",getToken());


    }

    @Test(groups="integration", priority = 2)
    @Owner("Amlan")
    @Description("Verify the existing booking that was created")
    public void testVerifyBooking(ITestContext iTestContext){
        System.out.println("Token: "+ iTestContext.getAttribute("token"));
        Assert.assertTrue(true);

    }

    @Test(groups="integration", priority = 3)
    @Owner("Amlan")
    @Description("Verify if the existing booking can be updated")
    public void testUpdateBooking(ITestContext iTestContext){
        System.out.println("Token: "+ iTestContext.getAttribute("token"));
        Assert.assertTrue(true);
    }

    @Test(groups="integration", priority = 4)
    @Owner("Amlan")
    @Description("Verify if the existing booking can be deleted")
    public void testDeleteBooking(ITestContext iTestContext){
        System.out.println("Token: "+ iTestContext.getAttribute("token"));
        Assert.assertTrue(true);
    }
}
