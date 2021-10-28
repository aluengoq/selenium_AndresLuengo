package ExamenEjemplo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy(xpath = "//*[contains(text(),'2 guests')]")
    List<WebElement> twoGuestsList;

    @FindBy(tagName = "h1")
    WebElement h1;

    public int getTwoGuestListSize() throws InterruptedException {
        Thread.sleep(3000);
        return twoGuestsList.size();
    }

    public String getH1Text() {
        return h1.getText();
    }
}
