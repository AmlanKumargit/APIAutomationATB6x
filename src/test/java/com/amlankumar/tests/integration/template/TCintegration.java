package com.amlankumar.tests.integration.template;


import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCintegration extends BaseTest {

// Create, Verify, Update, Delete booking
    @Test(groups="integration", priority = 1)
    @Owner("Amlan")
    @Description("Verify that booking can be created")
    public void testCreateBooking(){
    Assert.assertTrue(true);
    }

    @Test(groups="integration", priority = 2)
    @Owner("Amlan")
    @Description("Verify the existing booking that was created")
    public void testVerifyBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups="integration", priority = 3)
    @Owner("Amlan")
    @Description("Verify if the existing booking can be updated")
    public void testUpdateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups="integration", priority = 4)
    @Owner("Amlan")
    @Description("Verify if the existing booking can be deleted")
    public void testDeleteBooking(){
        Assert.assertTrue(true);
    }


}
