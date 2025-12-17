class HomePage {
    homeIcon = ".breadcrumb li:nth-child(1)";
    searchField = "input[placeholder='Search']";
    searchIcon = ".input-group-btn button";
    searchResultHeader = "#content h1";

    searchProduct(productName) {
        cy.get(this.homeIcon).click();
        cy.get(this.searchField).type(productName);
        cy.get(this.searchIcon).click();
    }

    getSearchResultHeader() {
        return cy.get(this.searchResultHeader);
    }


}
export default new HomePage();