package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(xpath = "//label[text()='Male']")
    public WebElement genderMaleRadioButton;

    @FindBy(id = "userNumber")
    public WebElement userNumber;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(className = "modal-header")
    public WebElement confirmationMessage;
}