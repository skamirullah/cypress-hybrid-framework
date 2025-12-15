package com.skamirullah.tests;

import org.testng.annotations.Test;

import com.skamirullah.base.BaseTest;
import com.skamirullah.clients.BookApiClient;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;


@Epic("api-automation")
@Feature("Book Management")
@Story("Add book to Library")
public class AddBookTest extends BaseTest {

  @Test
  public void addBookTest() {
    BookApiClient client = new BookApiClient();
    String payload = "{\n" +
            "\n" +
            "\"name\":\"Learn Appium Automation with Java\",\n" +
            "\"isbn\":\"bcd\",\n" +
            "\"aisle\":\"227\",\n" +
            "\"author\":\"John foe\"\n" +
            "}\n";
    Response response = client.addBook(payload);
    response.then().statusCode(200);
  }
}