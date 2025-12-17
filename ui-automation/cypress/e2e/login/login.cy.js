describe("Login Test", () => {
  before(() => {
    cy.allure().label("suite", "UI Automation Suite");
    cy.allure()
      .epic("ui-automation")
      .feature("Login Module")
      .story("Valid login");
  });

  beforeEach(() => {
    cy.loginSession();
  });

  it("should login successfully with valid credentials", () => {
    cy.visit("/index.php?route=account/account");
    cy.url().should("include", "/account");
  });

});