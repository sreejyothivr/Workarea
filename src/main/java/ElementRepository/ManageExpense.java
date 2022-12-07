package ElementRepository;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[3]/td[9]/a[1]/i")
	public WebElement editbutton;
	
	

	@FindBy(xpath="//input[@class='form-control date']")
	public WebElement datetextarea;
	

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
	
	public void clickeditbtn()
	{
		gu.clickElement(editbutton);
	}
	
	public void datepicker() throws InterruptedException
	{
		 clickeditbtn();
		 gu.clickElement(datetextarea);
		 
		 System.out.println(driver.findElement(By.xpath("//th[normalize-space()='October 2022']")).getText());
		 
		 gu.mediumDelay();
			while(!driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("August 2021"))
			{
				
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")).click();
			
			}


		//gu.mediumDelay();
			//Grab common attribute//Put into list and iterate
			int count=driver.findElements(By.xpath("//td[@class='day']")).size();

			for(int i=0;i<count;i++)
			{
			String text=driver.findElements(By.className("//td[@class='day']")).get(i).getText();
			if(text.equalsIgnoreCase("27"))
			{
			driver.findElements(By.className("//td[@class='day']")).get(i).click();
			break;
			}


		}
		 
		
	}
}
