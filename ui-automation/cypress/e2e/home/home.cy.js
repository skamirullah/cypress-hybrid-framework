import HomePage from "../../pages/HomePage";

describe("Homepage Tests", () => {

    before(() => {
        cy.allure().label("suite", "UI Automation Suite");
        cy.allure()
            .epic("ui-automation")
            .feature("Inventory Module")
            .story("Home Page - Product listing");
    });

    beforeEach(() => {
        cy.loginSession();
    });

    it("should search the product", () => {
        cy.visit("/index.php?route=account/account");
        HomePage.searchProduct("Nikon");
        HomePage.getSearchResultHeader().should("contain.text", "Nikon");
    });


});