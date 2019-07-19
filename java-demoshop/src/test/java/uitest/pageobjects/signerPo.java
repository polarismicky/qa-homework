// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class signerPo {

    private By usernameInput = By.cssSelector("input.active-input");
    private By editButton = By.cssSelector("div.next-step");
    private By passwordInput = By.xpath(".//input[@name='password']");
    private By signInButton = By.cssSelector("button.input-link");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public signerPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public signerPo open(String url) {
        this.driver.get(url);

        return this;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public signerPo editInWithEmail(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.usernameInput)).clear();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.usernameInput)).sendKeys(text);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.editButton)).click();

        return new signerPo(driver);
    }

    public signerPo signInWithPassword(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.passwordInput)).clear();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.passwordInput)).sendKeys(text);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.signInButton)).click();

        return this;
    }

}
