package com.skamirullah.assertions;

import org.testng.Assert;

import com.skamirullah.constants.ApiMessages;
import com.skamirullah.models.response.AddBookResponse;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BookAssertions {

    @Step("Validate status code is 200")
    public static void assertStatusCode(Response response) {
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Step("Validate success message")
    public static void assertSuccessMessage(AddBookResponse response) {
        Assert.assertEquals(response.getMsg(), ApiMessages.BOOK_ADDED_SUCCESS);
    }

    @Step("Validate Book ID is generated")
    public static void assertBookId(AddBookResponse response) {
        Assert.assertNotNull(response.getID());
    }

    public static void assertBookAddedSuccessfully(Response response) {
        assertStatusCode(response);
        AddBookResponse res = response.as(AddBookResponse.class);
        assertSuccessMessage(res);
        assertBookId(res);
    }
}
