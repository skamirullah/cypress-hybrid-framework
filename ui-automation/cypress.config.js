const { defineConfig } = require("cypress");
const allureWriter = require("@shelex/cypress-allure-plugin/writer");

module.exports = defineConfig({
  e2e: {
    baseUrl: "https://saucedemo.com",
    viewportWidth: 1280,
    viewportHeight: 720,
    setupNodeEvents(on, config) {
      allureWriter(on, config);
      return config;
    },
  },
  env: {
    allure: true,
    allureResultsPath: "../allure-results/ui",
    allureReuseAfterSpec: true
  }
});
