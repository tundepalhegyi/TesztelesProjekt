package ro.sapientia.mesteri2018.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EpicUpdateStepDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I edit the epic list's first epic$")
	public void I_edit_the_epic_list_s_first_epic() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox and I push the update button$")
	public void I_enter_in_the_title_textbox_and_I_push_the_update_button(String updateTitle) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement firstItem = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[1]/a"));
		firstItem.click();
		//driver.wait(1000);
		WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/a[1]"));
		updateButton.click();
		//driver.wait(1000);
		WebElement titleField = driver.findElement(By.id("epic-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(updateTitle);
		
		WebElement updateEpicButton = driver.findElement(By.id("update-epic-button"));
		updateEpicButton.click();
	
	}
	
	@Then("^I should get result \"([^\"]*)\" in new epics list$")
	public void I_should_get_result_in_new_epics_list(String expectedResult) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement titleText = driver.findElement(By.id("epic-title"));
		String result = titleText.getText();

		// Verify that result of 2+2 is 4
		Assert.assertEquals(result, expectedResult);
		//Assert.assertNotSame(result, expectedResult);
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
