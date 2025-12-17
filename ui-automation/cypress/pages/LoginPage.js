class LoginPage {
  myAccountDropdown = "a[title='My Account']";
  loginLink = ".dropdown-menu.dropdown-menu-right li:nth-child(2)";
  emailField = "#input-email";
  passwordField = "#input-password";
  loginButton = "input[value='Login']";


  login(user, pass) {
    cy.get(this.myAccountDropdown).click();
    cy.get(this.loginLink).click();
    cy.get(this.emailField).type(user);
    cy.get(this.passwordField).type(pass);
    cy.get(this.loginButton).click();
  }
}
export default new LoginPage();