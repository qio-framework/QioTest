package qio;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class QioTodoTest {

    private static final String BASE_URI = "http://localhost:9290/q";

    protected ChromeDriver browser;

    @BeforeAll
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/mcroteau/WebDrivers/Chrome/chromedriver");
        browser = new ChromeDriver();
    }

    @Test
    public void atestHello() throws Exception {
        browser.get(BASE_URI);
        browser.navigate();
        WebElement element = browser.findElement(new By.ById("hello"));
        assertTrue(element.getText().equals("Welcome!"));
    }

    @Test
    public void btestCreate(){
        browser.get(BASE_URI);
        WebElement helloElement = browser.findElement(new By.ById("todos-href"));
        helloElement.click();
        assertTrue((BASE_URI + "/todos").equals(browser.getCurrentUrl()));
    }

    @AfterAll
    protected void tearDown() {
        browser.quit();
    }
}
