const { defineConfig } = require("cypress");
const allureWriter = require("@shelex/cypress-allure-plugin/writer");
const envConfig = require("./cypress/support/env");

module.exports = defineConfig({
  e2e: {
    baseUrl: envConfig.ui.baseUrl,
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
