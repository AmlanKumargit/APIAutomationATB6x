package com.amlankumar.actions;

import io.restassured.response.Response;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class AssertActions {

    public void VerifyResponseBody(String actual, String expected, String description){
        assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(int actual, int expected, String description){
        assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(float actual, float expected, String description){
        assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(double actual, double expected, String description){
        assertEquals(actual, expected, description);
    }
    public void VerifyResponseBody(boolean actual, boolean expected, String description){
        assertEquals(actual, expected, description);
    }
    public static void verifyStatusCode(Response response, Integer expected) {
        assertEquals(response.getStatusCode(),expected);
    }
    public void InvalidStatusCode(Response response){
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("50"),"value of code is "
                + response.getStatusCode());

    }
}
