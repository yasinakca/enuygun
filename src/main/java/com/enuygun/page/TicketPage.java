package com.enuygun.page;

import com.enuygun.base.BasePage;
import com.enuygun.helper.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketPage extends BasePage {
    private static By ORIGIN_INPUT = By.id("OriginInput");
    private static By DESTINATION_INPUT = By.id("DestinationInput");
    private static By FIRST_ITEM = By.id("react-autowhatever-1-section-0-item-0");
    private static By DESTINATION_FIRST_ITEM = By.id("react-autowhatever-1-section-0-item-0");
    private static By DEPARTURE_DATE = By.xpath("//label[@for='DepartureDate']");
    private static By RETURN_DATE = By.xpath("//label[@for='ReturnDate']");
    private static By CALENDAR = By.xpath("//*[@id=\"FlightSearchForm\"]/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr");

    private static By TRANSIT = By.cssSelector("label[for='transitFilter']");
    private static By PASSENGERS = By.xpath("(//form[@id='FlightSearchForm']/div/div[3]/div/button)[1]");
    private static By ADULT_PASSENGER = By.xpath("(//div[@class='PassengerBox__body']/div/div[2]/button[2])[1]");
    private static By CHILD_PASSENGER = By.xpath("//div[@class='PassengerBox__body']/div[2]/div[2]/button[2]");
    private static By BABY_PASSENGER = By.xpath("//div[@class='PassengerBox__body']/div[3]/div[2]/button[2]");
    private static By OLD_PASSENGER = By.xpath("//div[@class='PassengerBox__body']/div[4]/div[2]/button[2]");
    private static By STUDENT_PASSENGER = By.xpath("//div[@class='PassengerBox__body']/div[5]/div[2]/button[2]");
    private static By ECONOMY = By.xpath("//button[text()='Ekonomi']");
    private static By PREMIUM_ECONOMY = By.xpath("//button[text()='Premium Economy']");
    private static By BUSNINESS = By.xpath("//button[text()='Business']");
    private static By OK_BUTTON = By.xpath("//button[text()='Tamam']");
    private static By CHEAP_FLIGHT_BUTTON = By.xpath("//form[@id='FlightSearchForm']/div/div[3]/div[2]/button");


    public TicketPage(WebDriver driver) {
        super(driver);
    }

    public void fillOrigin(String origin) throws InterruptedException {
        clickWithJs(ORIGIN_INPUT);
        sendKeys(ORIGIN_INPUT, origin);
        clickWithJs(FIRST_ITEM);
    }

    public void fillDestionation(String destination) {
        sendKeys(DESTINATION_INPUT, destination);
        hoverElement(DESTINATION_FIRST_ITEM);
        clickWithJs(DESTINATION_FIRST_ITEM);
    }

    public void clickDepartureDate() {
        clickWithJs(DEPARTURE_DATE);
    }

    public void pickDepartureDate(String gidisTarih) {
        WebElement dateWidget = findElement(By.xpath("(//table[@class='CalendarMonth_table CalendarMonth_table_1'])[2]"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        DateUtil.clickGivenDay(columns, gidisTarih);
    }

    public void clickReturnDate() {
        clickWithJs(RETURN_DATE);
    }

    public void pickReturnDate(String gidisTarih) {
        WebElement dateWidget = findElement(By.xpath("(//table[@class='CalendarMonth_table CalendarMonth_table_1'])[3]"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        DateUtil.clickGivenDay(columns, gidisTarih);
    }

    public void selectTransit() {
        clickWithJs(TRANSIT);
    }

    public void clickPassengers() {
        clickWithJs(PASSENGERS);
    }

    public void selectAdultPassenger(int num) {
        hoverElement(ADULT_PASSENGER);
        for (int i = 1; i < num; i++) {
            clickWithJs(ADULT_PASSENGER);
        }
    }

    public void selectChildPassenger(int num) {
        //num en fazla 8 olabilir, kontrol ekle
        hoverElement(CHILD_PASSENGER);
        for (int i = 0; i < num; i++) {
            clickWithJs(CHILD_PASSENGER);
        }
    }

    public void selectBabyPassenger(int num) {
        hoverElement(BABY_PASSENGER);
        for (int i = 0; i < num; i++) {
            clickWithJs(BABY_PASSENGER);
        }
    }

    public void selectOldPassenger(int num) {
        hoverElement(OLD_PASSENGER);
        for (int i = 0; i < num; i++) {
            clickWithJs(OLD_PASSENGER);
        }
    }

    public void selectStudentPassenger(int num) {
        hoverElement(STUDENT_PASSENGER);
        for (int i = 0; i < num; i++) {
            clickWithJs(STUDENT_PASSENGER);
        }
    }

    public enum TICKETTYPE {
        ECONOMY,
        PREMIUM_ECONOMY,
        BUSINESS
    }

    public void selectTicketType(TICKETTYPE type) {
        switch (type) {
            case ECONOMY:
                //scrollDown(ECONOMY);
                clickWithJs(ECONOMY);
                break;
            case PREMIUM_ECONOMY:
                //scrollDown(PREMIUM_ECONOMY);
                clickWithJs(PREMIUM_ECONOMY);
                break;
            case BUSINESS:
                //scrollDown(BUSNINESS);
                clickWithJs(BUSNINESS);
                break;
        }
    }

    public void clickOkButton() {
        clickWithJs(OK_BUTTON);
    }

    public void clickSearchFlightButton() {
        clickWithJs(CHEAP_FLIGHT_BUTTON);
    }
}
