# Cypress Hybrid Automation Framework

Enterprise-ready hybrid automation framework for **UI and API testing** using **Cypress**, **TestNG**, and **Allure Reporting**, built for scalability, maintainability, and CI/CD readiness.

---

## 📌 Key Highlights

- Cypress for UI automation
- TestNG + Java for API automation
- Unified Allure reporting (UI + API)
- Separate UI-only and API-only Allure dashboards
- Trend analysis, Executors, and Environment info
- One-command execution
- CI/CD ready (GitHub Actions / Jenkins)
- Clean Git hygiene and modular structure

---

## 🧰 Tech Stack

| Layer | Technology |
|------|------------|
| UI Automation | Cypress |
| API Automation | Java, TestNG |
| Reporting | Allure |
| Build Tools | Node.js, Maven |
| CI/CD | GitHub Actions (ready) |
| Version Control | Git |

---

## 📁 Project Structure

### Root
- **run-allure.sh** – One-command execution script
- **.gitignore** – Git ignore rules
- **README.md** – Project documentation

### UI Automation (Cypress)
- **ui-automation/**
  - **cypress/**
    - **e2e/** – UI test specs
    - **pages/** – Page Object files
    - **support/** – Custom commands & hooks
  - **cypress.config.js** – Cypress configuration

### API Automation (TestNG)
- **api-automation/**
  - **src/test/java/** – API test classes
  - **pom.xml** – Maven configuration

### Allure Results (Generated at Runtime)
- **allure-results/**
  - **ui/** – UI test results
  - **api/** – API test results
  - **merged/** – Unified results

### Generated Reports
- **allure-report-ui/** – UI-only Allure report
- **allure-report-api/** – API-only Allure report
- **allure-report-unified/** – Unified UI + API report

---

## ▶️ Prerequisites

Ensure the following tools are installed:

- Node.js **≥ 18**
- Java **≥ 11**
- Maven **≥ 3.8**
- Allure CLI
- Git

### Install Allure CLI (macOS)
```bash
brew install allure
```

## ⚙️ Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/cypress-hybrid-framework.git
cd cypress-hybrid-framework
```

### 2️⃣ Install UI Dependencies
```bash
cd ui-automation
npm install
cd ..
```

### 3️⃣ Build API Project
```bash
cd api-automation
mvn clean install -DskipTests
cd ..
```

## 🚀 Running Tests (One Command)

Run UI + API tests and generate all reports:

```bash
./run-allure.sh
```

**What this command does:**
- Runs Cypress UI tests
- Runs TestNG API tests
- Generates three Allure reports
- Preserves execution history for trends

## 📊 Allure Reports

After execution, the following reports are available:

### 🔹 Unified Report (UI + API)
```bash
allure open allure-report-unified
```

### 🔹 UI-only Report (Cypress)
```bash
allure open allure-report-ui
```

### 🔹 API-only Report (TestNG)
```bash
allure open allure-report-api
```

> ℹ️ **Note:** Allure reports must be opened using `allure open`.  
> Do not open `index.html` directly.

## 📈 Trend Analysis

- Trends appear after at least two executions
- Each report (UI, API, Unified) maintains its own history
- Trends show pass/fail evolution across builds

## 🧾 Executors & Environment Info

Each Allure report displays:
- Execution source (Local / CI)
- Build number
- Environment (QA / UAT / PROD)
- Framework metadata

Configured automatically using:
- `executor.json`
- `environment.properties`

## 🔁 CI/CD Ready

This framework is designed to work seamlessly with:
- GitHub Actions
- Jenkins
- Docker (optional)

Reports can be published as:
- Downloadable Allure artifacts
- GitHub Pages dashboards

## 🧹 Git Hygiene

The following files/folders are intentionally ignored:
- `node_modules`
- `target`
- `allure-results`
- `allure-report-*`
- `.allure-history`

Refer to `.gitignore` for details.

## 🧠 Design Philosophy

- Result-level separation (UI / API)
- Report-level aggregation (Unified)
- No test re-runs for multiple dashboards
- Simple execution with advanced reporting

## 🤝 Contribution

Contributions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a Pull Request

## 👤 Author

**Sk Amir Ullah**  
Senior QA & Automation Engineer  
Founder – KnowMinds

## ⭐ Support

If you find this framework useful,  
give it a ⭐ on GitHub and share it with your team!
