package com.skamirullah.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;
import com.skamirullah.utils.AllureEnvironment;

public class BaseTest {

  @BeforeSuite
  public void setupAllureEnv() throws IOException {
      AllureEnvironment.createEnv();
  }

  @BeforeClass
  public void setup() {
    baseURI = "http://216.10.245.166";
  }
}