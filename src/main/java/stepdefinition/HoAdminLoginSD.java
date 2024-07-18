package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HoAdminLoginSD {
  //  @Given("I am on login page")
//    public void adminloginpage()
//    {
//        System.out.println("I am on login page");
//    }

    @Given("I am on login page")
    public void i_am_on_login_page() {
        System.out.println("I am on login page");
    }
    @When("I have does't enter email id and password")
    public void i_have_does_t_enter_email_id_and_password() {
        System.out.println("I have does't enter email id and password");
    }
    @When("I click on continue button")
    public void i_click_on_continue_button() {
        System.out.println("I click on continue button");
    }
    @Then("Required field validation properly shown")
    public void required_field_validation_properly_shown() {
        System.out.println("Required field validation properly shown");
    }

}
