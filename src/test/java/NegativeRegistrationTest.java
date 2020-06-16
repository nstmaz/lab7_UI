import com.volsu.UI.Models.Account;
import com.volsu.UI.pageObject.AccountCreationForm;
import com.volsu.UI.pageObject.MainPage;
import com.volsu.UI.pageObject.SignInForm;
import com.volsu.UI.utils.EmailGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeRegistrationTest extends BaseTest {

    @Autowired
    SignInForm signInForm;

    @Autowired
    AccountCreationForm accountCreationForm;

    @Test(dataProvider = "accountDP")
    @Severity(SeverityLevel.NORMAL)
    @Description("User registration with empty required fields.")
    @DisplayName("Required fields are empty.")
    public void registrationRequiredFieldsAreEmpty(Account account) {
        MainPage mainPage = new MainPage(webdriver);
        mainPage.clickSignIn();

        signInForm = new SignInForm(webdriver);
        signInForm.fillForm(account.getEmail());
        signInForm.clickCreateAccountButton();

        accountCreationForm = new AccountCreationForm(webdriver);

        accountCreationForm.registrationNoRequiredFields(account);
        Assert.assertTrue(accountCreationForm.errorMessageCheck());
    }

    @DataProvider(name = "accountDP")
    public Object[][] accountDP() {

        Account account = new Account();
        account.setGender("male");
        account.setEmail(EmailGenerator.createEmail());
        account.setBirthDay("1");
        account.setBirthMonth("1");
        account.setBirthYear("1990");
        account.setNewsletter(true);
        account.setSpecialOffers(false);
        account.setCompany("Some company name");
        account.setAddress2("Address line2 here");
        account.setState("Wyoming");
        account.setCountry("United States");
        account.setAdditionalInfo("You can type additional info here");

        return new Object[][] {
                {account}
        };
    }

}
