package testSuites.negatives;

import common.PracticeFormBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PracticeFormTest extends PracticeFormBase {

    @BeforeEach
    void navigateToURL() {
        loadURL();
    }

    @Test
    @DisplayName("Submit empty practice form")
    void testSubmitEmptyForm() {
        clickElement(practiceFormPage.submitButton);
        assertTrue(practiceFormPage.firstName.getAttribute("value").isEmpty());
        assertTrue(practiceFormPage.lastName.getAttribute("value").isEmpty());
        assertTrue(practiceFormPage.userNumber.getAttribute("value").isEmpty());
    }

    @AfterEach
    void tearDown() {
        quitDriver();
    }
}