package com.amlankumar.actions;

import org.testng.Assert;

public class AssertActions {

    public void VerifyResponseBody(String actual, String expected, String description){
        Assert.assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(int actual, int expected, String description){
        Assert.assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(float actual, float expected, String description){
        Assert.assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(double actual, double expected, String description){
        Assert.assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(boolean actual, boolean expected, String description){
        Assert.assertEquals(actual, expected, description);
    }
}
