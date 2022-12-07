package Testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;

public class LoginTestcases extends BaseClass {
	LoginPage lp;
	List<String> loginList;

	public void presteps() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassWord("admin");
	}

	@Test(dataProvider = "data")
	// @Test
	public void verifyLoggedUsers(String username, String password) {
		lp = new LoginPage(driver);
		loginList = lp.getLoginDetails();
		System.out.println(loginList);
		/*
		 * Adding from Excel lp.getUserName(loginList.get(0));
		 * lp.getPassWord(loginList.get(1));
		 * 
		 * //lp.presteps();
		 */

		lp.getUserName(username);
		lp.getPassWord(password);
		lp.clickSignin();
		String actual = lp.profileVerification();
		String expected = "admin";
		Assert.assertEquals(expected, actual, "Admin Name is not as we expected");

	}

	@DataProvider(name = "data")
	public Object[][] getUserData() {
		return new Object[][] { { "admin", "admin" }, { "admin2", "admin2" } };
	}

}
