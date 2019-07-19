// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class platformPo {

    private By fileUploadButton = By.cssSelector("label#filesPageDropZone");
    private By fileName = By.cssSelector("td:nth-child(2)");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public platformPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public platformPo open(String url) {
        this.driver.get(url);

        return this;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public platformPo uploadFile(String path) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.fileUploadButton)).sendKeys(path);
        // driver.findElement(By.cssSelector("label#filesPageDropZone")).sendKeys(path);
        return new platformPo(driver);
    }

    public String getFileName() {
        String fileNameText = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.fileName)).getText();

        return fileNameText;
    }

}
