package com.skamirullah.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AllureEnvironment {

      public static void createEnv() throws IOException {
        File resultsFolder = new File("../allure-results");
        if (!resultsFolder.exists()) resultsFolder.mkdirs();

        FileWriter writer = new FileWriter(new File(resultsFolder, "environment.properties"));
        writer.write("Framework=Hybrid Automation\n");
        writer.write("Environment=QA\n");
        writer.write("Execution=Local\n");
        writer.write("Browser=Chrome\n");
        writer.write("OS=Mac\n");
        writer.close();
    }
}
