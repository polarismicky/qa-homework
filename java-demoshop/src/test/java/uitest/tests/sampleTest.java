// Ranorex Webtestit Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.pageobjects.*;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

class sampleTest extends TestNgTestBase {
    protected String loginUrl = "https://platform.rescale.com/login/";
    protected String dashboardUrl = "https://platform.rescale.com/files/";
    protected String email = "polarismicky@gmail.com";
    protected String password = "Ploves0*";
    protected String path = "/Users/yanwenhu/Desktop/README1.txt";

    @Test
    public void SampleTestCase() throws InterruptedException {
        WebDriver driver = getDriver();
        // 1.Sign in to Rescale Platform
        signerPo newSignerPo = new signerPo(driver);
        newSignerPo.open(loginUrl);
        newSignerPo.editInWithEmail(email);
        newSignerPo.signInWithPassword(password);
        // 2.Upload one file
        platformPo newPlatform = new platformPo(driver);
        newPlatform.open(dashboardUrl);
        newPlatform.uploadFile(path);
        // 3.Check the uploaded file name is the same as expected
        String newFileName = newPlatform.getFileName();
        Assert.assertEquals(newFileName, "README.txt");
    }
}
