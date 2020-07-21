package endpoints;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import static config.ConfigProperties.BASE_URL;

public class BaseEndpoint {
    //public final static String BASE_URI = "https://petstore.swagger.io/v2";

    static {
        SerenityRest.filters(new RequestLoggingFilter(LogDetail.ALL));
        SerenityRest.filters(new ResponseLoggingFilter(LogDetail.ALL));
    }
    /**
     * Method makes a request to a base URI, collect logs and set headers
     *
     * @return base URI, logs, headers
     */
    protected RequestSpecification given() {
        return SerenityRest
                .given()
                .baseUri(BASE_URL)
                .contentType("application/json");
    }
}
