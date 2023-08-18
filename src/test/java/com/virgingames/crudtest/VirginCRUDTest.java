package com.virgingames.crudtest;

import com.virgingames.steps.VirginSteps;
import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;


@RunWith(SerenityRunner.class)
public class VirginCRUDTest extends TestBase {
    static ValidatableResponse response;


    @Steps
    VirginSteps virginSteps;

    @Title("Getting all data")
    @Test
    public void test001() {
        response = virginSteps.getAllData();
        response.log().all().statusCode(200);
    }

    @Title("Getting Data for Currency : GBP")
    @Test
    public void test002() {
        response = virginSteps.getAllData();
        HashMap<String, Object> currencyList = response.extract().path("data.pots[0]");
        Assert.assertThat(currencyList, hasValue("GBP"));

    }
}
