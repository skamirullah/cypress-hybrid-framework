// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

Cypress.Commands.add("loginSession", () => {
    cy.session(
        "validUser",
        () => {
            cy.fixture("users").then(({ validUser }) => {

                cy.visit("/index.php?route=account/login");

                cy.get("#input-email").type(validUser.username);
                cy.get("#input-password").type(validUser.password);
                cy.get("input[value='Login']").click();

                cy.url().should("include", "account/account");
                cy.getCookie("OCSESSID").should("exist");
            });
        },
        {
            validate() {
                cy.getCookie("OCSESSID").should("exist");
            }
        }
    );
});
