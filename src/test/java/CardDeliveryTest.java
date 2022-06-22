import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {

    String planningDate = GenerateDate.generateDate(3);


    @Test
    void shouldLoginAccount() {
        Configuration.holdBrowserOpen = true;
        Configuration.headless = true;


        open("http://localhost:9999/");

        $x("//input[@placeholder='Город']").val("Москва");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $(By.cssSelector("[data-test-id='name'] input")).val("Лиходеев Степан");
        $(By.cssSelector("[data-test-id='phone'] input")).val("+79660000000");
        $x("//*[@role='presentation']").click();
        $x("//span[text()='Забронировать']").click();
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);


    }

    public static class GenerateDate {
       public static String generateDate (int days) {
            return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }


}
