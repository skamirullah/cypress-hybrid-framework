package com.skamirullah.assertions;

import org.testng.Assert;

import com.skamirullah.constants.ApiMessages;
import com.skamirullah.models.response.AddBookResponse;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class BookAssertions {

    public static void assertStatusCode(Response response) {
        Allure.step("Check status code is 200", () -> {
            Assert.assertEquals(response.statusCode(), 201);
        });
    }

    public static void assertSuccessMessage(AddBookResponse response) {
        Allure.step("Verify success message", () -> {
            Assert.assertEquals(
                    response.getMsg(),
                    ApiMessages.BOOK_ADDED_SUCCESS
            );
        });
    }

    public static void assertBookId(AddBookResponse response) {
        Allure.step("Verify Book ID is generated", () -> {
            Assert.assertNotNull(response.getID());
        });
    }

    public static void assertBookAddedSuccessfully(Response response) {

        assertStatusCode(response);

        AddBookResponse res =
                response.as(AddBookResponse.class);

        assertSuccessMessage(res);
        assertBookId(res);
    }
}
