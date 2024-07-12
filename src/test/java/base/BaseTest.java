package base;

import com.amlankumar.actions.AssertActions;
import com.amlankumar.endpoints.APIConstants;
import com.amlankumar.modules.PayLoadManager;
import com.beust.ah.A;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestspecification;
    public PayLoadManager payloadmanager;
    public AssertActions assertactions;
    public Response response;
    public ValidatableResponse validatableresponse;
    public JsonPath jsonpath;

    @BeforeTest
    public void setConfig(){

        System.out.println("Before Test-----");
        payloadmanager = new PayLoadManager();
        assertactions = new AssertActions();
        requestspecification = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URI).
        addHeader("Content-Type","application/json").build().log().all();
        //We can also use requestspecification = RestAssured.given().baseuri().header(). whichever is convenient

    }
    public String setToken(){ return null; }


}
