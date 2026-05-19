# selenium-java-enterprise-framework

Java tabanlı kurumsal Selenium test otomasyon framework'ü. Page Object Model, TestNG, Allure raporlama ve GitLab CI entegrasyonu içerir.

## Teknolojiler

- Java 11
- Selenium 4
- TestNG
- Allure Reports
- Maven
- WebDriverManager

## Kurulum

```bash
git clone https://github.com/fthgmssy/selenium-java-enterprise-framework.git
cd selenium-java-enterprise-framework
mvn clean install -DskipTests
```

## Çalıştırma

```bash
mvn test
```

Farklı tarayıcı veya ortamla çalıştırmak için:

```bash
mvn test -Dbrowser=firefox -Dheadless=true -Dbase.url=https://staging.example.com
```

## Raporlama

```bash
mvn allure:serve
```

## Yapı

```
src/
├── main/java/
│   ├── base/          # BasePage
│   ├── config/        # ConfigReader
│   └── driver/        # DriverManager (ThreadLocal)
└── test/java/
    ├── base/          # BaseTest
    └── tests/         # test suite'leri
```
