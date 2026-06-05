# selenium-java-enterprise-framework

Java tabanlı kurumsal Selenium test otomasyon framework'ü. Page Object Model pattern, TestNG, Allure raporlama ve GitLab CI entegrasyonu içerir. Fintech ve bankacılık projelerinde kullandığım yapıyı temel alarak oluşturuldu.

## Teknolojiler

- Java 11
- Selenium 4
- TestNG 7
- Allure Reports
- Maven
- WebDriverManager
- GitLab CI

## Kurulum

```bash
git clone https://github.com/fthgmssy/selenium-java-enterprise-framework.git
cd selenium-java-enterprise-framework
mvn clean install -DskipTests
```

## Çalıştırma

```bash
# Tüm testleri çalıştır
mvn test

# Farklı tarayıcı ve ortamla
mvn test -Dbrowser=firefox -Dheadless=true -Dbase.url=https://staging.example.com
```

## Raporlama

```bash
mvn allure:serve
```

Testler tamamlandıktan sonra Allure raporu otomatik olarak tarayıcıda açılır.

## Proje Yapısı

```
src/
├── main/java/
│   ├── base/          # BasePage — tüm page object'ler buradan türer
│   ├── config/        # ConfigReader — properties dosyasını okur
│   ├── driver/        # DriverManager — ThreadLocal WebDriver
│   └── pages/         # sayfa bazlı page object'ler
└── test/java/
    ├── base/          # BaseTest — setUp/tearDown, screenshot
    └── tests/         # test suite'leri
```

## Yapılandırma

`src/main/resources/config.properties` dosyasından yönetilir:

```properties
browser=chrome
headless=false
base.url=https://example.com
implicit.wait=10
explicit.wait=15
screenshot.on.failure=true
```

Tüm değerler `-D` parametresiyle komut satırından ezillebilir.
