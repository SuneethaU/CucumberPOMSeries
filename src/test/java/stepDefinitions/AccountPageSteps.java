package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AccountsPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class AccountPageSteps {

    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;
    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String,String>> credList = dataTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginpage.doLogin(userName,password);
    }

    @Given("user is on accounts page")
    public void  user_is_on_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("accounts page title is "+title);

    }

    @Then("user gets account section")
    public void user_gets_account_section(DataTable sectionsTable) {
        List<String> expectedAccountSectionList = sectionsTable.asList();
        System.out.println(" Expected Account Section List "+ expectedAccountSectionList);
        List<String> actualAccountSectionList = accountsPage.getAccountsSectionsList();
        System.out.println(" Actual Account Section List "+ actualAccountSectionList);
        Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountsPage.getAccountsSectionCount()==expectedSectionCount);

    }
}
