package test14;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T_03_Assertions {
	String value = "Java";

	@Test
	public void HardAssert() {
		System.out.println("Step 1");

		Assert.assertTrue(false);

		System.out.println("Step 2");

		Assert.assertFalse(true);

		System.out.println("Step 3");

		Assert.assertEquals("Selenium", value);

		System.out.println("Step 4");
	}

	@Test
	public void SoftAssert() {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("Step 1");

		softAssert.assertTrue(false);

		System.out.println("Step 2");

		softAssert.assertFalse(true);

		System.out.println("Step 3");

		softAssert.assertEquals("Selenium", value);

		System.out.println("Step 4");

		softAssert.assertAll(); // * Mandatory
	}

}
