const fs = require("fs");
const path = require("path");

const resultsDir = path.join(__dirname, "../allure-results");

if (!fs.existsSync(resultsDir)) {
  fs.mkdirSync(resultsDir, { recursive: true });
}

const envContent = "Framework=Hybrid Automation\nEnvironment=QA";

fs.writeFileSync(path.join(resultsDir, "environment.properties"), envContent);
console.log("Allure environment.properties created ✅");