package com.skamirullah.clients;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class BookApiClient {

  public Response addBook(String payload) {
    return given()
      .contentType("application/json")
      .body(payload)
      .post("/Library/Addbook.php");
  }
}