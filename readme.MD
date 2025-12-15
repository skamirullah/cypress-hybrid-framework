# Cypress Hybrid Automation Framework

Enterprise-ready hybrid automation framework for **UI and API testing** using **Cypress**, **TestNG**, and **Allure Reporting**, designed for scalability, maintainability, and CI/CD integration.

---

## 📌 Key Highlights

- ✅ Cypress for UI automation
- ✅ TestNG + Java for API automation
- ✅ Unified Allure reporting (UI + API)
- ✅ Separate UI-only and API-only Allure dashboards
- ✅ Trend analysis, Executors, Environment info
- ✅ One-command execution
- ✅ CI/CD ready (GitHub Actions / Jenkins)
- ✅ Clean Git hygiene and modular structure

---

## 🧰 Tech Stack

| Layer | Technology |
|-----|-----------|
| UI Automation | Cypress |
| API Automation | Java, TestNG |
| Reporting | Allure |
| Build Tools | Node.js, Maven |
| CI/CD | GitHub Actions (ready) |
| Version Control | Git |

---

## 📁 Project Structure

cypress-hybrid-framework/
│
├── ui-automation/ # Cypress UI tests
│ ├── cypress/
│ │ ├── e2e/
│ │ ├── pages/
│ │ └── support/
│ └── cypress.config.js
│
├── api-automation/ # API automation (TestNG)
│ ├── src/test/java/
│ └── pom.xml
│
├── allure-results/ # Runtime generated (ignored)
│ ├── ui/
│ ├── api/
│ └── merged/
│
├── allure-report-ui/ # UI-only report (generated)
├── allure-report-api/ # API-only report (generated)
├── allure-report-unified/ # Unified report (generated)
│
├── run-allure.sh # One-command execution script
├── .gitignore
└── README.md


---

## ▶️ Prerequisites

Make sure the following are installed:

- Node.js ≥ 18
- Java ≥ 11
- Maven ≥ 3.8
- Allure CLI
- Git

### Install Allure CLI (macOS)
```bash
brew install allure

1️⃣ Clone the repository
git clone https://github.com/<your-username>/cypress-hybrid-framework.git
cd cypress-hybrid-framework

2️⃣ Install UI dependencies
cd ui-automation
npm install
cd ..

3️⃣ Build API project
cd api-automation
mvn clean install -DskipTests
cd ..

🚀 Running Tests (One Command)
🔹 Run UI + API tests and generate all reports
./run-allure.sh


This command will:

Run Cypress UI tests

Run TestNG API tests

Generate three Allure reports

Preserve history for trends

📊 Allure Reports

After execution, the following reports are generated:

🔹 Unified Report (UI + API)
allure open allure-report-unified

🔹 UI-only Report (Cypress)
allure open allure-report-ui

🔹 API-only Report (TestNG)
allure open allure-report-api


ℹ️ Allure reports must be opened via a local server (allure open), not by double-clicking index.html.

📈 Trend Analysis

Trends are generated automatically after at least two executions

Each report (UI, API, Unified) maintains its own execution history

Trends show pass/fail evolution across builds

🧾 Executors & Environment Info

Each report displays:

Execution source (Local / CI)

Build number

Environment (QA / UAT / PROD)

Framework metadata

Configured automatically via:

executor.json

environment.properties

🔁 CI/CD Ready

This framework is designed to run in:

GitHub Actions

Jenkins

Docker (optional extension)

Artifacts can be published as:

Downloadable Allure reports

GitHub Pages dashboards

🧹 Git Hygiene

The following are intentionally ignored:

node_modules

target

allure-results

allure-report-*

.allure-history

See .gitignore for details.

🧠 Design Philosophy

Result-level separation (UI / API)

Report-level aggregation (Unified)

No reruns for multiple dashboards

Simple execution, advanced reporting

🤝 Contribution

Contributions are welcome!

Fork the repo

Create a feature branch

Commit changes

Open a Pull Request

👤 Author

Sk Amir Ullah
Senior QA & Automation Engineer
Founder – KnowMinds

⭐ If you like this framework

Give it a ⭐ on GitHub and share with your team!