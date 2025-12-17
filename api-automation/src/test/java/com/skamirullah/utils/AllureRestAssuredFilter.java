package com.skamirullah.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class AllureRestAssuredFilter implements Filter {

    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public Response filter(
            FilterableRequestSpecification requestSpec,
            FilterableResponseSpecification responseSpec,
            FilterContext ctx) {

// 🔹 REQUEST
Allure.step("API Request", () -> {

        Allure.addAttachment(
                "Method & URL",
                "text/html",
                styledBlock(
                        "Method & URL",
                        requestSpec.getMethod() + " " + requestSpec.getURI()
                ),
                ".html"
        );

        Allure.addAttachment(
                "Headers",
                "text/html",
                styledBlock(
                        "Headers",
                        requestSpec.getHeaders().toString()
                ),
                ".html"
        );

        if (requestSpec.getBody() != null) {
            Allure.addAttachment(
                    "Body",
                    "text/html",
                    styledBlock(
                            "Request Body",
                            prettyJson(requestSpec.getBody())
                    ),
                    ".html"
            );
        }
    });

    // 🔹 EXECUTE
    Response response = ctx.next(requestSpec, responseSpec);

    // 🔹 RESPONSE
    Allure.step("API Response", () -> {

        Allure.addAttachment(
                "Status Code",
                "text/html",
                styledBlock(
                        "Status Code",
                        String.valueOf(response.statusCode())
                ),
                ".html"
        );

        Allure.addAttachment(
                "Headers",
                "text/html",
                styledBlock(
                        "Response Headers",
                        response.getHeaders().toString()
                ),
                ".html"
        );

        Allure.addAttachment(
                "Body",
                "text/html",
                styledBlock(
                        "Response Body",
                        response.getBody().prettyPrint()
                ),
                ".html"
        );
    });
    return response;
    }

    private String prettyJson(Object body) {
        try {
            return mapper.writeValueAsString(body);
        } catch (Exception e) {
            return body.toString();
        }
    }

    private String styledBlock(String title, String value) {
    return String.format(
        "<html>\n" +
        "  <body style=\"margin:0; padding:12px; background:black;\">\n" +
        "    <div style=\"\n" +
        "        font-family: monospace;\n" +
        "        font-size:14px;\n" +
        "    \">\n" +
        "      <div style=\"\n" +
        "          color:#ff4d4d;\n" +
        "          font-weight:bold;\n" +
        "          margin-bottom:6px;\n" +
        "      \">\n" +
        "        %s\n" +
        "      </div>\n" +
        "      <pre style=\"\n" +
        "          color:#4dff88;\n" +
        "          white-space:pre-wrap;\n" +
        "          word-break:break-word;\n" +
        "          margin:0;\n" +
        "      \">%s</pre>\n" +
        "    </div>\n" +
        "  </body>\n" +
        "</html>\n",
        title, value
    );
}

}
