package com.skamirullah.clients;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookApiClient {

    private static final String ADD_BOOK_ENDPOINT =
            "/Library/Addbook.php";

    public Response addBook(RequestSpecification spec, Object body) {
        return given()
                .spec(spec)
                .body(body)
                .when()
                .post(ADD_BOOK_ENDPOINT);
    }
}
