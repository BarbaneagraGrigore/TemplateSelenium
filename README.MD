# Selenium Template

## Overview
This project is designed for Selenium automation testing.

### Prerequisites
- Java
- Maven
- One of the browsers installed: 
  - ChromeDriver 130.0.6723.92 (64-bit)
  - EdgeDriver 130.0.2849.68 (64-bit)
  - FireFoxDriver 132.0 (64-bit)

### Setup
1. Build project:
   ```bash
   mvn clean install -DskipTests

2. Create report:
   ```bash
   mvn surefire-report:report
   
3. 
4. See report target/reports/surefire.html