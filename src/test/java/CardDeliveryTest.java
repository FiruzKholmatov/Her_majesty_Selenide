import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    void shouldLoginAccount () {
        Configuration.holdBrowserOpen = true;

        open("http://localhost:9999/");

       $x("//input[@placeholder='Город']").val("Москва");
       $x("//input[@placeholder='Дата встречи']").val("24.06.2022");
       $(By.cssSelector("[data-test-id='name'] input")).val("Бендер Остап");
       $(By.cssSelector("[data-test-id='phone'] input")).val("+79660000000");
       $x("//*[@role='presentation']").click();
       $x("//span[text()='Забронировать']").click();
       $x("//div[@data-test-id='notification']").should(visible, Duration.ofSeconds(15));












    }
}
