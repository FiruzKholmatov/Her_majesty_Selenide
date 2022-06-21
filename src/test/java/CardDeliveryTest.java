import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {

    @Test
    void shouldLoginAccount() {
        Configuration.holdBrowserOpen = true;
        Configuration.headless = true;
        Configuration.browser = "chrome";

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
