package test14;

import org.testng.Assert;
import org.testng.annotations.Test;

public class T_04_Dependency {

	@Test(priority = 1)
	public void Open() {
		System.out.println("Open");
	}

	@Test(priority = 2, dependsOnMethods = "Open")
	public void Register() {
		System.out.println("Register");
		Assert.assertTrue(false);
	}

	@Test(priority = 3, dependsOnMethods = "Register")
	public void Login() {
		System.out.println("Login");
	}

	@Test(priority = 4, dependsOnMethods = "Login")
	public void Logout() {
		System.out.println("Logout");
	}

	@Test(priority = 5, dependsOnMethods = "Open")
	public void Close() {
		System.out.println("Close");
	}

}
