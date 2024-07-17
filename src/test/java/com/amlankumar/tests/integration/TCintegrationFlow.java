package com.amlankumar.tests.integration;

import base.BaseTest;
import com.amlankumar.endpoints.APIConstants;
import com.amlankumar.modules.PayLoadManager;
import com.amlankumar.pojos.Booking;
import com.amlankumar.pojos.BookingResponse;
import com.amlankumar.utils.PropertyReader;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TCintegrationFlow extends BaseTest {
    @Test(groups="integration", priority = 1)
    @Owner("Amlan")
    @Description("Verify that booking can be created")
    public void testCreateBooking(ITestContext iTestContext){
        //Set Token attribute here to pass the token to all methods below using ITestContext listener interface.
        iTestContext.setAttribute("token",getToken());

        requestspecification.basePath(APIConstants.BASE_PATH);
        response = RestAssured.given(requestspecification).log().all().
                body(payloadmanager.CreateBookingAsString()).when().post();
        //Validatable Assertions
        validatableresponse = response.then().log().all().statusCode(200);
        //  validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod")); ---- using Matchers

        //Deserialisation
        BookingResponse bookingresponse = PayLoadManager.BookingResponseJava(response.asString());

        //AssertJ assertions
        assertThat(bookingresponse.getBookingid()).isNotNull();
        assertThat(bookingresponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingresponse.getBooking().getLastname()).isNotNull().isNotBlank();
        assertThat(bookingresponse.getBooking().getFirstname()).isEqualTo(PropertyReader.readKey("booking.firstname"));
        assertThat(bookingresponse.getBooking().getLastname()).isEqualTo(PropertyReader.readKey("booking.lastname"));

        iTestContext.setAttribute("bookingid",bookingresponse.getBookingid());
    }

    @Test(groups="integration", priority = 2)
    @Owner("Amlan")
    @Description("Verify the existing booking that was created")
    public void testVerifyBooking(ITestContext iTestContext){
        System.out.println("Token: "+ iTestContext.getAttribute("token"));
        System.out.println("BookingID: "+ iTestContext.getAttribute("bookingid"));

        Integer bookingID = (Integer) iTestContext.getAttribute("bookingid");
        String BasePathGET = APIConstants.BASE_PATH+"/"+bookingID;
        System.out.println("Base Path:"+BasePathGET);

        requestspecification.basePath(BasePathGET);
        response = RestAssured.given(requestspecification).log().all().when().get();

        //Validatable Assertions
        validatableresponse = response.then().log().all().statusCode(200);
        //  validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod")); ---- using Matchers

        //Deserialisation
        Booking bookingresponseGET = PayLoadManager.BookingResponseGET(response.asString());

        //AssertJ assertions

        assertThat(bookingresponseGET.getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingresponseGET.getFirstname()).isEqualTo(PropertyReader.readKey("booking.firstname"));
        assertThat(bookingresponseGET.getLastname()).isEqualTo(PropertyReader.readKey("booking.lastname"));
    }

    @Test(groups="integration", priority = 3)
    @Owner("Amlan")
    @Description("Verify if the existing booking can be updated")
    public void testUpdateBooking(ITestContext iTestContext){
        System.out.println("Token: "+ iTestContext.getAttribute("token"));
        System.out.println("BookingID: "+ iTestContext.getAttribute("bookingid"));

        Integer bookingID = (Integer) iTestContext.getAttribute("bookingid");
        String token = (String) iTestContext.getAttribute("token");
        String BasePathPUT = APIConstants.BASE_PATH+"/"+bookingID;
        System.out.println("Base Path:"+BasePathPUT);

        requestspecification.basePath(BasePathPUT);
        response = RestAssured.given(requestspecification).cookie("token",token).
                body(payloadmanager.FullyUpdateBookingAsString()).log().all().when().put();

        //Validatable Assertions
        validatableresponse = response.then().log().all().statusCode(200);
        //  validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod")); ---- using Matchers

        //Deserialisation
        Booking bookingresponsePUT = PayLoadManager.BookingResponseGET(response.asString());

        //AssertJ assertions

        assertThat(bookingresponsePUT.getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingresponsePUT.getFirstname()).isEqualTo(PropertyReader.readKey("booking.put.firstname"));
        assertThat(bookingresponsePUT.getLastname()).isEqualTo(PropertyReader.readKey("booking.put.lastname"));
    }

    @Test(groups="integration", priority = 4)
    @Owner("Amlan")
    @Description("Verify if the existing booking can be deleted")
    public void testDeleteBooking(ITestContext iTestContext){
        System.out.println("Token: "+ iTestContext.getAttribute("token"));
        System.out.println("BookingID: "+ iTestContext.getAttribute("bookingid"));

        Integer bookingID = (Integer) iTestContext.getAttribute("bookingid");
        String token = (String) iTestContext.getAttribute("token");
        String BasePathDEL = APIConstants.BASE_PATH+"/"+bookingID;
        System.out.println("Base Path:"+BasePathDEL);

        requestspecification.basePath(BasePathDEL);
        response = RestAssured.given(requestspecification).cookie("token",token).log().all()
                .when().delete();

        //Validatable Assertions
        validatableresponse = response.then().log().all().statusCode(201);
    }
}
