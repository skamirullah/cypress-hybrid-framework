package com.skamirullah.tests;

import org.testng.annotations.Test;

import com.skamirullah.assertions.BookAssertions;
import com.skamirullah.base.BaseTest;
import com.skamirullah.clients.BookApiClient;
import com.skamirullah.utils.TestDataFactory;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;

@Epic("api-automation")
@Feature("Book Management")
public class AddBookTest extends BaseTest {

    private final BookApiClient bookApi = new BookApiClient();

    @Test(description = "Verify user can add a book successfully")
    @Story("Add Book")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Sk Amir Ullah")
    @Link(name = "API Spec", url = "http://knowminds.com")
    public void shouldAddBookSuccessfully() {
        var request = TestDataFactory.createValidBook();
        Response response =
                bookApi.addBook(requestSpec, request);
        System.out.println("Response: " + response.asString());
        BookAssertions.assertBookAddedSuccessfully(response);
    }
}
