package com.amlankumar.tests.DataDriven;

import com.amlankumar.actions.AssertActions;
import com.amlankumar.modules.PayLoadManager;
import com.amlankumar.utils.UtilsExcel;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LoginAPItest {
    RequestSpecification rs;
    ValidatableResponse vr;
    Integer ID;
    Response res;

    @Test(dataProvider = "getData", dataProviderClass = UtilsExcel.class)
    public void VWOLoginAPI(String username, String password)
    {
        System.out.println("--LOGIN API---");
        System.out.println(username);
        System.out.println(password);


        VWOLoginPOJO pj = new VWOLoginPOJO();
        pj.setUsername(username);
        pj.setPassword(password);
        pj.setRemember(false);
        pj.setRecaptchaResponseField("");

        Gson gson = new Gson();
        String payload = gson.toJson(pj);

        rs= RestAssured.given();
        rs.baseUri("https://app.vwo.com").basePath("/login");
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();

        res = rs.when().post();
        vr = res.then();

        String resString = res.asString();
        System.out.println("Response:"+ resString);
        vr.statusCode(401);
    }
}
