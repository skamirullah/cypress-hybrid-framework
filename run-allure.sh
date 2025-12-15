#!/bin/bash
set -e

echo "🧹 Cleaning old reports"
rm -rf allure-report-*
mkdir -p allure-results/{ui,api,merged}/{history}

BUILD_NUMBER=$(date +"%Y%m%d%H%M%S")

create_executor() {
cat <<EOT > $1/executor.json
{
  "name": "Sk Amir Ullah",
  "type": "local",
  "buildName": "Build-$BUILD_NUMBER",
  "buildOrder": $BUILD_NUMBER
}
EOT
}

create_executor allure-results/ui
create_executor allure-results/api
create_executor allure-results/merged

# Restore history
cp -r .allure-history/ui/* allure-results/ui/history 2>/dev/null || true
cp -r .allure-history/api/* allure-results/api/history 2>/dev/null || true
cp -r .allure-history/merged/* allure-results/merged/history 2>/dev/null || true

# Run UI tests
cd ui-automation
npx cypress run
cd ..

# Run API tests
cd api-automation
mvn clean test
cd ..

# Merge results
cp -r allure-results/ui/*.json allure-results/merged/
cp -r allure-results/api/*.json allure-results/merged/

# Generate reports
allure generate allure-results/ui --clean -o allure-report-ui
allure generate allure-results/api --clean -o allure-report-api
allure generate allure-results/merged --clean -o allure-report-unified

# Save history
mkdir -p .allure-history/{ui,api,merged}
cp -r allure-report-ui/history .allure-history/ui
cp -r allure-report-api/history .allure-history/api
cp -r allure-report-unified/history .allure-history/merged

echo "✅ All reports generated with Trend & Executors"