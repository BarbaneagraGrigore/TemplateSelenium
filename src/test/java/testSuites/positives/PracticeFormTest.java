package testSuites.positives;

import common.PracticeFormBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PracticeFormTest extends PracticeFormBase {

    @BeforeEach
    void navigateToURL() {
        loadURL();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData/formData.csv", numLinesToSkip = 1)
    @DisplayName("Submit practice form with minimum fields")
    void testSubmitFormMinimumFields(String firstName, String lastName, String userNumber) {
        practiceFormPage.firstName.sendKeys(firstName);
        practiceFormPage.lastName.sendKeys(lastName);
        clickElement(practiceFormPage.genderMaleRadioButton);
        practiceFormPage.userNumber.sendKeys(userNumber);
        clickElement(practiceFormPage.submitButton);
        assertTrue(practiceFormPage.confirmationMessage.getText().contains("Thanks for submitting the form"));
    }

    @AfterEach
    public void tearDown() {
        quitDriver();
    }
}