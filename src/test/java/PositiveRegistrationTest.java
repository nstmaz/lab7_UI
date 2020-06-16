import com.volsu.UI.Models.Account;
import com.volsu.UI.pageObject.AccountCreationForm;
import com.volsu.UI.pageObject.MainPage;
import com.volsu.UI.pageObject.SignInForm;
import com.volsu.UI.utils.EmailGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveRegistrationTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(PositiveRegistrationTest.class);

    @Autowired
    SignInForm signInForm;

    @Autowired
    AccountCreationForm accountCreationForm;

    @Test(dataProvider = "accountDP")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Successful registration, all fields are filled")
    @DisplayName("Full successful user registration")
    public void fullRegistrationPositive(Account account) {

        MainPage mainPage = new MainPage(webdriver);
        mainPage.clickSignIn();

        signInForm.fillForm(account.getEmail());
        signInForm.clickCreateAccountButton();

        accountCreationForm.fullRegistration(account);
        log.info("Verify successful user registration.");
        Assert.assertTrue(accountCreationForm.isRegistrationSuccessful());
    }

    @DataProvider(name = "accountDP")
    public Object[][] accountDP() {

        Account account = new Account();
        account.setGender("male");
        account.setFirstName("Leo");
        account.setLastName("Williams");
        account.setEmail(EmailGenerator.createEmail());
        account.setPassword("qwerty");
        account.setBirthDay("1");
        account.setBirthMonth("1");
        account.setBirthYear("1990");
        account.setNewsletter(true);
        account.setSpecialOffers(false);
        account.setCompany("Some company name");
        account.setAddress("Your address here");
        account.setAddress2("Address line2 here");
        account.setCity("Some-city");
        account.setState("Wyoming");
        account.setPostalCode("00000");
        account.setCountry("United States");
        account.setAdditionalInfo("You can type additional info here");
        account.setHomePhone("000000");
        account.setMobilePhone("00000000000");
        account.setAddressAlias("Address alias here");

        return new Object[][] {
                {account}
        };
    }
}