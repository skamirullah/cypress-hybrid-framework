class CartPage {
  cartLink = ".list-inline li:nth-child(4) a[title='Shopping Cart']";
  cartPageHeader = "#content h1";
  cartPageDescription = "#content p";

  clickCartLink() {
    cy.get(this.cartLink).click();
  }

  getCartPageHeader() {
    return cy.get(this.cartPageHeader);
  }

  getCartPageDescription() {
    return cy.get(this.cartPageDescription);
  }
}
export default new CartPage();