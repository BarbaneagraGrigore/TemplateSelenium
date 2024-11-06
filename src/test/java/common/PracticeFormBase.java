package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.PracticeFormPage;
import utils.WebDriverUtils;

import static utils.PropertiesReaderUtils.readProperty;

public class PracticeFormBase extends WebDriverUtils {

    protected PracticeFormPage practiceFormPage;

    protected PracticeFormBase() {
        this.practiceFormPage = PageFactory.initElements(getWebDriver(), PracticeFormPage.class);
    }

    protected void clickElement(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();", element);
    }

    protected void loadURL() {
        getWebDriver().get(readProperty("url"));
    }
}