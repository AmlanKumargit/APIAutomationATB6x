package com.amlankumar.tests.crud;

import base.BaseTest;
import com.amlankumar.actions.AssertActions;
import com.amlankumar.endpoints.APIConstants;
import com.amlankumar.modules.PayLoadManager;
import com.amlankumar.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCreateBooking extends BaseTest {

    @Test(groups="Smoke")
    @Owner("Amlan")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify booking can be created")
    public void CreateBooking(){

        requestspecification.basePath(APIConstants.BASE_PATH);
        response = RestAssured.given(requestspecification).
                body(payloadmanager.CreateBookingAsString()).when().post();
        //Validatable Assertions
        validatableresponse = response.then().log().all().statusCode(200);
        //  validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod")); ---- using Matchers

        //Deserialisation
        BookingResponse bookingresponse = PayLoadManager.BookingResponseJava(response.asString());

        //AssertJ assertions
        assertThat(bookingresponse.getBookingid()).isNotNull();
        assertThat(bookingresponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingresponse.getBooking().getFirstname()).isEqualTo("Jim");

        //TestNg Assertions
        assertactions.verifyStatusCode(response,200);
    }

    @Test(groups="Smoke")
    @Owner("Amlan")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify if a booking with an invalid payload can be created")
    public void CreateBookingNegative(){

        requestspecification.basePath(APIConstants.BASE_PATH);
        response = RestAssured.given(requestspecification).
                body(payloadmanager.CreateInvalidPayload()).when().post();
        //Validatable Assertions
        validatableresponse = response.then().log().all().statusCode(500);
        //  validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod")); ---- using Matchers


    }
}
