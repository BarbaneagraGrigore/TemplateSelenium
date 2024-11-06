package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static utils.PropertiesReaderUtils.readProperty;

public class WebDriverUtils {

    private static WebDriver webDriver;
    private static final ChromeOptions CHROME_OPTIONS = new ChromeOptions();
    private static final EdgeOptions EDGE_OPTIONS = new EdgeOptions();
    private static final FirefoxOptions FIREFOX_OPTIONS = new FirefoxOptions();

    protected WebDriverUtils() {
        if (webDriver == null) webDriver = initializeWebDriver(
                readProperty("browser"),
                readProperty("headless"));
    }

    protected static WebDriver getWebDriver() {
        return webDriver;
    }

    protected static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    private static WebDriver initializeWebDriver(String browserName, String headless) {
        switch (browserName.toLowerCase()) {
            case "edge":
                System.setProperty("webdriver.edge.driver", readProperty("pathToEdgeDriver"));
                if ("true".equalsIgnoreCase(headless)) {
                    EDGE_OPTIONS.addArguments("--headless");
                }
                return new EdgeDriver(EDGE_OPTIONS);

            case "firefox":
                System.setProperty("webdriver.gecko.driver", readProperty("pathToFirefoxDriver"));
                if ("true".equalsIgnoreCase(headless)) {
                    FIREFOX_OPTIONS.addArguments("--headless");
                }
                return new FirefoxDriver(FIREFOX_OPTIONS);

            default:
                System.setProperty("webdriver.chrome.driver", readProperty("pathToChromeDriver"));
                if ("true".equalsIgnoreCase(headless)) {
                    CHROME_OPTIONS.addArguments("--headless");
                }
                return new ChromeDriver(CHROME_OPTIONS);
        }
    }
}