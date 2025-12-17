package com.skamirullah.utils;

import java.util.UUID;

import com.skamirullah.models.request.AddBookRequest;

public class TestDataFactory {

    public static AddBookRequest createValidBook() {
        return new AddBookRequest(
                "API Automation Book",
                UUID.randomUUID().toString().substring(0, 5),
                String.valueOf(System.currentTimeMillis()).substring(7),
                "SK Amir Ullah"
        );
    }
}
