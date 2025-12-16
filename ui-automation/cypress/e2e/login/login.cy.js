import LoginPage from "../../pages/LoginPage.js";

describe("Login Test", () => {
  before(() => {
    cy.allure().label("suite", "UI Automation Suite");
    cy.allure()
      .epic("ui-automation")
      .feature("Login Module")
      .story("Valid login");
  });

  it("Valid Login", () => {
    cy.visit("/");
    LoginPage.login("standard_user", "secret_sauce");
    cy.url().should("include", "/inventories");
  });

});