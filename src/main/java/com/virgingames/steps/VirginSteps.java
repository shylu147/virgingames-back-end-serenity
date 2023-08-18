package com.virgingames.steps;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginSteps {

    @Step("Get all data")
    public ValidatableResponse getAllData() {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_All_DATA)
                .then().log().all();
    }
}
