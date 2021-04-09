package exemple.poc.utils

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class ChromeConfig {

    lateinit var driver: WebDriver

    fun startChorme(){
        // Use unless open browser
         val options = ChromeOptions()
         options.addArguments("--headless")

        System.setProperty(
            "webdriver.chrome.driver",
            System.getProperty("user.dir") + "/src/test/resources/tools/chromedriver"
        )
        driver = ChromeDriver(options)
    }

    fun stopChrome(){
        if (driver != null) {
            driver.quit()
        }
    }

    fun fillInput(name: String?, element: WebElement) {
        element.clear()
        element.sendKeys(name);
    }

    fun click(element: WebElement) {
        element.click();
    }

    fun findElementByXpath(value: String): WebElement {
        val element: WebElement = driver.findElement(By.xpath(value));
        return element
    }
    fun findElementById(value: String): WebElement {
        val element: WebElement = driver.findElement(By.id(value));
        return element
    }

    fun findElementByName(value: String): WebElement {
        val element: WebElement = driver.findElement(By.name(value));
        return element
    }

    fun findElementByText(value: String?): WebElement {
        val element: WebElement = driver.findElement(By.partialLinkText(value))
        return element
    }
}