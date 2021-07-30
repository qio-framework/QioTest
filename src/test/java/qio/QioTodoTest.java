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
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/WebDrivers/Chrome/chromedriver");
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

    @Test
    public void ctestSave(){
        browser.get(BASE_URI+ "/todos/create");

        WebElement titleInput = browser.findElement(new By.ById("title"));
        titleInput.sendKeys("Complete testing!");

        WebElement saveButton = browser.findElement(new By.ById("save"));
        saveButton.click();

        WebElement todo = browser.findElement(new By.ById("todo-4"));
        System.out.println("u" + todo.getText());
        assertTrue("Complete testing!".equals(todo.getText()));
    }

    @Test
    public void dtestUpdate() throws Exception {
        browser.get(BASE_URI + "/todos/edit/1");

        WebElement titleInput = browser.findElement(new By.ById("title"));

        titleInput.clear();
        titleInput.sendKeys("Exercise. Yes!");

        WebElement updateButton = browser.findElement(new By.ById("update"));
        updateButton.click();

        browser.get(BASE_URI + "/todos/edit/1");
        WebElement titleInputDos = browser.findElement(new By.ById("title"));
        assertTrue("Exercise. Yes!".equals(titleInputDos.getAttribute("value")));
    }

    @Test
    public void ftestDelete(){
        browser.get(BASE_URI + "/todos");

        WebElement deleteBtn = browser.findElement(new By.ById("delete-2"));
        deleteBtn.click();

        WebElement count = browser.findElement(new By.ById("count"));
        assertTrue("3".equals(count.getText()));
    }

    @AfterAll
    protected void tearDown() {
        browser.quit();
    }
}
