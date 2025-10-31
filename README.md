# Mobile App Automation using Appium

##  Overview
This project automates the **Android Calculator App** using **Appium**, **TestNG**, and **Selenium**, following the **Page Object Model (POM)** architecture.  
It performs both **direct arithmetic testing** and **CSV-driven series evaluations**, and generates **Allure Reports** for test visualization.

---

##  Tech Stack
| Component | Technology |
|------------|-------------|
| Programming Language | Java |
| Test Framework | TestNG |
| Automation Framework | Appium |
| Web Interaction | Selenium |
| Reporting | Allure Reports |
| Build Tool | Gradle |
| Data Handling | Apache Commons CSV |

---

##  Features
- Automates Android **Calculator App** on emulator/device  
- Performs **Addition, Subtraction, Multiplication, Division**  
- Handles **complex arithmetic series** (e.g., `100/10*5-10+60`)  
- Executes **data-driven tests** from `data.csv` via **TestNG DataProvider**  
- Uses **Page Object Model (POM)** for cleaner structure  
- Generates detailed **Allure Reports**   

---

## Test Execution Flow

###  **Test Class:** `CalcTestRunner.java`

| Priority | Test Method | Description | Example | Expected Result |
|-----------|-------------|--------------|----------|-----------------|
| 1 | `doSum()` | Verifies addition of two numbers | 4 + 3 | 7 |
| 2 | `doMinus()` | Verifies subtraction | 9 - 8 | 1 |
| 3 | `doMul()` | Verifies multiplication | 5 × 6 | 30 |
| 4 | `doDiv()` | Verifies division | 6 ÷ 2 | 3 |
| 5 | `doSeries()` | Verifies series calculation | 100/10*5-10+60 | 100 |
| 6 | `doSeriesFromCSV()` | Verifies multiple expressions from CSV | data.csv | as expected |

---

### `data/data.csv` 

| expression | expected |
|-------------|-----------|
| 50+40-30/2+20 | 95 |
| 10*2/2+10-20 | 0 |
| 4pi2^3 | 100.53 |
| 5! | 120 |


---
## Output & Reports

### Allure Report Summary
<img width="1358" height="650" alt="mobile_app_all" src="https://github.com/user-attachments/assets/75183b17-4e53-4bad-ac17-30dfab00d607" />
<img width="1358" height="650" alt="mobile_app_behavior" src="https://github.com/user-attachments/assets/ff53bd67-62d0-4c8c-bf1e-d729e2900924" />

### Recording of Automation
https://github.com/user-attachments/assets/2d231735-d2ea-4baa-974f-58baaf86eae5

---
## ⚙️ How to Run the Project

<details>
<summary><b>Setup & Prerequisites</b></summary>

### Install and Configure Android Studio
Add environment variables:
**User Variable:** 
APPIUM_HOME = C:\Users<user>\AppData\Local\Android\Sdk
**System PATH additions:**
%APPIUM_HOME%\platform-tools
%APPIUM_HOME%\emulator
%APPIUM_HOME%\build-tools

---

### Install Appium & Drivers
```bash
npm install -g appium
appium -v
appium driver list
appium install driver uiautomator2
appium plugin install execute-driver
appium

```
### Configure Appium Inspector
Start a session with the following JSON capabilities:
```bash
{
  "platformName": "Android",
  "appium:os": "16",
  "appium:app": "path/to/calculator.apk",
  "appium:appPackage": "com.google.android.calculator",
  "appium:appActivity": "com.android.calculator2.Calculator",
  "appium:automationName": "UIAutomator2",
  "appium:disableAndroidWatchers": true,
  "appium:uiautomator2ServerLaunchTimeout": 120000
}
```
Use the Appium Inspector to identify element locators for button interactions.
</details>

### Execution commands
Run tests and generate reports:
```bash
gradle clean test
allure generate allure-results --clean -o allure-report
allure serve allure-results
```

