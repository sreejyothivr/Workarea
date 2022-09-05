package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageSliderTab {
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManageSliderTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	LoginPage lp = new LoginPage(driver);

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[10]/a")
	WebElement managaeslidertab;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	public WebElement title;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[3]/td[1]")
	WebElement image;

	public void clickManagesliderTab() {
		gu.clickElement(managaeslidertab);

	}

	public String getTabname() {
		String titltext = gu.getElementText(title);
		return (titltext);
	}

	public boolean imageDisplay() throws InterruptedException {
		gu.mediumDelay();
		gu.mediumDelay();
		return gu.checkCheckBoxSelected(image);
	}
}
