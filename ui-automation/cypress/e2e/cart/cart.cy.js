import CartPage from "../../pages/CartPage";

describe("Cart Tests", () => {

    before(() => {
        cy.allure().label("suite", "UI Automation Suite");
        cy.allure()
            .epic("ui-automation")
            .feature("Cart Module")
            .story("Cart Page - Checkout Cart");
    });

    beforeEach(() => {
        cy.loginSession();
    });

    it("should check cart for empty", () => {
        cy.visit("/index.php?route=checkout/cart");
        CartPage.clickCartLink();
        CartPage.getCartPageHeader().should("contain.text", "Shopping Cart");
        CartPage.getCartPageDescription().should("contain.text", "Your shopping cart is empty!");
    });


});