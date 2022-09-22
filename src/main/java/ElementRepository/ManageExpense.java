package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageExpense {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='nav-link'])[3]")
	private WebElement managaexpensetab;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	WebElement manageexpensesub;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	public WebElement resetbtn;

	public void clickManagaexpensetab() {
		gu.clickElement(managaexpensetab);

	}

	public void clickManagExpensesub() {

		gu.clickElement(manageexpensesub);

	}

	public String font_search() {
		clickManagaexpensetab();
		String fontsize1 = gu.stylePropertyValidation(newbtn, "font-size");
		return fontsize1;

	}

	public String fontReset() {
		clickManagaexpensetab();
		String fontsize2 = gu.stylePropertyValidation(resetbtn, "font-size");
		return fontsize2;

	}

	public String backGroundSearch() {
		clickManagaexpensetab();
		String bgcolor = gu.stylePropertyValidation(newbtn, "background-color");
		return bgcolor;

	}
}
