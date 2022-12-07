package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.RandomDataUtility;

public class HomePage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	RandomDataUtility rd= new RandomDataUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileName;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement abcd;// change it

	public String displayProfileName() {
	
		return gu.getElementText(profileName);
		
		
	}

}
