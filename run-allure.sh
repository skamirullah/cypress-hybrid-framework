#!/bin/bash

echo "=============================="
echo "🚀 Hybrid Automation Execution"
echo "=============================="

# -------------------------------
# Clean previous reports (NOT history)
# -------------------------------
echo "🧹 Cleaning old reports"
rm -rf allure-report-*

# -------------------------------
# Ensure required directories
# -------------------------------
mkdir -p allure-results/{ui,api,merged}
mkdir -p .allure-history/{ui,api,merged}

# -------------------------------
# Build metadata
# -------------------------------
BUILD_NUMBER=$(date +"%Y%m%d%H%M%S")

create_executor() {
cat <<EOT > "$1/executor.json"
{
  "name": "Sk Amir Ullah",
  "type": "local",
  "buildName": "Build-$BUILD_NUMBER",
  "buildOrder": $BUILD_NUMBER
}
EOT
}

echo "🧾 Creating executor metadata"
create_executor allure-results/ui
create_executor allure-results/api
create_executor allure-results/merged

# -------------------------------
# Restore history (TREND)
# -------------------------------
echo "📈 Restoring history for trends"
cp -r .allure-history/ui/* allure-results/ui/ 2>/dev/null || true
cp -r .allure-history/api/* allure-results/api/ 2>/dev/null || true
cp -r .allure-history/merged/* allure-results/merged/ 2>/dev/null || true

# -------------------------------
# Run UI tests
# -------------------------------
echo "▶ Running UI Automation (Cypress)"
cd ui-automation
npx cypress run || true
cd ..

# -------------------------------
# Run API tests
# -------------------------------
echo "▶ Running API Automation (TestNG)"
cd api-automation
mvn clean test || true
cd ..

# -------------------------------
# Merge results (FULL merge)
# -------------------------------
echo "🔗 Merging UI + API results"
cp -r allure-results/ui/* allure-results/merged/ 2>/dev/null || true
cp -r allure-results/api/* allure-results/merged/ 2>/dev/null || true

# -------------------------------
# Add environment & categories (CRITICAL)
# -------------------------------
echo "🧾 Adding environment & categories metadata"

for scope in ui api merged; do
  if [[ -f environment.properties ]]; then
    cp environment.properties allure-results/$scope/
  else
    echo "⚠️ environment.properties not found"
  fi

  if [[ -f categories.json ]]; then
    cp categories.json allure-results/$scope/
  else
    echo "⚠️ categories.json not found"
  fi
done

# -------------------------------
# Generate Allure reports
# -------------------------------
echo "📊 Generating Allure reports"

allure generate allure-results/ui -o allure-report-ui --clean
allure generate allure-results/api -o allure-report-api --clean
allure generate allure-results/merged -o allure-report-unified --clean

# -------------------------------
# Persist history for next run (TREND)
# -------------------------------
echo "💾 Saving history for next execution"

cp -r allure-report-ui/history .allure-history/ui
cp -r allure-report-api/history .allure-history/api
cp -r allure-report-unified/history .allure-history/merged

echo "✅ All reports generated successfully"
echo "➡ UI Report       : allure open allure-report-ui"
echo "➡ API Report      : allure open allure-report-api"
echo "➡ Unified Report  : allure open allure-report-unified"
