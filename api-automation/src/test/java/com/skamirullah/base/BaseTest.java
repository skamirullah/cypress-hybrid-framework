package com.skamirullah.base;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.skamirullah.utils.AllureEnvironment;
import com.skamirullah.utils.AllureRestAssuredFilter;
import com.skamirullah.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class BaseTest {

    protected RequestSpecification requestSpec;

    @BeforeSuite(alwaysRun = true)
    public void setupAllure() throws IOException {
        AllureEnvironment.createEnv();
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        RestAssured.baseURI = ConfigManager.getBaseUri();
        RestAssured.filters(new AllureRestAssuredFilter());
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setContentType("application/json")
                .build();
    }
}