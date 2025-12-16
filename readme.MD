# Cypress Hybrid Automation Framework

Enterprise automation framework combining UI testing (Cypress) and API testing (TestNG) with unified Allure reporting and CI/CD integration.

---

## Tech Stack

- **UI Testing**: Cypress
- **API Testing**: Java + TestNG
- **Reporting**: Allure
- **CI/CD**: GitHub Actions
- **Build Tools**: Node.js, Maven

---

## Project Structure

```
cypress-hybrid-framework/
├── ui-automation/
│   └── cypress/
│       ├── e2e/              # UI test specs
│       ├── pages/            # Page objects
│       └── support/          # Custom commands
├── api-automation/
│   └── src/test/java/        # API test classes
└── run-allure.sh             # One-command execution
```

---

## Prerequisites

- Node.js ≥ 18
- Java ≥ 11
- Maven ≥ 3.8
- Allure CLI (`brew install allure`)

---

## Quick Start

**Clone and Setup**

```bash
git clone https://github.com/skamirullah/cypress-hybrid-framework.git
cd cypress-hybrid-framework

# Install UI dependencies
cd ui-automation && npm install && cd ..

# Build API project
cd api-automation && mvn clean install -DskipTests && cd ..
```

**Run All Tests**

```bash
./run-allure.sh
```

This executes UI + API tests and generates three Allure reports with trend analysis.

---

## View Reports

```bash
# Unified (UI + API combined)
allure open allure-report-unified

# UI only
allure open allure-report-ui

# API only
allure open allure-report-api
```

**Note**: Must use `allure open` command. Opening `index.html` directly won't work.

---

## CI/CD Integration

**Automated Execution**
- Tests run daily at 11:30 PM IST via GitHub Actions
- Scheduled nightly regression coverage

**Live Dashboards**

Reports auto-publish to GitHub Pages after each run:

- **Unified**:
https://skamirullah.github.io/cypress-hybrid-framework/unified/
![Unified Allure Report](https://skamirullah.github.io/cypress-hybrid-framework/screenshots/unified.png)
- **UI**: https://skamirullah.github.io/cypress-hybrid-framework/ui/
![UI Allure Report](https://skamirullah.github.io/cypress-hybrid-framework/screenshots/ui.png)
- **API**: https://skamirullah.github.io/cypress-hybrid-framework/api/
![API Allure Report](https://skamirullah.github.io/cypress-hybrid-framework/screenshots/api.png)

---

## Key Features

- Single command execution for UI + API tests
- Three report views: Unified, UI-only, API-only
- Trend analysis across builds
- Execution metadata (environment, build number, source)
- GitHub Pages dashboards for stakeholder access
- History preservation for each report type

---

## Contributing

1. Fork the repository
2. Create a feature branch
3. Submit a Pull Request

---

## Author

**Sk Amir Ullah**  
Senior QA & Automation Engineer | Founder, KnowMinds

---

Give it a ⭐ if this helps your team!
