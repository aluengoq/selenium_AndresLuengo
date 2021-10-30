package ExamenSeleniumIntermedio.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "confirm")
    WebElement confirmField;

    public void fillInput(String emailInput) {
        emailField.sendKeys(emailInput);
    }

    public void clickOnConfirmField() {
        confirmField.click();
    }

    public boolean isErrorMsgDisplayed(String errorMsg) {
        return driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", errorMsg))).isDisplayed();
    }

}
