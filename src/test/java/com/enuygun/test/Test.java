package com.enuygun.test;

import com.enuygun.base.BaseTest;
import com.enuygun.page.FlightDetailPage;
import com.enuygun.page.HomePage;
import com.enuygun.page.TicketPage;
import org.junit.Before;
import java.util.concurrent.TimeUnit;

public class Test extends BaseTest {
    HomePage homePage;
    TicketPage ticketPage;
    FlightDetailPage flightDetailPage;

   @Before
    public void before() {
        homePage = new HomePage(driver);
        ticketPage = new TicketPage(driver);
        flightDetailPage = new FlightDetailPage(driver);
    }

    @org.junit.Test
    public void endToEnd() throws InterruptedException {
        homePage.submitHomePage();
        TimeUnit.MILLISECONDS.sleep(1000);
        ticketPage.fillOrigin("Istabul");
        TimeUnit.MILLISECONDS.sleep(1000);
        ticketPage.fillDestionation("Ankara");
        ticketPage.clickDepartureDate();
        ticketPage.pickDepartureDate("14");
        ticketPage.clickReturnDate();
        ticketPage.pickReturnDate("20");
        ticketPage.selectTransit();
        ticketPage.clickPassengers();
        ticketPage.selectAdultPassenger(1);
        ticketPage.selectChildPassenger(2);
        ticketPage.selectBabyPassenger(1);
        ticketPage.selectOldPassenger(1);
        ticketPage.selectStudentPassenger(1);
        ticketPage.selectTicketType(TicketPage.TICKETTYPE.ECONOMY);
        ticketPage.clickOkButton();
        ticketPage.clickSearchFlightButton();
        TimeUnit.SECONDS.sleep(5);
    }
}
